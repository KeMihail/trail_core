<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style type="text/css">
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

#feedback-popup a.close {
	position: absolute;
	right: -10px;
	top: -10px;
	background:
		url(/trainingstorefront/_ui/common/images/fancy_closebox.png)
		no-repeat;
	height: 30px;
	width: 30px;
	overflow: hidden;
	text-indent: -1000px;
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
	font: 15px "Helvetica Neue", Arial, Helvetica, Geneva, sans-serif;
	padding: 5px;
	color: #000;
}

.btn-style {
	border: solid 1px #288c1a;
	border-radius: 20px 3px 20px 4px;
	moz-border-radius: 20px 3px 20px 4px;
	-webkit-box-shadow: 0px 0px 1px rgba(0, 0, 0, 0.7);
	-moz-box-shadow: 0px 0px 1px rgba(0, 0, 0, 0.7);
	box-shadow: 0px 0px 1px rgba(0, 0, 0, 0.7);
	font-size: 20px;
	color: #ffffff;
	padding: 1px 17px;
	background: #31fa1e;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #31fa1e),
		color-stop(100%, #30ab00));
	background: -moz-linear-gradient(top, #31fa1e 0%, #30ab00 100%);
	background: -webkit-linear-gradient(top, #31fa1e 0%, #30ab00 100%);
	background: -o-linear-gradient(top, #31fa1e 0%, #30ab00 100%);
	background: -ms-linear-gradient(top, #31fa1e 0%, #30ab00 100%);
	background: linear-gradient(top, #31fa1e 0%, #30ab00 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#31fa1e',
		endColorstr='#30ab00', GradientType=0);
}

.close {
	position: relative;
	opacity: 0.3;
	top: -33px;
	left: -11px;
}

.close:hover {
	opacity: 1;
}

.close:before, .close:after {
	content: ' ';
	height: 33px;
	width: 2px;
	background-color: #333;
}

.close:before {
	transform: rotate(45deg);
}

.close:after {
	transform: rotate(-45deg);
}

.H1 {
	text-shadow: -1px -1px #000, 0 1px 0 #444;
	color: #222;
	transition: all 1s;
}

.H1:hover {
	text-shadow: -1px -1px #000, 0 1px 0 #444;
	color: #1A1A1A;
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

				//button close
				$('#close').click(function() {
					$("#feedback-popup").fadeOut(3000);
					return false;
				});

				//button submit (variant 1)
				/* $('#submit').click(function() {

					var feedback = $('#feedback-popup-form-message').val();

					$('#feedback-confirmation').show();
					$('#feedback-popup-form-message').hide();
					$('#submit').hide();

					$.post("/trainingstorefront/feedback/submit", {
						path : document.location.href,
						message : feedback
					})

					$("#feedback-popup").fadeOut(7000);
				}); */

				//click button submit
				$('#feedback-popup input.form_but').click(
						function() {

							var feedback_message = $(
									'#feedback-popup-form-message').val();
							var feedback_priority = $(
									'#feedback-popup-select option:selected')
									.val();

							alert(feedback_priority);

							$('#feedback-confirmation').show();
							$('#feedback-popup-form-message').hide();
							$('#feedback-popup input.form_but').hide();

							$.post("/trainingstorefront/feedback/submit", {
								path : document.location.href,
								message : feedback_message,
								priority : feedback_priority
							})

							$("#feedback-popup").fadeOut(7000);
							$('feedback-popup-form').submit();
						});

				//откл submit c form
				$('#feedback-popup-form').submit(function(event) {
					event.preventDefault();
				})

			});
</script>




<div id="feedback-popup" class="feedback-form" style="display: none">

	<!--  (variant 1) -->
	<!-- <textarea id="feedback-popup-form-message" name="message" rows="18"
		cols="40" placeholder="Enter your feedback here..."
		style="display: none;"></textarea>
 -->

	<!-- <p />
	<input type="button" id="submit" class="btn-style" value="submit" /> -->


	<form id="feedback-popup-form" method="post" action="#">

		<label> <strong> <font size="4" color="orange">Priority</font></strong>
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

		<input type="submit" name="submit" class="form_but" value="Submit" />

	</form>

	<input type="button" class="close" id="close" value="close" />


	<div id="feedback-confirmation" class="H1" style="display: none">
		${confirmationMessage}</div>
</div>

<div class="feedbackComponent">

	<a class="feedback" href="#"> <img title="${media.altText}"
		alt="${media.altText}" src="${media.url}">
	</a>

</div>