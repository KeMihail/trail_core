<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="breadcrumb"
	tagdir="/WEB-INF/tags/responsive/nav/breadcrumb"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="/cms2lib/cmstags/cmstags.tld"%>

<template:page pageTitle="${pageTitle}">

	<breadcrumb:breadcrumb breadcrumbs="${breadcrumbs}" />

	<cms:slot var="feature" contentSlot="${slots.Section1}">
		<div class="span-24 section1 advert">
			<cms:component component="${feature}" />
		</div>

	</cms:slot>
	<div class="span-20 section2 advert">
		<cms:slot var="feature" contentSlot="${slots.Section2}">
			<cms:component component="${feature}" />
		</cms:slot>
	</div>

	<div class="span-4 section3 advert last">
		<cms:slot var="feature" contentSlot="${slots.Section3}">
			<cms:component component="${feature}" />
		</cms:slot>
	</div>

</template:page>
