package de.hybris.training.commands.impl;

import de.hybris.platform.payment.AdapterException;
import de.hybris.platform.payment.commands.factory.CommandFactory;
import de.hybris.platform.payment.dto.BasicCardInfo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;


public class CommandFactoryRegistryMockTrailImpl
{
	public static final String MOCKUP_PAYMENT_PROVIDER = "Trail_Mockup";
	private ApplicationContext applicationContext;

	public CommandFactory getFactory(final String paymentProvider) throws AdapterException
	{
		if (MOCKUP_PAYMENT_PROVIDER.equals(paymentProvider))
		{
			return this.applicationContext.getBean("trailMockupCommandFactory", CommandFactory.class);
		}
		else
		{
			throw new AdapterException("The requested paymentProvider should be <Mockup> instead of <" + paymentProvider + ">");
		}
	}

	public CommandFactory getFactory(final BasicCardInfo card, final boolean threeD) throws AdapterException
	{
		return this.applicationContext.getBean("mockupCommandFactory", CommandFactory.class);
	}

	public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException
	{
		this.applicationContext = applicationContext;
	}
}
