<%@ include file="../tiles/view/taglib.jsp"%>
<form:form modelAttribute="registerForm" method="post" action="${pageContext.request.contextPath}/register" cssClass="form-signin">
  <h2 class="form-signin-heading">Please sign up</h2>
  <label for="inputEmail" class="sr-only">Email address</label>
  <form:input path="email" id="email" class="form-control required" cssErrorClass="form-control required haserror" type="text" maxlength="50" />
  <form:errors path="email" cssClass="error-label" element="label" />
  <label for="inputPassword" class="sr-only">Password</label>
  <form:input path="password" id="password" class="form-control required" cssErrorClass="form-control required haserror" type="password" maxlength="50"  />
  <form:errors path="password" cssClass="error-label" element="label" />
  <label for="inputPasswordRepeated" class="sr-only">Password Repeated</label>
  <form:input path="passwordRepeated" id="passwordRepeated" class="form-control required" cssErrorClass="form-control required haserror" type="password" maxlength="50"  />
  <div class="checkbox">
    <label>
      <input type="checkbox" value="remember-me"> Remember me
    </label>
  </div>
  <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form:form>
