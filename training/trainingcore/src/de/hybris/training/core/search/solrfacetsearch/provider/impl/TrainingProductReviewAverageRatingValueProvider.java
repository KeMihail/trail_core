package de.hybris.training.core.search.solrfacetsearch.provider.impl;

import de.hybris.platform.commerceservices.search.solrfacetsearch.provider.impl.ProductReviewAverageRatingValueProvider;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.provider.FieldValue;

import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;


public class TrainingProductReviewAverageRatingValueProvider extends ProductReviewAverageRatingValueProvider
{

	private static final Logger LOG = Logger.getLogger(TrainingProductReviewAverageRatingValueProvider.class);

	@Override
	protected void addFieldValues(final List<FieldValue> fieldValues, final IndexedProperty indexedProperty,
			final LanguageModel language, final Object value)
	{

		List<String> rangeNameList = null;

		try
		{
			rangeNameList = getRangeNameList(indexedProperty, value);
		}
		catch (final Exception e)
		{
			LOG.error("Could not get Range value", e);
		}

		//
		for (final String item : rangeNameList)
		{
			LOG.info(item);
		}


		String rangeName = null;

		if (CollectionUtils.isNotEmpty(rangeNameList))
		{
			rangeName = rangeNameList.get(0);
		}

		//
		LOG.info(rangeName);


		final Collection<String> fieldNames = getFieldNameProvider().getFieldNames(indexedProperty,
				language == null ? null : language.getIsocode());

		for (final String item : fieldNames)
		{
			LOG.info(item);
		}

		final Object valueToPass = (rangeName == null ? value : rangeName);

		for (final String fieldName : fieldNames)
		{
			fieldValues.add(new FieldValue(fieldName, valueToPass));

			//
			LOG.info("fieldName: " + fieldName);
			LOG.info("valueToPass: " + valueToPass);
		}
	}
}
