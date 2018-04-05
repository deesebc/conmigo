<%@ include file="../tiles/view/taglib.jsp"%>

	<div class="col-xs-12 global-messages"></div>
	<form:form modelAttribute="form" method="put" action="${pageContext.request.contextPath}/profile">
		<div class="col-md-12">
			<h2 class="form-signin-heading"><spring:message code="c.updateYourProfile" /></h2>
		</div>
		<div class="form-group row">
		    <div class="col"><label for="name" class="col-form-label"><spring:message code="l.firstName" /></label></div>
		    <div class="col-4">
			    <form:input path="firstName" id="firstName" cssErrorClass="form-control required haserror" type="text" maxlength="50" cssClass="form-control required" aria-describedby="firstNameHelp" placeholder="Enter first name"  />
			    <small id="firstNameHelp" class="form-text text-muted"><spring:message code="h.firstName" /></small>
			     <form:errors path="firstName" cssClass="error-label" element="label" />
		     </div>
		     <div class="col"><label for="lastName" class="col-form-label"><spring:message code="l.lastName" /></label></div>
		     <div class="col-4">
			    <form:input path="lastName" id="lastName" cssErrorClass="form-control required haserror" type="text" maxlength="50" cssClass="form-control required" aria-describedby="lastNameHelp" placeholder="Enter last name" />
			    <small id="lastNameHelp" class="form-text text-muted"><spring:message code="h.lastName" /></small>
				<form:errors path="lastName" cssClass="error-label" element="label" />
			</div>
		</div>
		<div class="form-group row">
		    <div class="col"><label for="email" class="col-form-label"><spring:message code="l.email" /></label></div>
		    <div class="col-4">
			    <form:input path="email" id="email" cssErrorClass="form-control required haserror" type="text" maxlength="50" cssClass="form-control required" aria-describedby="emailHelp" placeholder="Enter email" />
			    <small id="emailHelp" class="form-text text-muted"><spring:message code="h.email" /></small>
			    <form:errors path="email" cssClass="error-label" element="label" />
		     </div>
		    <div class="col"><label for="username" class="col-form-label"><spring:message code="l.username" /></label></div>
		    <div class="col-4">
			    <form:input path="username" id="username" cssErrorClass="form-control required haserror" type="text" maxlength="50" cssClass="form-control required" aria-describedby="usernameHelp" placeholder="Enter username" />
			    <small id="usernameHelp" class="form-text text-muted"><spring:message code="h.username" /></small>
			    <form:errors path="username" cssClass="error-label" element="label" />
		     </div>
		</div>
		<div class="form-group row">
		     <div class="col"><label for="birthdate" class="col-form-label"><spring:message code="l.birthdate" /></label></div>
		     <div class="col-4">
			    <form:input path="birthdate" id="birthdate" cssErrorClass="form-control required haserror" type="text" maxlength="50" cssClass="form-control required" aria-describedby="birthdatedHelp" placeholder="Enter birthdate" />
			    <small id="birthdateHelp" class="form-text text-muted"><spring:message code="h.birthdate" /></small>
			     <form:errors path="birthdate" cssClass="error-label" element="label" />
			</div>
			<div class="col"><label for="gender" class="col-form-label"><spring:message code="l.gender" /></label></div>
		     <div class="col-4">
			    <form:input path="gender" id="gender" cssErrorClass="form-control required haserror" type="text" maxlength="50" cssClass="form-control required" aria-describedby="genderHelp" placeholder="Enter gender" />
			    <small id="genderHelp" class="form-text text-muted"><spring:message code="h.gender" /></small>
			    <form:errors path="gender" cssClass="error-label" element="label" />
			</div>
		</div>
		<div class="form-group row">
		     <div class="col"><label for="town" class="col-form-label"><spring:message code="l.town" /></label></div>
		     <div class="col-4">
			    <form:input path="town" id="town" cssErrorClass="form-control required haserror" type="text" maxlength="50" cssClass="form-control required" aria-describedby="townHelp" placeholder="Enter town" />
			    <small id="townHelp" class="form-text text-muted"><spring:message code="h.town" /></small>
			     <form:errors path="town" cssClass="error-label" element="label" />
			</div>
			<div class="col"></div>
		     <div class="col-4">
			</div>
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<input type="hidden" name="id" value="${form.id}" />
	</form:form>
