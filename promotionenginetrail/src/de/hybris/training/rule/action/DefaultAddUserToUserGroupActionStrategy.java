package de.hybris.training.rule.action;

import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.core.model.security.PrincipalModel;
import de.hybris.platform.core.model.user.UserGroupModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.promotionengineservices.action.impl.AbstractRuleActionStrategy;
import de.hybris.platform.promotions.model.PromotionResultModel;
import de.hybris.platform.ruleengineservices.rao.AbstractRuleActionRAO;
import de.hybris.platform.ruleengineservices.rao.CartRAO;
import de.hybris.platform.ruleengineservices.rao.ChangeUserGroupRAO;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.training.model.RuleBasedAddUserToUserGroupActionModel;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DefaultAddUserToUserGroupActionStrategy extends AbstractRuleActionStrategy<RuleBasedAddUserToUserGroupActionModel>
{

	private static final Logger LOG = LoggerFactory.getLogger(DefaultAddUserToUserGroupActionStrategy.class);

	private UserService userService;

	@Override
	public List apply(final AbstractRuleActionRAO action)
	{

		if (!(action instanceof ChangeUserGroupRAO))
		{
			LOG.error("cannot apply, action is not of type ChangeUserGroupRAO");
			return Collections.emptyList();
		}

		final ChangeUserGroupRAO changeUserGroupAction = (ChangeUserGroupRAO) action;

		if (!(changeUserGroupAction.getAppliedToObject() instanceof CartRAO))
		{
			LOG.error("cannot apply, appliedToObject is not of type CartRAO");
			return Collections.emptyList();
		}

		final PromotionResultModel promoResult = getPromotionActionService().createPromotionResult(action);

		if (promoResult == null)
		{
			LOG.error("cannot apply, promotionResult could not be created");
			return Collections.emptyList();
		}

		final AbstractOrderModel order = promoResult.getOrder();

		if (order == null)
		{
			LOG.error("cannot apply, order not found");
			return Collections.emptyList();
		}

		final UserGroupModel userGroup = findUserGroup(changeUserGroupAction.getUserGroupId());

		if (userGroup == null)
		{
			LOG.error("User group for id not found");
			return Collections.emptyList();
		}

		final UserModel user = order.getUser();

		addUserToUserGroup(userGroup, user);

		final RuleBasedAddUserToUserGroupActionModel actionModel = createPromotionAction(promoResult, action);
		actionModel.setPromotionResult(promoResult);
		actionModel.setUser(user);
		actionModel.setUserGroup(userGroup);

		getModelService().saveAll(promoResult, actionModel, userGroup);
		getModelService().refresh(user);

		return Collections.singletonList(promoResult);
	}

	protected UserGroupModel findUserGroup(final String userGroupId)
	{

		UserGroupModel userGroup = null;

		try
		{
			userGroup = getUserService().getUserGroupForUID(userGroupId);
		}
		catch (final Exception e)
		{
			LOG.error("Problem getting user group with uid=" + userGroupId);
		}
		return userGroup;
	}

	protected void addUserToUserGroup(final UserGroupModel userGroup, final UserModel user)
	{

		final Set<PrincipalModel> members = userGroup.getMembers();
		final HashSet<PrincipalModel> modifiedMembers = new HashSet<PrincipalModel>(members);
		modifiedMembers.add(user);
		userGroup.setMembers(modifiedMembers);
	}

	@Override
	public void undo(final ItemModel item)
	{
		if (item instanceof RuleBasedAddUserToUserGroupActionModel)
		{
			final RuleBasedAddUserToUserGroupActionModel action = (RuleBasedAddUserToUserGroupActionModel) item;
			final UserGroupModel userGroup = action.getUserGroup();
			final UserModel user = action.getUser();

			final Set<PrincipalModel> members = userGroup.getMembers();
			final HashSet<PrincipalModel> modifiedMembers = new HashSet<PrincipalModel>(members);
			modifiedMembers.remove(user);
			undoInternal(action);

			getModelService().save(userGroup);
			getModelService().refresh(user);
		}
	}

	public UserService getUserService()
	{
		return userService;
	}

	public void setUserService(final UserService userService)
	{
		this.userService = userService;
	}



}
