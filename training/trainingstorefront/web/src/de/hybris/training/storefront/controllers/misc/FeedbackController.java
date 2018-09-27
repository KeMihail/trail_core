package de.hybris.training.storefront.controllers.misc;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.ticket.enums.CsTicketPriority;
import de.hybris.training.facades.feedback.FeedbackFacade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/feedback")
public class FeedbackController extends AbstractPageController
{
	@Autowired
	private FeedbackFacade feedbackFacade;

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public Boolean submitFeedback(@RequestParam("path") final String path, @RequestParam("message") final String message,
			@RequestParam("priority") final String priority)
	{
		feedbackFacade.submitFeedback(path, message, priority);
		return true;
	}

	@RequestMapping(value = "/enum", method = RequestMethod.GET)
	@ResponseBody
	public List<CsTicketPriority> getTicketPriorityValues()
	{
		return feedbackFacade.getTicketPriorityValues();
	}
}
