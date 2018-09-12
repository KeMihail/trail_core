package de.hybris.training.core.search.solrfacetsearch.provider.impl;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.VariantsService;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.solrfacetsearch.config.IndexConfig;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.exceptions.FieldValueProviderException;
import de.hybris.platform.solrfacetsearch.provider.FieldNameProvider;
import de.hybris.platform.solrfacetsearch.provider.FieldValue;
import de.hybris.platform.solrfacetsearch.provider.FieldValueProvider;
import de.hybris.platform.solrfacetsearch.provider.impl.AbstractPropertyFieldValueProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;


public class TrainingProductInternalValueProvider extends AbstractPropertyFieldValueProvider implements FieldValueProvider
{

	private static final Logger LOG = Logger.getLogger(TrainingProductReviewAverageRatingValueProvider.class);

	private FieldNameProvider fieldNameProvider;
	private VariantsService variantsService;
	private CommonI18NService commonI18NService;

	private ModelService modelService;

	@Override
	@Required
	public void setModelService(final ModelService modelService)
	{
		this.modelService = modelService;
	}

	@Required
	public void setFieldNameProvider(final FieldNameProvider fieldNameProvider)
	{
		this.fieldNameProvider = fieldNameProvider;
	}

	@Required
	public void setVariantsService(final VariantsService variantsService)
	{
		this.variantsService = variantsService;
	}

	@Required
	public void setCommonI18NService(final CommonI18NService commonI18NService)
	{
		this.commonI18NService = commonI18NService;
	}

	@Override
	public Collection<FieldValue> getFieldValues(final IndexConfig indexConfig, final IndexedProperty indexedProperty,
			final Object model) throws FieldValueProviderException
	{
		if (model == null)
		{
			throw new IllegalArgumentException("No model given");
		}
		final List<FieldValue> fieldValues = new ArrayList<FieldValue>();
		try
		{
			ProductModel product = null;
			product = (ProductModel) model;


			final Object value = product.getInternalOnly();

			final List<String> rangeNameList = rangeNameProvider.getRangeNameList(indexedProperty, value.toString());

			if (value != null || !rangeNameList.isEmpty())
			{
				final Collection<String> fieldNames = fieldNameProvider.getFieldNames(indexedProperty, null);

				for (final String fieldName : fieldNames)
				{
					if (rangeNameList.isEmpty())
					{
						fieldValues.add(new FieldValue(fieldName, value));
					}
					else
					{
						for (final String rangeName : rangeNameList)
						{
							fieldValues.add(new FieldValue(fieldName, rangeName == null ? value : rangeName));
						}
					}
				}
			}
		}
		catch (final Exception e)
		{
			throw new FieldValueProviderException("....");
		}
		return fieldValues;
	}
}
