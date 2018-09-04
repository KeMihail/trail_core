/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Sep 4, 2018 4:09:26 PM                      ---
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

import de.hybris.platform.cms2.jalo.contents.components.CMSParagraphComponent;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.c2l.C2LManager;
import de.hybris.platform.jalo.c2l.Language;
import de.hybris.platform.jalo.enumeration.EnumerationValue;
import de.hybris.training.core.constants.TrainingCoreConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.cms2.jalo.contents.components.CMSParagraphComponent RandomImageParagraphComponentFromCore}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedRandomImageParagraphComponentFromCore extends CMSParagraphComponent
{
	/** Qualifier of the <code>RandomImageParagraphComponentFromCore.topic</code> attribute **/
	public static final String TOPIC = "topic";
	/** Qualifier of the <code>RandomImageParagraphComponentFromCore.width</code> attribute **/
	public static final String WIDTH = "width";
	/** Qualifier of the <code>RandomImageParagraphComponentFromCore.height</code> attribute **/
	public static final String HEIGHT = "height";
	/** Qualifier of the <code>RandomImageParagraphComponentFromCore.text</code> attribute **/
	public static final String TEXT = "text";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(CMSParagraphComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(TOPIC, AttributeMode.INITIAL);
		tmp.put(WIDTH, AttributeMode.INITIAL);
		tmp.put(HEIGHT, AttributeMode.INITIAL);
		tmp.put(TEXT, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RandomImageParagraphComponentFromCore.height</code> attribute.
	 * @return the height
	 */
	public Integer getHeight(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, HEIGHT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RandomImageParagraphComponentFromCore.height</code> attribute.
	 * @return the height
	 */
	public Integer getHeight()
	{
		return getHeight( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RandomImageParagraphComponentFromCore.height</code> attribute. 
	 * @return the height
	 */
	public int getHeightAsPrimitive(final SessionContext ctx)
	{
		Integer value = getHeight( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RandomImageParagraphComponentFromCore.height</code> attribute. 
	 * @return the height
	 */
	public int getHeightAsPrimitive()
	{
		return getHeightAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RandomImageParagraphComponentFromCore.height</code> attribute. 
	 * @param value the height
	 */
	public void setHeight(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, HEIGHT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RandomImageParagraphComponentFromCore.height</code> attribute. 
	 * @param value the height
	 */
	public void setHeight(final Integer value)
	{
		setHeight( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RandomImageParagraphComponentFromCore.height</code> attribute. 
	 * @param value the height
	 */
	public void setHeight(final SessionContext ctx, final int value)
	{
		setHeight( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RandomImageParagraphComponentFromCore.height</code> attribute. 
	 * @param value the height
	 */
	public void setHeight(final int value)
	{
		setHeight( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RandomImageParagraphComponentFromCore.text</code> attribute.
	 * @return the text
	 */
	public String getText(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedRandomImageParagraphComponentFromCore.getText requires a session language", 0 );
		}
		return (String)getLocalizedProperty( ctx, TEXT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RandomImageParagraphComponentFromCore.text</code> attribute.
	 * @return the text
	 */
	public String getText()
	{
		return getText( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RandomImageParagraphComponentFromCore.text</code> attribute. 
	 * @return the localized text
	 */
	public Map<Language,String> getAllText(final SessionContext ctx)
	{
		return (Map<Language,String>)getAllLocalizedProperties(ctx,TEXT,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RandomImageParagraphComponentFromCore.text</code> attribute. 
	 * @return the localized text
	 */
	public Map<Language,String> getAllText()
	{
		return getAllText( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RandomImageParagraphComponentFromCore.text</code> attribute. 
	 * @param value the text
	 */
	public void setText(final SessionContext ctx, final String value)
	{
		if ( ctx == null) 
		{
			throw new JaloInvalidParameterException( "ctx is null", 0 );
		}
		if( ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedRandomImageParagraphComponentFromCore.setText requires a session language", 0 );
		}
		setLocalizedProperty(ctx, TEXT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RandomImageParagraphComponentFromCore.text</code> attribute. 
	 * @param value the text
	 */
	public void setText(final String value)
	{
		setText( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RandomImageParagraphComponentFromCore.text</code> attribute. 
	 * @param value the text
	 */
	public void setAllText(final SessionContext ctx, final Map<Language,String> value)
	{
		setAllLocalizedProperties(ctx,TEXT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RandomImageParagraphComponentFromCore.text</code> attribute. 
	 * @param value the text
	 */
	public void setAllText(final Map<Language,String> value)
	{
		setAllText( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RandomImageParagraphComponentFromCore.topic</code> attribute.
	 * @return the topic - Topic of the Image
	 */
	public EnumerationValue getTopic(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, TOPIC);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RandomImageParagraphComponentFromCore.topic</code> attribute.
	 * @return the topic - Topic of the Image
	 */
	public EnumerationValue getTopic()
	{
		return getTopic( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RandomImageParagraphComponentFromCore.topic</code> attribute. 
	 * @param value the topic - Topic of the Image
	 */
	public void setTopic(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, TOPIC,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RandomImageParagraphComponentFromCore.topic</code> attribute. 
	 * @param value the topic - Topic of the Image
	 */
	public void setTopic(final EnumerationValue value)
	{
		setTopic( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RandomImageParagraphComponentFromCore.width</code> attribute.
	 * @return the width
	 */
	public Integer getWidth(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, WIDTH);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RandomImageParagraphComponentFromCore.width</code> attribute.
	 * @return the width
	 */
	public Integer getWidth()
	{
		return getWidth( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RandomImageParagraphComponentFromCore.width</code> attribute. 
	 * @return the width
	 */
	public int getWidthAsPrimitive(final SessionContext ctx)
	{
		Integer value = getWidth( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RandomImageParagraphComponentFromCore.width</code> attribute. 
	 * @return the width
	 */
	public int getWidthAsPrimitive()
	{
		return getWidthAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RandomImageParagraphComponentFromCore.width</code> attribute. 
	 * @param value the width
	 */
	public void setWidth(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, WIDTH,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RandomImageParagraphComponentFromCore.width</code> attribute. 
	 * @param value the width
	 */
	public void setWidth(final Integer value)
	{
		setWidth( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RandomImageParagraphComponentFromCore.width</code> attribute. 
	 * @param value the width
	 */
	public void setWidth(final SessionContext ctx, final int value)
	{
		setWidth( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RandomImageParagraphComponentFromCore.width</code> attribute. 
	 * @param value the width
	 */
	public void setWidth(final int value)
	{
		setWidth( getSession().getSessionContext(), value );
	}
	
}
