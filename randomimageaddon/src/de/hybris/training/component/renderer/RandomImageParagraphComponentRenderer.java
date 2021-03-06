package de.hybris.training.component.renderer;

import de.hybris.platform.addonsupport.renderer.impl.DefaultAddOnCMSComponentRenderer;
import de.hybris.platform.cms2.servicelayer.services.CMSComponentService;
import de.hybris.platform.servicelayer.exceptions.AttributeNotSupportedException;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.training.model.RandomImageParagraphComponentModel;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.PageContext;

import org.springframework.beans.factory.annotation.Required;


public class RandomImageParagraphComponentRenderer<C extends RandomImageParagraphComponentModel>
		extends DefaultAddOnCMSComponentRenderer<C>
{
	private CMSComponentService cmsComponentService;
	private ModelService modelService;

	@Override
	@Required
	public void setCmsComponentService(final CMSComponentService cmsComponentService)
	{
		this.cmsComponentService = cmsComponentService;
	}

	@Override
	@Required
	public void setModelService(final ModelService modelService)
	{
		this.modelService = modelService;
	}

	protected Map<String, Object> getVariblesToExpose(final PageContext pageContext, final C component)
	{
		final Map<String, Object> varibles = new HashMap<String, Object>();

		for (final String property : cmsComponentService.getEditorProperties(component))
		{

			try
			{
				final Object value = modelService.getAttributeValue(component, property);

				varibles.put(property, value);

			}
			catch (final AttributeNotSupportedException ignore)
			{
				ignore.printStackTrace();
			}
		}

		return varibles;
	}

}
