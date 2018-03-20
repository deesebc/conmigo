<%@ include file="../tiles/view/taglib.jsp"%>
<div class="starter-template col-md-12">
	<div class="col-xs-12 global-messages"></div>
	<form:form modelAttribute="eventForm" method="post" action="${pageContext.request.contextPath}/profile" cssClass="form-signin">
		<div class="col-md-12">
			<h2 class="form-signin-heading">Update your profile</h2>
		</div>
		<div class="col-md-6">
			<div class="form-group">
			    <label for="name">First Name</label>
			    <form:input path="firstName" id="firstName" cssErrorClass="form-control required haserror" type="text" maxlength="50" cssClass="form-control required" aria-describedby="firstNameHelp" placeholder="Enter first name"  />
			    <small id="firstNameHelp" class="form-text text-muted">Indicanos tu nombre</small>
			     <form:errors path="firstName" cssClass="error-label" element="label" />
			</div>
			  
			<div class="form-group">
			    <label for="name">Last Name</label>
			    <form:input path="lastName" id="lastName" cssErrorClass="form-control required haserror" type="text" maxlength="50" cssClass="form-control required" aria-describedby="lastNameHelp" placeholder="Enter last name" />
			    <small id="lastNameHelp" class="form-text text-muted">Indicanos tus apellidos</small>
			     <form:errors path="lastName" cssClass="error-label" element="label" />
			</div>
		</div>
		<div class="col-md-6">  
			<div class="form-group">
			    <label for="name">Email</label>
			    <form:input path="email" id="email" cssErrorClass="form-control required haserror" type="text" maxlength="50" cssClass="form-control required" aria-describedby="emailHelp" placeholder="Enter email" />
			    <small id="emailHelp" class="form-text text-muted">Indicanos tu correo</small>
			     <form:errors path="email" cssClass="error-label" element="label" />
			</div>
			  
			<div class="form-group"></div>
	    </div>
	    <div class="col-md-6">  
			<div class="form-group">
			    <label for="name">Password</label>
			    <form:input path="password" id="password" cssErrorClass="form-control required haserror" type="text" maxlength="50" cssClass="form-control required" aria-describedby="passwordHelp" placeholder="Enter password" />
			    <small id="passwordHelp" class="form-text text-muted">Quieres cambiar el password ?</small>
			     <form:errors path="password" cssClass="error-label" element="label" />
			</div>
			  
			<div class="form-group">
			    <label for="name">Password</label>
			    <form:input path="repeatPassword" id="repeatPassword" cssErrorClass="form-control required haserror" type="text" maxlength="50" cssClass="form-control required" aria-describedby="repeatPasswordHelp" placeholder="Repeat password" />
			    <small id="repeatPasswordHelp" class="form-text text-muted">Quieres cambiar el password ?</small>
			     <form:errors path="repeatPassword" cssClass="error-label" element="label" />
			</div>
	    </div>
	    <div class="col-md-12">
			<div class="col-md-6">	  
				<button class="btn btn-lg btn-primary btn-block" type="submit" id="pass" name="pass">Save</button>
			</div>
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form:form>
</div>