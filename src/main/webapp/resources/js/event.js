function sendMessageTo(eventId, receiverId){
	$('input#eventId').val(eventId);
	$('input#receiverId').val(receiverId);
	$( "#sendMessageToForm" ).submit();
}

