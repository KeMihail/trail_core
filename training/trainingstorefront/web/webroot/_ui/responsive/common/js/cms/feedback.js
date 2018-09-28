$(function() {
	$("#priority").selectmenu();
});

$(function addOption(key, value) {
	$('#priority').append(new Option(value, key));
});

$(document).ready(
		function() {

			// click to image (feddback)
			$('#feedback_component').click(function() {

				$.get("/trainingstorefront/feedback/enum", function(data) {
					$('#priority').find('option').remove();
					
					for (var item of data){
						console.log(item);
						
						if (item.code.length > 1){
						$('#priority').append(new Option(item.code, item.code));
						}
					}
				});

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
			$('#submit_feedback').click(
					function() {

						$('#feedback-confirmation').show();
						$('#feedback-popup-form').hide();
						$('#path').val(document.location.href);

						$.post("/trainingstorefront/feedback/submit", $(
								'#feedback-popup-form').serialize())
					});
		});