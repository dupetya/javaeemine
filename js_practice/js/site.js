/////////////////////////////////////////////////////////////////////////////
//

$(document).ready(function() {
	$("#menu").menu();
	$( "#datepicker" ).datepicker({
		"showAnim": "slideDown",
		onSelect: function(dateText) {
			alert("Changed date: " + dateText);
		}
	});
});