<%@ include file="../tiles/view/taglib.jsp"%>

	<div class="col-xs-12 global-messages"></div>
	<form:form modelAttribute="form" method="put" action="${pageContext.request.contextPath}/profile">
		<div class="col-md-12">
			<h2 class="form-signin-heading">Update your profile</h2>
		</div>
		<div class="form-group row">
		    <div class="col"><label for="name" class="col-form-label">First Name</label></div>
		    <div class="col-4">
			    <form:input path="firstName" id="firstName" cssErrorClass="form-control required haserror" type="text" maxlength="50" cssClass="form-control required" aria-describedby="firstNameHelp" placeholder="Enter first name"  />
			    <small id="firstNameHelp" class="form-text text-muted">Indicanos tu nombre</small>
			     <form:errors path="firstName" cssClass="error-label" element="label" />
		     </div>
		     <div class="col"><label for="lastName" class="col-form-label">Last Name</label></div>
		     <div class="col-4">
			    <form:input path="lastName" id="lastName" cssErrorClass="form-control required haserror" type="text" maxlength="50" cssClass="form-control required" aria-describedby="lastNameHelp" placeholder="Enter last name" />
			    <small id="lastNameHelp" class="form-text text-muted">Indicanos tus apellidos</small>
				<form:errors path="lastName" cssClass="error-label" element="label" />
			</div>
		</div>
		<div class="form-group row">
		    <div class="col"><label for="email" class="col-form-label">Email</label></div>
		    <div class="col-4">
			    <form:input path="email" id="email" cssErrorClass="form-control required haserror" type="text" maxlength="50" cssClass="form-control required" aria-describedby="emailHelp" placeholder="Enter email" />
			    <small id="emailHelp" class="form-text text-muted">Indicanos tu correo</small>
			    <form:errors path="email" cssClass="error-label" element="label" />
		     </div>
		    <div class="col"><label for="username" class="col-form-label">Username</label></div>
		    <div class="col-4">
			    <form:input path="username" id="username" cssErrorClass="form-control required haserror" type="text" maxlength="50" cssClass="form-control required" aria-describedby="usernameHelp" placeholder="Enter username" />
			    <small id="usernameHelp" class="form-text text-muted">Indicanos tu nombre de usuario</small>
			    <form:errors path="username" cssClass="error-label" element="label" />
		     </div>
		</div>
		<div class="form-group row">
		     <div class="col"><label for="name" class="col-form-label">Password</label></div>
		     <div class="col-4">
			    <form:input path="password" id="password" cssErrorClass="form-control required haserror" type="text" maxlength="50" cssClass="form-control required" aria-describedby="passwordHelp" placeholder="Enter password" />
			    <small id="passwordHelp" class="form-text text-muted">Quieres cambiar el password ?</small>
			     <form:errors path="password" cssClass="error-label" element="label" />
			</div>
			<div class="col"><label for="repeatPassword" class="col-form-label">Password</label></div>
		     <div class="col-4">
			    <form:input path="repeatPassword" id="repeatPassword" cssErrorClass="form-control required haserror" type="text" maxlength="50" cssClass="form-control required" aria-describedby="repeatPasswordHelp" placeholder="Repeat password" />
			    <small id="repeatPasswordHelp" class="form-text text-muted">Quieres cambiar el password ?</small>
			    <form:errors path="repeatPassword" cssClass="error-label" element="label" />
			</div>
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<input type="hidden" name="id" value="${form.id}" />
	</form:form>
