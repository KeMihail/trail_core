<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
		url(/trainingstorefront/_ui/common/images/fancy_closebox.png)
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

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>

<script>
	$(document).ready(function() {

		$('div.feedbackComponent a.feedback').click(function() {
			$('#feedback-popup-form-message').show();
			$('#feedback-confirmation').hide();

			$('#feedback-button').show();

			$('#feedback-popup-form-message').val('');
			$("#feedback-popup").fadeIn('slow');
			return false;
		});

		$('#btn').click(function() {
			$("#feedback-popup").fadeOut('slow');
			return false;
		});

		$('#btn1').click(function() {
			$('#feedback-confirmation').show();
			$('#feedback-popup-form-message').hide();
			$('#btn1').hide();

			$.post("/feedback/submit")
			/* {
				path : 'path',
				message : 'message'
			}) */
		});

		/* 
		 $('#feedback-popup input.form_but').click(function() {
		 $('#feedback-popup-form').hide();
		 $('#feedback-confirmation').show();

		 $.ajax({
		 url : '/feedback/submit',
		 data : {
		 path : 'path',
		 message : 'message'},
		 method : 'POST',
		 });

		 /* $.post('/feedback/submit', {
		 path : 'path',
		 message : 'message'
		 });
		 return false;
		 }); */
	});
</script>

<script>
	$('#btn1').click(function() {
		alert('submit');
		$('#feedback-popup-form').hide();
		$('#feedback-confirmation').show();
		$.post("/feedback/submit");
		return false;
	});
</script>

<div id="feedback-popup" class="feedback-form" style="display: none">

	<textarea id="feedback-popup-form-message" class="form textarea"
		name="message" rows="18" cols="40"
		placeholder="Enter your feedback here..." style="display: none;"></textarea>

	<input type="button" id="btn" value="CLOSE" /> <input type="button"
		id="btn1" value="SEND_FEEDBACK" />

	<%-- <form:form id="feedback-popup-form" method="post" action="#">
		<textarea id="feedback-popup-form-message" name="message" rows="18"
			cols="40" placeholder="Enter your feedback here..."></textarea>
		<input type="submit" name="submit" class="form_but" value="Submit" />
	</form:form> --%>



	<div id="feedback-confirmation" style="display: none">
		${confirmationMessage}</div>
</div>

<div class="feedbackComponent">

	<a class="feedback" href="#"> <img title="${media.altText}"
		alt="${media.altText}" src="${media.url}">
	</a>

</div>