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
		}
	},
	messages : {
		email : {
			required : "Please Enter Email!",
			email : "This is not a valid email!",
			remote : "Email already in use!"
		}
	}
});
function cancel() {
	$("#backProfileForm").submit();
}