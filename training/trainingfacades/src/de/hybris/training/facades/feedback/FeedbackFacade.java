package de.hybris.training.facades.feedback;

public interface FeedbackFacade
{
	boolean submitFeedback(final String pageUrl, final String message, final String priority);
}
