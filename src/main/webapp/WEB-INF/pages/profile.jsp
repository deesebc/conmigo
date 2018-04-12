<%@ include file="../tiles/view/taglib.jsp"%>

	<div class="col-xs-12 global-messages"></div>
	<form:form modelAttribute="profileForm" method="post" action="${pageContext.request.contextPath}/profile/" id="profileForm">
		<div class="col-md-12">
			<h2 class="form-signin-heading"><spring:message code="c.updateYourProfile" /></h2>
		</div>
		<div class="form-group row">
		    <div class="col"><label for="name" class="col-form-label"><spring:message code="l.firstName" /></label></div>
		    <div class="col-4">
			    <form:input path="firstName" id="firstName" cssErrorClass="form-control  haserror" type="text" maxlength="50" cssClass="form-control " aria-describedby="firstNameHelp" placeholder="Enter first name"  />
			    <small id="firstNameHelp" class="form-text text-muted"><spring:message code="h.firstName" /></small>
			     <form:errors path="firstName" cssClass="error-label" element="label" />
		     </div>
		     <div class="col"><label for="lastName" class="col-form-label"><spring:message code="l.lastName" /></label></div>
		     <div class="col-4">
			    <form:input path="lastName" id="lastName" cssErrorClass="form-control  haserror" type="text" maxlength="50" cssClass="form-control " aria-describedby="lastNameHelp" placeholder="Enter last name" />
			    <small id="lastNameHelp" class="form-text text-muted"><spring:message code="h.lastName" /></small>
				<form:errors path="lastName" cssClass="error-label" element="label" />
			</div>
		</div>
		<div class="form-group row">
		    <div class="col"><label for="email" class="col-form-label"><spring:message code="l.email" /></label></div>
		    <div class="col-4">
			    <form:input path="email" id="email" cssErrorClass="form-control required email haserror" type="email" maxlength="50" cssClass="form-control email required" aria-describedby="emailHelp" placeholder="Enter email" />
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
			    <form:input path="birthdate" id="birthdate" cssErrorClass="form-control haserror" type="date" cssClass="form-control" aria-describedby="birthdatedHelp" placeholder="Enter birthdate"  />
			    <small id="birthdateHelp" class="form-text text-muted"><spring:message code="h.birthdate" /></small>
			    <form:errors path="birthdate" cssClass="error-label" element="label" />
			</div>
			<div class="col"><label for="gender" class="col-form-label"><spring:message code="l.gender" /></label></div>
		     <div class="col-4">
		     	<form:select path="gender">
		     		<form:option value="-">-</form:option>
		     		<form:options cssClass="form-control" items="${genderList}" itemLabel="name" itemValue="value"/>
		     	</form:select>
			    <small id="genderHelp" class="form-text text-muted"><spring:message code="h.gender" /></small>
			    <form:errors path="gender" cssClass="error-label" element="label" />
			</div>
		</div>
		<div class="form-group row">
		     <div class="col"><label for="town" class="col-form-label"><spring:message code="l.town" /></label></div>
		     <div class="col-4">
			    <form:select path="provinceId">
		     		<form:option value="">-</form:option>
		     		<form:options cssClass="form-control" items="${provinceList}" itemLabel="provincia" itemValue="id"/>
		     	</form:select>
			    <small id="townHelp" class="form-text text-muted"><spring:message code="h.town" /></small>
			    <form:errors path="town" cssClass="error-label" element="label" />
			</div>
			<div class="col"><label for="town" class="col-form-label"><spring:message code="l.town" /></label></div>
		     <div class="col-4">
			    <form:input path="town" id="town" cssErrorClass="form-control haserror" type="text" maxlength="50" cssClass="form-control" aria-describedby="townHelp" placeholder="Enter town" />
			    <small id="townHelp" class="form-text text-muted"><spring:message code="h.town" /></small>
			    <form:errors path="town" cssClass="error-label" element="label" />
			</div>
		</div>
		<div class="form-group row">
			<div class="col">
				<button class="btn btn-primary" type="submit">Submit form</button>
			</div>
			<div class="col">
				<button class="btn btn-primary" type="submit">Change password</button>
			</div>
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="csrfToken" />
		<input type="hidden" name="enable" value="${profileForm.enable}" id="enable"/>
		<form:hidden path="id" id="id"/>
		<form:hidden path="createdBy" id="createdBy"/>
		<form:hidden path="createdDate" id="createdDate"/>
	</form:form>
