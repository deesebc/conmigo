$("#profileForm").validate({
	rules : {
		email : {
			required : true,
			email : true,
			remote : {
				type : 'post',
				url : config.contextPath + '/form/validate/email/exists',
				data : {
					email : $('#email').val(),
					userId : $('#userId').val(),
					_csrf : $('#csrfToken').val()
				}
			}
		},
		username : {
			required : true,
			remote : {
				type : 'post',
				url : config.contextPath + '/form/validate/username/exists',
				data : {
					username : $('#username').val(),
					userId : $('#userId').val(),
					_csrf : $('#csrfToken').val()
				}
			}
		}
	},
	messages : {
		email : {
			required : "Please Enter Email!",
			email : "This is not a valid email!",
			remote : "Email already in use!"
		},
		username : {
			required : "Please Enter Username!",
			remote : "Username already in use!"
		}
	}
});
function cancel() {
	$("#backProfileForm").submit();
}