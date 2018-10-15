<%@ include file="../tiles/view/taglib.jsp"%>
<spring:message code="p.lastName" var="lastNamePHolder"/>
<spring:message code="p.name" var="namePHolder"/>
<spring:message code="p.email" var="emailPHolder"/>
<spring:message code="p.password" var="passwordPHolder"/>
<spring:message code="p.repeatPassword" var="repeatPasswordPHolder"/>
<div class="main-login main-center">
<form:form modelAttribute="registerForm" cssClass="form-horizontal" action="${pageContext.request.contextPath}/register" method="post">
  <fieldset>
  <h1 class="h3 mb-3 font-weight-normal"><spring:message code="c.pleaseSignUp" /></h1>
	<div class="form-group">
	  <div class="col-md-4">
	  <input id="name" name="name" type="text" placeholder="${namePHolder}" class="form-control input-md">
	  </div>
	</div>
	<div class="form-group">
	  <div class="col-md-4">
	  <input id="lastName" name="lastName" type="text" placeholder="${lastNamePHolder}" class="form-control input-md" required autofocus>
	  </div>
	</div>
	<div class="form-group">
	  <div class="col-md-4">
	  <input id="email" name="email" type="email" placeholder="${emailPHolder}" class="form-control input-md" required autofocus>
	  </div>
	</div>
	<div class="form-group">
	  <div class="col-md-4">
	  <input id="password" name="password" type="password" placeholder="${passwordPHolder}" class="form-control input-md" required autofocus>
	  </div>
	</div>
	<div class="form-group">
	  <div class="col-md-4">
	  <input id="repeatPassword" name="repeatPassword" type="password" placeholder="${repeatPasswordPHolder}" class="form-control input-md" required autofocus>
	  </div>
	</div>
	<div class="form-group">
  		<button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="b.registerYou" /></button>
  		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</div>
</fieldset>
</form:form>
</div>