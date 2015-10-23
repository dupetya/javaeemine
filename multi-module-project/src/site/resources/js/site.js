
$( document).ready(function(){
	
  $(function() {
	  $('#leftColumn').css('overflow','visible');
    $( "#navcolumn>ul" ).menu({
      items: "> :not(.ui-widget-header)"
    });
  });

	
    $( "#menu" ).menu({
      items: "> :not(.ui-widget-header)"
    });

$.each( $('div.section h2') , function(key,value){
		if(key>0){
			$(value).insertBefore($(value).parent());
		}else{
			$(value).parent().insertBefore($(value).parent().parent());
			}
	});
	
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
		animate: 200
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
	
	
	$("#navcolumn").addClass("ui-widget-content");
	$("#navcolumn").css("paddingBottom", "10px");
	$(".poweredBy").remove();
  });
