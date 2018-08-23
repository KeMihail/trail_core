/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.training.setup;

import static de.hybris.training.constants.PromotionengineConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import de.hybris.training.constants.PromotionengineConstants;
import de.hybris.training.service.PromotionengineService;


@SystemSetup(extension = PromotionengineConstants.EXTENSIONNAME)
public class PromotionengineSystemSetup
{
	private final PromotionengineService promotionengineService;

	public PromotionengineSystemSetup(final PromotionengineService promotionengineService)
	{
		this.promotionengineService = promotionengineService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		promotionengineService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return PromotionengineSystemSetup.class.getResourceAsStream("/promotionengine/sap-hybris-platform.png");
	}
}
