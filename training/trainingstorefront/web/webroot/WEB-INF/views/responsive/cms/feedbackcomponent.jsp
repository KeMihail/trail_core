<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="de.hybris.platform.ticket.enums.CsTicketPriority"%>


<!-- are connected ??? -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">



<style type="text/css">
#feedback-popup {
	position: absolute;
	margin-top: -50px;
	left: 250px;
	color: #fff;
	padding: 15px;
	margin-bottom: 20px;
	width: 420px;
	z-index: 1;
	border: 1px solid #555;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	background-color: #ccc;
}

#feedback-popup  textarea {
	height: 80px;
	border: 1px solid #ccc;
	width: 97%;
	font: 15px "Helvetica Neue", Arial, Helvetica, Geneva, sans-serif;
	padding: 5px;
	color: #000;
}

#feedback-popup form table {
	width: 100%;
}

#feedback-popup form input.form_but {
	margin-top: 10px;
	background-color: #ff9933;
	border: 3px solid #cc9900;
	color: #fff;
	font: bold 15px "Helvetica Neue", Arial, Helvetica, Geneva, sans-serif;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	padding: 5px 10px;
}

#feedback-confirmation {
	left: -11px;
	font: 15px "Helvetica Neue", Arial, Helvetica, Geneva, sans-serif;
	padding: 5px;
	color: #000;
}

.new-select-style-wpandyou select {
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
}

.message {
	text-shadow: -1px -1px #000, 0 1px 0 #444;
	color: #222;
	transition: all 1s;
}

.message:hover {
	text-shadow: -1px -1px #000, 0 1px 0 #444;
	color: #1A1A1A;
}

.close {
	display: inline-block;
	font-family: Arial, Helvetica, FreeSans, "Liberation Sans",
		"Nimbus Sans L", sans-serif;
	font-size: 1.5em;
	font-weight: 700;
	color: rgb(245, 245, 245);
	text-shadow: 0 -1px rgba(0, 0, 0, .1);
	text-decoration: none;
	user-select: none;
	padding: .3em 1em;
	outline: none;
	border: none;
	border-radius: 3px;
	background: #0c9c0d linear-gradient(#82d18d, #0c9c0d);
	box-shadow: inset #72de26 0 -1px 1px, inset 0 1px 1px #98ff98, #3caa3c 0
		0 0 1px, rgba(0, 0, 0, .3) 0 2px 5px;
	-webkit-animation: pulsate 1.2s linear infinite;
	animation: pulsate 1.2s linear infinite;
}

.close:hover {
	-webkit-animation-play-state: paused;
	animation-play-state: paused;
	cursor: pointer;
}

.close:active {
	top: 1px;
	color: #fff;
	text-shadow: 0 -1px rgba(0, 0, 0, .3), 0 0 5px #ffd, 0 0 8px #fff;
	box-shadow: 0 -1px 3px rgba(0, 0, 0, .3), 0 1px 1px #fff, inset 0 1px
		2px rgba(0, 0, 0, .8), inset 0 -1px 0 rgba(0, 0, 0, .05);
}

@
-webkit-keyframes pulsate { 50% {
	color: #fff;
	text-shadow: 0 -1px rgba(0, 0, 0, .3), 0 0 5px #ffd, 0 0 8px #fff;
}

}
@
keyframes pulsate { 50% {
	color: #fff;
	text-shadow: 0 -1px rgba(0, 0, 0, .3), 0 0 5px #ffd, 0 0 8px #fff;
}
</style>

<c:url value="/trainingstorefront/feedback/submit"
	var="feedbackSubmitUrl" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>

<script>
	$(document).ready(
			function() {

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
				$('#feedback-popup input.close').click(
						function() {

							var feedback_message = $(
									'#feedback-popup-form-message').val();
							var feedback_priority = $(
									'#feedback-popup-select option:selected')
									.val();

							$('.button_css').removeClass('close').addClass(
									'green');

							$('#feedback-confirmation').show();
							$('#feedback-popup-form').hide();

							$.post("/trainingstorefront/feedback/submit", {
								path : document.location.href,
								message : feedback_message,
								priority : feedback_priority
							})

							$('feedback-popup-form').submit();
						});

				//откл submit c form
				$('#feedback-popup-form').submit(function(event) {
					event.preventDefault();
				})
			});
</script>


<div id="feedback-popup" class="feedback-form" style="display: none">


	<form id="feedback-popup-form" method="post" action="#">

		<label for="feedback-popup-select"> <strong> <font
				size="4" color="orange">Priority</font></strong>
		</label>
		<div class="new-select-style-wpandyou">
			<select id="feedback-popup-select">
				<option value="LOW">LOW</option>
				<option value="MEDIUM">MEDIUM</option>
				<option value="HIGH">HIGH</option>
			</select>
		</div>

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


