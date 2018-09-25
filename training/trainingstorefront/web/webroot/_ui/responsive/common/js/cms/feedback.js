	$(function() {
		$("#priority").selectmenu();
	});

	$(document).ready(
			function() {

				//click to image (feddback)
				$('#feedback_component').click(function() {
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
				$('#submit_feedback').click(
						function() {

							$('#feedback-confirmation').show();
							$('#feedback-popup-form').hide();
							$('#path').val(document.location.href);

							$.post("/trainingstorefront/feedback/submit", $(
									'#feedback-popup-form').serialize())
						});
			});