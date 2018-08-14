<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

#feedback-popup a.close {
	position: absolute;
	right: -10px;
	top: -10px;
	background:
		url(/trainingstorefront/web/webroot/_ui/responsive/common/images/fancy_closebox.png)
		no-repeat;
	height: 30px;
	width: 30px;
	overflow: hidden;
	text-indent: -1000px;
}

#feedback-popup form textarea {
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
</style>

<c:url value="/feedback/submit" var="feedbackSubmitUrl" />

<script type="text/javascript">
	$(document).ready(function() {
		$('div.feedbackComponent a.feedback').click(function() {
			$('#feedback-popup-form').show();
			$('#feedback-confirmation').hide();
			$('#feedback-popup-form-message').val('');
			$('#feedback-popup-form-message').val('');
			$("#feedback-popup").fadeIn('slow');
			return false;
		});

		path: document.location.pathname

		$('#feedback-popup a.close').click(function() {
			$("#feedback-popup").fadeOut('slow');
			return false;
		});

		$('#feedback-popup input.form_but').click(function() {
			$('#feedback-popup-form').hide();
			$('#feedback-confirmation').show();
			$.post('${feedbackSubmitUrl}', {

				path : document.location.pathname,
				message : $('#feedback-popup-form-message').val()
			});
			return false;

		});
	});
</script>

<div id="feedback-popup" class="feedback-form" style="display: none">

	<a class="close" href="#">Close</a>

	<form id="feedback-popup-form" method="post" action="#">
		<textarea id="feedback-popup-form-message" name="message" rows="18"
			cols="40" placeholder="Enter your feedback here..."></textarea>
		<input type="submit" name="submit" class="form_but" value="Submit" />
	</form>
	<div id="feedback-confirmation" style="display: none">
		${confirmationMessage}</div>
</div>

<div class="feedbackComponent">
	<a class="feedback" href="#"> <img title="${media.altText}"
		alt="${media.altText}" src="${media.url}">
	</a>
</div>
