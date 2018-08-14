package de.hybris.training.facades.feedback.impl;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.ticket.enums.CsTicketCategory;
import de.hybris.platform.ticket.enums.CsTicketPriority;
import de.hybris.platform.ticket.events.model.CsCustomerEventModel;
import de.hybris.platform.ticket.model.CsTicketModel;
import de.hybris.platform.ticket.service.TicketBusinessService;
import de.hybris.training.facades.feedback.FeedbackFacade;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;


public class DefaultFeedbackFacade implements FeedbackFacade
{
	private static final Logger LOG = Logger.getLogger(DefaultFeedbackFacade.class);

	private TicketBusinessService ticketBusinessService;
	private UserService userService;

	public TicketBusinessService getTicketBusinessService()
	{
		return ticketBusinessService;
	}

	@Required
	public void setTicketBusinessService(final TicketBusinessService ticketBusinessService)
	{
		this.ticketBusinessService = ticketBusinessService;
	}

	public UserService getUserService()
	{
		return userService;
	}

	@Required
	public void setUserService(final UserService userService)
	{
		this.userService = userService;
	}

	@Override
	public boolean submitFeedback(final String pageUrl, final String message)
	{
		LOG.info("Submitting Feedback for page: " + pageUrl);

		final String subject = "Customer Feedback";
		final String description = "Page: " + pageUrl + "\n\n" + message;
		final CustomerModel customer = getCurrentCustomer();

		final CsTicketModel ticket = createTicket(subject, description, customer, CsTicketCategory.NOTE, CsTicketPriority.MEDIUM);
		return ticket != null;
	}

	protected CustomerModel getCurrentCustomer()
	{
		final UserModel currentUser = getUserService().getCurrentUser();
		return currentUser instanceof CustomerModel && !getUserService().isAnonymousUser(currentUser) ? (CustomerModel) currentUser
				: null;
	}

	protected CsTicketModel createTicket(final String subject, final String description, final CustomerModel customer,
			final CsTicketCategory category, final CsTicketPriority priority)
	{
		final CsTicketModel newTicket = new CsTicketModel();
		newTicket.setHeadline(subject);
		newTicket.setCategory(category);
		newTicket.setPriority(priority);

		if (customer != null)
		{
			newTicket.setCustomer(customer);
		}

		final CsCustomerEventModel newTicketEvent = new CsCustomerEventModel();
		newTicketEvent.setText(description);

		return getTicketBusinessService().createTicket(newTicket, newTicketEvent);
	}
}
