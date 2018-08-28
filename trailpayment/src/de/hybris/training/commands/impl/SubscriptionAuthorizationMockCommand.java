package de.hybris.training.commands.impl;

import de.hybris.platform.payment.commands.SubscriptionAuthorizationCommand;
import de.hybris.platform.payment.commands.impl.GenericMockCommand;
import de.hybris.platform.payment.commands.request.SubscriptionAuthorizationRequest;
import de.hybris.platform.payment.commands.result.AuthorizationResult;
import de.hybris.platform.payment.dto.CvnStatus;
import de.hybris.platform.payment.dto.TransactionStatus;
import de.hybris.platform.payment.dto.TransactionStatusDetails;

import java.util.Date;


public class SubscriptionAuthorizationMockCommand extends GenericMockCommand implements SubscriptionAuthorizationCommand
{

	private static final String INVALID = "invalid";

	@Override
	public AuthorizationResult perform(final SubscriptionAuthorizationRequest request)
	{

		final AuthorizationResult result = new AuthorizationResult();

		result.setCurrency(request.getCurrency());
		result.setTotalAmount(request.getTotalAmount());
		result.setAuthorizationTime(new Date());

		if (request.getSubscriptionID().equalsIgnoreCase(INVALID))
		{
			result.setTransactionStatus(TransactionStatus.REJECTED);
			result.setTransactionStatusDetails(TransactionStatusDetails.INVALID_SUBSCRIPTION_ID);
		}
		else
		{
			if (request.getCv2() == null)
			{
				result.setTransactionStatus(TransactionStatus.ACCEPTED);
				result.setTransactionStatusDetails(TransactionStatusDetails.SUCCESFULL);
			}
			else
			{
				final Integer i = Integer.valueOf(request.getCv2());
				try
				{
					if (i % 2 == 0)
					{
						result.setTransactionStatus(TransactionStatus.ACCEPTED);
						result.setTransactionStatusDetails(TransactionStatusDetails.SUCCESFULL);
						result.setCvnStatus(CvnStatus.MATCHED);
					}
				}
				catch (final Exception e)
				{
					result.setTransactionStatus(TransactionStatus.REJECTED);
					result.setTransactionStatusDetails(TransactionStatusDetails.INVALID_CVN);
					result.setCvnStatus(CvnStatus.UNRECOGNIZED_RESULT);
				}
			}
		}

		genericPerform(request, result);

		return result;
	}

}
