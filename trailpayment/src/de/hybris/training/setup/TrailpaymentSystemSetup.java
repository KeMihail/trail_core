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

import static de.hybris.training.constants.TrailpaymentConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import de.hybris.training.constants.TrailpaymentConstants;
import de.hybris.training.service.TrailpaymentService;


@SystemSetup(extension = TrailpaymentConstants.EXTENSIONNAME)
public class TrailpaymentSystemSetup
{
	private final TrailpaymentService trailpaymentService;

	public TrailpaymentSystemSetup(final TrailpaymentService trailpaymentService)
	{
		this.trailpaymentService = trailpaymentService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		trailpaymentService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return TrailpaymentSystemSetup.class.getResourceAsStream("/trailpayment/sap-hybris-platform.png");
	}
}
