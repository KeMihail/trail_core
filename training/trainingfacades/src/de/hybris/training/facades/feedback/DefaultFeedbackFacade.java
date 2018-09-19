package de.hybris.training.facades.feedback;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.ticket.enums.CsTicketCategory;
import de.hybris.platform.ticket.enums.CsTicketPriority;
import de.hybris.platform.ticket.events.model.CsCustomerEventModel;
import de.hybris.platform.ticket.model.CsTicketModel;
import de.hybris.platform.ticket.service.TicketBusinessService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;


public class DefaultFeedbackFacade implements FeedbackFacade
{
	private static final Logger LOG = Logger.getLogger(DefaultFeedbackFacade.class);

	private TicketBusinessService ticketBusinessService;
	private UserService userService;

	protected TicketBusinessService getTicketBusinessService()
	{
		return ticketBusinessService;
	}

	@Required
	public void setTicketBusinessService(final TicketBusinessService ticketBusinessService)
	{
		this.ticketBusinessService = ticketBusinessService;
	}

	protected UserService getUserService()
	{
		return userService;
	}

	@Required
	public void setUserService(final UserService userService)
	{
		this.userService = userService;
	}

	@Override
	public boolean submitFeedback(final String pageUrl, final String message, final String priority)
	{
		LOG.info("Submitting Feedback for page: " + pageUrl);

		final String subject = "Customer Feedback";
		final String description = "Page: " + pageUrl + "\n\n" + message;
		final CustomerModel customer = getCurrentCustomer();

		final CsTicketModel ticket = createTicket(subject, description, customer, CsTicketCategory.NOTE, priority);
		return ticket != null;

	}

	protected CsTicketModel createTicket(final String subject, final String description, final CustomerModel customer,
			final CsTicketCategory category, final String priority)
	{

		final CsTicketModel ticket = new CsTicketModel();
		ticket.setHeadline(subject);
		ticket.setCategory(category);
		ticket.setPriority(CsTicketPriority.valueOf(priority));
		if (customer != null)
		{
			ticket.setCustomer(customer);
		}

		final CsCustomerEventModel newTicketEvent = new CsCustomerEventModel();
		newTicketEvent.setText(description);

		return getTicketBusinessService().createTicket(ticket, newTicketEvent);
	}

	protected CustomerModel getCurrentCustomer()
	{
		final UserModel currentUser = getUserService().getCurrentUser();
		return currentUser instanceof CustomerModel && !getUserService().isAnonymousUser(currentUser) ? (CustomerModel) currentUser
				: null;
	}
}
