src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js">
src="https://code.jquery.com/jquery-1.12.4.js">
src="https://code.jquery.com/ui/1.12.1/jquery-ui.js">

	$(function() {
		$("#priority").selectmenu();
	});

	$(document).ready(function() {

		// click to image (feddback)
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

		// button close
		$('#close_feedback').click(function() {

			runEffect();
			return false;

		});

		// click button submit
		$('#submit_feedback').click(function() {

			$('#feedback-confirmation').show();
			$('#feedback-popup-form').hide();

			$.post("/trainingstorefront/feedback/submit", {
				path : document.location.href,
				message : $('#feedback-popup-form-message').val(),
				priority : $('#priority').val()
			})
		});

		// откл submit c form
		$('#feedback-popup-form').submit(function(event) {
			event.preventDefault();
		})
	});
