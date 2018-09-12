package de.hybris.training.facades.populators;

import de.hybris.platform.commercefacades.order.data.CreditCardPaymentInfoData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.order.payment.CreditCardPaymentInfoModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;


public class CreditCardPaymentInfoPopulator implements Populator<CreditCardPaymentInfoModel, CreditCardPaymentInfoData>
{

	@Override
	public void populate(final CreditCardPaymentInfoModel source, final CreditCardPaymentInfoData target)
			throws ConversionException
	{
		target.setCardOwner(source.getCardOwner());
	}

}
