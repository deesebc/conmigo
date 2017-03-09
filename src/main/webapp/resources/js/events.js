function joinToEvent(id){
	$('input#idJoinEvent').val(id);
	$( "#joinEventForm" ).submit();
}
function disjoinToEvent(id){
	$('input#idDisjoinEvent').val(id);
	$( "#disjoinEventForm" ).submit();
}
function seeEvent(id){
	$('input#idSeeEvent').val(id);
	$( "#seeEventForm" ).submit();
}
