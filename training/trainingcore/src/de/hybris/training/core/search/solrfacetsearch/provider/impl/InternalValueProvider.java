package de.hybris.training.core.search.solrfacetsearch.provider.impl;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.solrfacetsearch.config.IndexConfig;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.exceptions.FieldValueProviderException;
import de.hybris.platform.solrfacetsearch.provider.FieldNameProvider;
import de.hybris.platform.solrfacetsearch.provider.FieldValue;
import de.hybris.platform.solrfacetsearch.provider.FieldValueProvider;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Required;


public class InternalValueProvider implements FieldValueProvider
{

	private FieldNameProvider fieldNameProvider;

	@Required
	public void setFieldNameProvider(final FieldNameProvider fieldNameProvider)
	{
		this.fieldNameProvider = fieldNameProvider;
	}



	@Override
	public Collection<FieldValue> getFieldValues(final IndexConfig indexConfig, final IndexedProperty indexedProperty,
			final Object model) throws FieldValueProviderException
	{
		final Collection<FieldValue> result = new ArrayList<FieldValue>();

		final Object value = "internal";

		try
		{
			if (model instanceof ProductModel)
			{
				final ProductModel product = (ProductModel) model;

				if (product.getInternalOnly())
				{
					final Collection<String> fieldNames = fieldNameProvider.getFieldNames(indexedProperty, null);

					for (final String fieldName : fieldNames)
					{
						{
							result.add(new FieldValue(fieldName, value));
						}
					}
				}
			}
		}
		catch (final Exception e)
		{
			throw new FieldValueProviderException("...");
		}
		return result;
	}

}
