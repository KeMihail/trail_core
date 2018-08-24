/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Aug 24, 2018 3:29:54 PM                     ---
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
import de.hybris.platform.jalo.media.Media;
import de.hybris.training.core.constants.TrainingCoreConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.cms2.jalo.contents.components.CMSParagraphComponent CMSMediaParagraphComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedCMSMediaParagraphComponent extends CMSParagraphComponent
{
	/** Qualifier of the <code>CMSMediaParagraphComponent.media</code> attribute **/
	public static final String MEDIA = "media";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(CMSParagraphComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(MEDIA, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSMediaParagraphComponent.media</code> attribute.
	 * @return the media - Attribute that stores the localized media of the paragraph
	 */
	public Media getMedia(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedCMSMediaParagraphComponent.getMedia requires a session language", 0 );
		}
		return (Media)getLocalizedProperty( ctx, MEDIA);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSMediaParagraphComponent.media</code> attribute.
	 * @return the media - Attribute that stores the localized media of the paragraph
	 */
	public Media getMedia()
	{
		return getMedia( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSMediaParagraphComponent.media</code> attribute. 
	 * @return the localized media - Attribute that stores the localized media of the paragraph
	 */
	public Map<Language,Media> getAllMedia(final SessionContext ctx)
	{
		return (Map<Language,Media>)getAllLocalizedProperties(ctx,MEDIA,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSMediaParagraphComponent.media</code> attribute. 
	 * @return the localized media - Attribute that stores the localized media of the paragraph
	 */
	public Map<Language,Media> getAllMedia()
	{
		return getAllMedia( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSMediaParagraphComponent.media</code> attribute. 
	 * @param value the media - Attribute that stores the localized media of the paragraph
	 */
	public void setMedia(final SessionContext ctx, final Media value)
	{
		if ( ctx == null) 
		{
			throw new JaloInvalidParameterException( "ctx is null", 0 );
		}
		if( ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedCMSMediaParagraphComponent.setMedia requires a session language", 0 );
		}
		setLocalizedProperty(ctx, MEDIA,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSMediaParagraphComponent.media</code> attribute. 
	 * @param value the media - Attribute that stores the localized media of the paragraph
	 */
	public void setMedia(final Media value)
	{
		setMedia( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSMediaParagraphComponent.media</code> attribute. 
	 * @param value the media - Attribute that stores the localized media of the paragraph
	 */
	public void setAllMedia(final SessionContext ctx, final Map<Language,Media> value)
	{
		setAllLocalizedProperties(ctx,MEDIA,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSMediaParagraphComponent.media</code> attribute. 
	 * @param value the media - Attribute that stores the localized media of the paragraph
	 */
	public void setAllMedia(final Map<Language,Media> value)
	{
		setAllMedia( getSession().getSessionContext(), value );
	}
	
}
