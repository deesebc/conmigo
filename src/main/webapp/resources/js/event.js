function setUserIdMessageTo(userId){
	localStorage.setItem("userIdMessageTo", userId);
	//borramos el mensaje anterior
	$('#message').val('');
}

function sendMessage(){
	var userIdMessageTo= localStorage.getItem("userIdMessageTo");
	
	jsonObj = {}
	jsonObj["userIdMessageTo"] = userIdMessageTo;
	jsonObj["userIdMessageFrom"] = $('#userIdMessageFrom').val();
	jsonObj["message"] = $('#message').val();
	
	if ($('#comment').val() != '') {
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
	            // correcto 
	        	$('.loading').remove();
	        	$('#mesaggeDialog').modal('toggle');
	        },
	        error: function (data, textStatus, xhr) {
	        	$('.loading').remove();
	        	$('#mesaggeDialog').modal('toggle');
	        	if(data.status == 409){
	        		showPanel(translations.errorCompNoAddMore, 'danger', 'fav-warning', '.global-messages', true);
	        	}else{
	        		showPanel(translations.ajaxError, 'danger', 'fav-warning', '.global-messages', true);
	        	}
	        }
		});
	} else {
		console.log('else');
		// El comentario debe estar relleno
		showPanel(translations.ratingValidationError, 'danger','rating-warning', '.rating-popup-messages', false);
	}
	
	//borramos local storage
	localStorage.removeItem("userIdMessageTo");
}

