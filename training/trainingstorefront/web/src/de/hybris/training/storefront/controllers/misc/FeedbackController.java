package de.hybris.training.storefront.controllers.misc;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.training.facades.feedback.FeedbackFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/feedback")
public class FeedbackController extends AbstractPageController
{
	@Autowired
	private FeedbackFacade feedbackFacade;

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	/* @ResponseBody @RequestParam("path") final String pageUrl, @RequestParam("message") final String message */
	public Boolean submitFeedback()
	{
		final Integer i = 5;
		return feedbackFacade.submitFeedback("https", "hello");
	}

	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public void testSubmit()
	{
		final String str = "";
		String str1 = "";
		final String str2 = "";

		if (str.equals(str2))
		{
			str1 = "str";
		}
	}
}
