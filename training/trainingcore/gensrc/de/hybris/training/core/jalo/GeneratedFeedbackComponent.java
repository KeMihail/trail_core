/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Sep 28, 2018 10:16:29 AM                    ---
 * ----------------------------------------------------------------
 *  
 * [y] hybris Platform
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.training.core.jalo;

import de.hybris.platform.cms2.jalo.contents.components.SimpleCMSComponent;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.media.Media;
import de.hybris.training.core.constants.TrainingCoreConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.training.core.jalo.FeedbackComponent FeedbackComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedFeedbackComponent extends SimpleCMSComponent
{
	/** Qualifier of the <code>FeedbackComponent.media</code> attribute **/
	public static final String MEDIA = "media";
	/** Qualifier of the <code>FeedbackComponent.confirmationMessage</code> attribute **/
	public static final String CONFIRMATIONMESSAGE = "confirmationMessage";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(SimpleCMSComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(MEDIA, AttributeMode.INITIAL);
		tmp.put(CONFIRMATIONMESSAGE, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>FeedbackComponent.confirmationMessage</code> attribute.
	 * @return the confirmationMessage
	 */
	public String getConfirmationMessage(final SessionContext ctx)
	{
		return (String)getProperty( ctx, CONFIRMATIONMESSAGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>FeedbackComponent.confirmationMessage</code> attribute.
	 * @return the confirmationMessage
	 */
	public String getConfirmationMessage()
	{
		return getConfirmationMessage( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>FeedbackComponent.confirmationMessage</code> attribute. 
	 * @param value the confirmationMessage
	 */
	public void setConfirmationMessage(final SessionContext ctx, final String value)
	{
		setProperty(ctx, CONFIRMATIONMESSAGE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>FeedbackComponent.confirmationMessage</code> attribute. 
	 * @param value the confirmationMessage
	 */
	public void setConfirmationMessage(final String value)
	{
		setConfirmationMessage( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>FeedbackComponent.media</code> attribute.
	 * @return the media
	 */
	public Media getMedia(final SessionContext ctx)
	{
		return (Media)getProperty( ctx, MEDIA);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>FeedbackComponent.media</code> attribute.
	 * @return the media
	 */
	public Media getMedia()
	{
		return getMedia( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>FeedbackComponent.media</code> attribute. 
	 * @param value the media
	 */
	public void setMedia(final SessionContext ctx, final Media value)
	{
		setProperty(ctx, MEDIA,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>FeedbackComponent.media</code> attribute. 
	 * @param value the media
	 */
	public void setMedia(final Media value)
	{
		setMedia( getSession().getSessionContext(), value );
	}
	
}
