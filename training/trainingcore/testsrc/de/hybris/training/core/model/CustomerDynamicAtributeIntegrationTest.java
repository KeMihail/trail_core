package de.hybris.training.core.model;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.model.ModelService;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;


@IntegrationTest
public class CustomerDynamicAtributeIntegrationTest extends ServicelayerTransactionalTest
{
	@Resource
	private ModelService modelService;

	@Test
	public void testDynamicAtribute()
	{
		final CustomerModel customer = modelService.create(CustomerModel.class);
		customer.setUid("mihaila4038.hybris.com");

		Assert.assertEquals(Boolean.TRUE, customer.getIsInternal());

		customer.setUid("mihaila4038@yandex.ru");
		Assert.assertEquals(Boolean.FALSE, customer.getIsInternal());
	}
}
