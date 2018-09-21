<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="de.hybris.platform.ticket.enums.CsTicketPriority"%>

<link rel="stylesheet"
	href="<c:url value="../_ui/responsive/common/css/feedback.css"/>"
	type="text/css" />

<script
	src="/trainingstorefront/web/webroot/_ui/responsive/common/css/feedback.css.js"></script>

<!-- are connected ??? -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
	$(function() {
		$("#salutation").selectmenu();
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
		$('#close').click(function() {

			runEffect();
			return false;

		});

		//click button submit
		$('#feedback-popup input.close').click(function() {

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

<c:url value="/trainingstorefront/feedback/submit"
	var="feedbackSubmitUrl" />

<div id="feedback-popup" class="feedback-form" style="display: none">


	<form id="feedback-popup-form" method="post" action="#"
		autocomplete="on">

		<fieldset>
			<label for=""><font size="4"><strong>Priority</strong></font></label>

			<select id="priority" name="priority">
				<option disabled selected>Please pick one</option>
				<option value="LOW">LOW</option>
				<option value="MEDIUM">MEDIUM</option>
				<option value="HIGH">HIGH</option>
			</select>

		</fieldset>

		<textarea id="feedback-popup-form-message" name="message" rows="18"
			cols="40" placeholder="Enter your feedback here..."></textarea>

		<input type="submit" name="submit" class="close" value="Submit" />

	</form>

	<input type="button" class="close" id="close" value="close" />

	<div id="feedback-confirmation" class="message" style="display: none">
		${confirmationMessage}</div>
</div>

<div class="feedbackComponent">

	<a class="feedback" href="#"> <img title="${media.altText}"
		alt="${media.altText}" src="${media.url}">
	</a>

</div>


<!--  (variant 1) -->
<!-- <textarea id="feedback-popup-form-message" name="message" rows="18"
		cols="40" placeholder="Enter your feedback here..."
		style="display: none;"></textarea>
 -->

<!-- <p />
	<input type="button" id="submit" class="btn-style" value="submit" /> -->

<!-- button submit (variant 1)
				$('#submit').click(function() {

					var feedback = $('#feedback-popup-form-message').val();

					$('#feedback-confirmation').show();
					$('#feedback-popup-form-message').hide();
					$('#submit').hide();

					$.post("/trainingstorefront/feedback/submit", {
						path : document.location.href,
						message : feedback
					})

					$("#feedback-popup").fadeOut(7000);
				});  -->


<!-- <label for="feedback-popup-select"> <strong> <font
				size="4" color="orange">Priority</font></strong>
		</label>
		
		<div class="new-select-style-wpandyou">
			<select id="feedback-popup-select">
				<option value="LOW">LOW</option>
				<option value="MEDIUM">MEDIUM</option>
				<option value="HIGH">HIGH</option>
			</select>
		</div> -->

<!-- 		.new-select-style-wpandyou select {
	border-radius: 0;
	background: transparent;
	height: 34px;
	padding: 5px;
	border: 0;
	font-size: 16px;
	line-height: 1;
	-webkit-appearance: none;
	width: 268px;
}

.new-select-style-wpandyou {
	border: 1px solid #CCC;
	overflow: hidden;
	height: 34px;
	background:
		url(http://wpandyou.ru/wp-content/uploads/2013/01/down_arrow_select.jpg)
		no-repeat right #DDD;
	width: 240px;
} -->

<!-- /* edit css class	 */
			$('.button_css').removeClass('close').addClass('green'); -->