package de.hybris.training.storefront.controllers.misc;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.training.facades.feedback.FeedbackFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@Scope("tenant")
@RequestMapping("/feedback")
public class FeedbackController extends AbstractPageController
{
	@Autowired
	private FeedbackFacade feedbackFacade;

	@ResponseBody
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public boolean postFeedback(@RequestParam("path") final String path, @RequestParam("message") final String message)
	{
		return feedbackFacade.submitFeedback(path, message);

	}

}
