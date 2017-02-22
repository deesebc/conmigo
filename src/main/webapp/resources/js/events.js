function joinToEvent(id){
	$('input#idJoinEvent').val(id);
	$( "#joinEventForm" ).submit();
}
function seeEvent(id){
	alert(id);
	$('input#idSeeEvent').val(id);
	$( "#seeEventForm" ).submit();
}
