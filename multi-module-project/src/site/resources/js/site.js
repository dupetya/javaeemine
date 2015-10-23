
$(function() {
	$('#leftColumn').css('overflow','visible');
	$( "#navcolumn ul" ).menu({
	  items: "> :not(.ui-widget-header)"
	});
});

$(document).ready(function() {
	
	$.each( $('div.section h2') , function(key,value){
		if(key>0){
			$(value).insertBefore($(value).parent());
		}else{
			$(value).parent().insertBefore($(value).parent().parent());
			}
	});
	
	$("#contentBox p a").parent().remove()
	$( "#contentBox script").remove()
	$('h3').addClass('ui-state-default ui-corner-all');
	$( "#contentBox" ).accordion({
		heightStyle: "content",
		animate: 1000
	});
	
	$.each($('tbody'), function(key, value){
		$($( "tr", value)[0]).insertBefore($($("tr", value)[0]).parent());
	});
	
	$.each($('table'), function(key, value){
		$($( "tr", value)[0]).wrap(function(){
			return "<thead>"+$(this).html()+"</thead>"
		});
		($("tr", value)[0]).remove();
	});
	
	$("table").DataTable({
		"jQueryUI": true
	});
	
});