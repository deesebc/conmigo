function showPanel(message, type, id, slot, animation) {
	if($('#'+id).length > 0){
		$('#'+id).remove();
	}
	var message = '<div id="' + id + '" class="alert alert-' + type + ' alert-dismissible" role="alert">' +
	'<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>' + message +  '</div>';
	
	$(slot).append(message);
	
	if(animation) {
		$('html, body').animate({
			scrollTop: $('#'+id).offset().top
		}, 500);
	}

}