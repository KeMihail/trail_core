	$(function() {
		$("#salutation").selectmenu();
	});
</script>

<script>
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
		$('#close').click(function() {

			runEffect();
			return false;

		});

		// click button submit
		$('#feedback-popup input.close').click(function() {

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
