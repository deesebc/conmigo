<%@ include file="../tiles/view/taglib.jsp"%>
<form:form modelAttribute="registerForm" cssClass="form-signin" action="${pageContext.request.contextPath}/register" method="post">
  <h1 class="h3 mb-3 font-weight-normal"><spring:message code="c.pleaseSignUp" /></h1>
  <label for="inputEmail" class="sr-only"><spring:message code="l.email" /></label>
  <input type="email" id="inputEmail" class="form-control" placeholder="Email address" name="email" required autofocus>
  <label for="inputPassword" class="sr-only"><spring:message code="l.password" /></label>
  <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password" required>
  <label for="inputRepeatPassword" class="sr-only"><spring:message code="l.password" /></label>
  <input type="password" id="inputRepeatPassword" class="form-control" placeholder="Repeat Password" name="repeatPassword" required>
  <div class="checkbox mb-3">
    <label>
      <input type="checkbox" value="remember-me">&nbsp;<spring:message code="l.rememberMe" />
    </label>
  </div>
  <button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="b.registerYou" /></button>
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form:form>


