package de.hybris.training.core.model;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.model.attribute.AbstractDynamicAttributeHandler;


public class DynamicHybrisCustomerAttributeBean extends AbstractDynamicAttributeHandler<Boolean, CustomerModel>
{

	@Override
	public Boolean get(final CustomerModel model)
	{
		return model.getUid().endsWith("hybris.com") || model.getUid().endsWith("hybris.de");
	}
}
