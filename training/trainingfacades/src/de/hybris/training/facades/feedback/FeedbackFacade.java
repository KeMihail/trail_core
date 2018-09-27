package de.hybris.training.facades.feedback;

import de.hybris.platform.ticket.enums.CsTicketPriority;

import java.util.List;


public interface FeedbackFacade
{
	boolean submitFeedback(final String pageUrl, final String message, final String priority);

	List<CsTicketPriority> getTicketPriorityValues();
}
