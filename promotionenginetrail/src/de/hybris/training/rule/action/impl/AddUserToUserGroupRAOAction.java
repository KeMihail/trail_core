package de.hybris.training.rule.action.impl;

import de.hybris.platform.ruleengineservices.rao.CartRAO;
import de.hybris.platform.ruleengineservices.rao.ChangeUserGroupRAO;
import de.hybris.platform.ruleengineservices.rao.RuleEngineResultRAO;
import de.hybris.platform.ruleengineservices.rao.UserGroupRAO;
import de.hybris.platform.ruleengineservices.rao.UserRAO;
import de.hybris.platform.ruleengineservices.rule.evaluation.RuleActionContext;
import de.hybris.platform.ruleengineservices.rule.evaluation.actions.AbstractRuleExecutableSupport;
import de.hybris.platform.ruleengineservices.rule.evaluation.actions.RAOAction;
import de.hybris.platform.ruleengineservices.util.RAOConstants;


public class AddUserToUserGroupRAOAction extends AbstractRuleExecutableSupport implements RAOAction
{

	@Override
	protected boolean performActionInternal(final RuleActionContext context)
	{

		final String userGroupCode = context.getParameter(RAOConstants.VALUE_PARAM, String.class);
		performAction(context, userGroupCode);
		return true;

	}

	protected void performAction(final RuleActionContext context, final String userGroupCode)
	{
		final CartRAO cartRAO = context.getCartRao();
		final RuleEngineResultRAO result = context.getRuleEngineResultRao();

		final ChangeUserGroupRAO changeUserGroupRAO = new ChangeUserGroupRAO();
		getRaoUtils().addAction(cartRAO, changeUserGroupRAO);
		changeUserGroupRAO.setUserGroupId(userGroupCode);
		result.getActions().add(changeUserGroupRAO);

		final UserGroupRAO userGroupRao = new UserGroupRAO();
		userGroupRao.setId(userGroupCode);
		final UserRAO user = cartRAO.getUser();
		user.getGroups().add(userGroupRao);

		setRAOMetaData(context, changeUserGroupRAO);
		context.insertFacts(changeUserGroupRAO, userGroupRao);
		context.scheduleForUpdate(user);
	}

}
