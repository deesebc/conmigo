function sendMessageTo(eventChat, receiverChat){
	$('input#eventChat').val(eventChat);
	$('input#receiverChat').val(receiverChat);
	$( "#sendMessageToForm" ).submit();
}

function sendMessage(){
	var userIdMessageTo= localStorage.getItem("userIdMessageTo");
	var userIdMessageFrom= localStorage.getItem("userIdMessageFrom");
	
	jsonObj = {}
	jsonObj["userIdMessageTo"] = userIdMessageTo;
	jsonObj["userIdMessageFrom"] = userIdMessageFrom;
	jsonObj["message"] = $('#message').val();
	
	if ($.trim($("#message").val())) {
		$.ajax({
			type : "POST",
			contentType : "application/json",
			beforeSend : function(jqXHR) {
				var csrf_token = $('meta[name=_csrf]').attr('content');
				jqXHR.setRequestHeader('X-CSRF-Token', csrf_token);
				$('#mesaggeDialog').prepend('<div class="loading">Loading&#8230;</div>');
				$('.loading').addClass('absolute');
			},
			url : config.contextPath + "/message/",
			data : JSON.stringify(jsonObj),
			contentType: 'application/json; charset=utf-8', 
	        timeout: 600000, 
	        success: function (data, textStatus, xhr) {
	            // quitamos el cargando 
	        	$('.loading').remove();
	        	//ocultamos el dialogo
	        	$('#mesaggeDialog').modal('toggle');
	        	//borramos local storage
	        	localStorage.removeItem("userIdMessageTo");
	        	// mostramos mensaje de creacion
	        	showPanel(translations.sMessageCreate, 'success', 'message-success', '.global-messages', true);
	        },
	        error: function (data, textStatus, xhr) {
	        	// quitamos el cargando 
	        	$('.loading').remove();
	        	//ocultamos el dialogo
	        	$('#mesaggeDialog').modal('toggle');
	        	//borramos local storage
	        	localStorage.removeItem("userIdMessageTo");
	        	// mostramos mensaje de error
	        	showPanel(translations.eAjaxError, 'danger', 'message-error', '.global-messages', true);
	        }
		});
	} else {
		// El comentario debe estar relleno
		showPanel(translations.eMessageNotEmpty, 'danger','message-empty', '.create-popup-messages', false);
	}
}

