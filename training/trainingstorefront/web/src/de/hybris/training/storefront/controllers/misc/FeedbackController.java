package de.hybris.training.storefront.controllers.misc;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.training.facades.feedback.FeedbackFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/feedback")
public class FeedbackController extends AbstractPageController
{
	@Autowired
	private FeedbackFacade feedbackFacade;

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	@ResponseBody
	public Boolean submitFeedback(@RequestAttribute("path") final String pageUrl,
			@RequestAttribute("message") final String message)
	{
		final Integer i = 5;
		return feedbackFacade.submitFeedback(pageUrl, message);
	}

}
