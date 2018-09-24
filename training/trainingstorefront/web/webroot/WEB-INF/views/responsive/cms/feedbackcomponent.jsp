<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page import="de.hybris.training.core.util.CsTicketPriorityValues"%>
<%@ page import="de.hybris.platform.ticket.enums.CsTicketPriority"%>

<link rel="stylesheet"
	href="<c:url value="../_ui/responsive/common/css/feedback.css"/>"
	type="text/css" />

<script src="../_ui/responsive/common/js/cms/feedback.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
	$(function() {
		$("#priority").selectmenu();
	});
</script>

<script>
	$(document).ready(function() {

		//click to image (feddback)
		$('div.feedbackComponent a.feedback').click(function() {
			$('#feedback-popup-form-message').show();
			$('#feedback-confirmation').hide();
			$('#feedback-button').show();
			$('#feedback-popup-form-message').val('');
			$("#feedback-popup").fadeIn('slow');

			return false;
		});

		function runEffect() {

			var selectedEffect = 'clip';
			var options = {};

			$("#feedback-popup").effect(selectedEffect, options, 1000);
		}
		;

		//button close
		$('#close_feedback').click(function() {

			runEffect();
			return false;

		});

		//click button submit
		$('#submit_feedback').click(function() {

			$('#feedback-confirmation').show();
			$('#feedback-popup-form').hide();

			$.post("/trainingstorefront/feedback/submit", {
				path : document.location.href,
				message : $('#feedback-popup-form-message').val(),
				priority : $('#priority').val()
			})
		});

		//откл submit c form
		$('#feedback-popup-form').submit(function(event) {
			event.preventDefault();
		})
	});
</script>

<div id="feedback-popup" class="feedback-form" style="display: none">

	<form id="feedback-popup-form" method="post" action="#"
		autocomplete="on">

		<fieldset>
			<label for="priority"><font size="4"><strong>Priority</strong></font></label>

			<select id="priority" name="priority">
				<option disabled selected>Please pick one</option>

				<c:forEach var="item"
					items="${CsTicketPriorityValues.getPriorityValues().keySet()}">

					<c:if
						test="${not fn:containsIgnoreCase(item, 'SIMPLE_CLASSNAME') && not fn:containsIgnoreCase(item, '_TYPECODE')}">
						<option
							value="${CsTicketPriorityValues.getPriorityValues().get(item)}">${item}
						</option>
					</c:if>

				</c:forEach>

				<%-- <option value="${CsTicketPriority.LOW.getCode()}">${CsTicketPriority.LOW}</option>
				<option value="${CsTicketPriority.MEDIUM.getCode()}">${CsTicketPriority.MEDIUM}</option>
				<option value="${CsTicketPriority.HIGH.getCode()}">${CsTicketPriority.HIGH}</option> --%>
			</select>

		</fieldset>

		<textarea id="feedback-popup-form-message" name="message" rows="18"
			cols="40" placeholder="Enter your feedback here..."></textarea>

		<input type="submit" id="submit_feedback" name="submit"
			class="button_style" value="Submit" />

	</form>

	<input type="button" class="button_style" id="close_feedback"
		value="close" />

	<div id="feedback-confirmation" class="message" style="display: none">
		${confirmationMessage}</div>
</div>

<div class="feedbackComponent">

	<a class="feedback" href="#"> <img title="${media.altText}"
		alt="${media.altText}" src="${media.url}">
	</a>
</div>


