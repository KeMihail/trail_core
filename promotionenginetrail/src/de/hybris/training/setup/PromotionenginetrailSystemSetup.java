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

import static de.hybris.training.constants.PromotionenginetrailConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import de.hybris.training.constants.PromotionenginetrailConstants;
import de.hybris.training.service.PromotionenginetrailService;


@SystemSetup(extension = PromotionenginetrailConstants.EXTENSIONNAME)
public class PromotionenginetrailSystemSetup
{
	private final PromotionenginetrailService promotionenginetrailService;

	public PromotionenginetrailSystemSetup(final PromotionenginetrailService promotionenginetrailService)
	{
		this.promotionenginetrailService = promotionenginetrailService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		promotionenginetrailService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return PromotionenginetrailSystemSetup.class.getResourceAsStream("/promotionenginetrail/sap-hybris-platform.png");
	}
}
