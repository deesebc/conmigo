<%@ include file="../tiles/view/taglib.jsp"%>
<spring:message code="p.email" var="emailPHolder"/>
<spring:message code="p.password" var="passwordPHolder"/>
<form class="form-signin" action="${pageContext.request.contextPath}/login" method="post">
  <h1 class="h3 mb-3 font-weight-normal"><spring:message code="c.pleaseSignIn" /></h1>
  <label for="inputEmail" class="sr-only"><spring:message code="l.email" /></label>
  <input type="email" id="inputEmail" class="form-control" placeholder="${emailPHolder}" name="username" required autofocus>
  <label for="inputPassword" class="sr-only"><spring:message code="l.password" /></label>
  <input type="password" id="inputPassword" class="form-control" placeholder="${passwordPHolder}" name="password" required>
  <div class="checkbox mb-3">
    <label>
      <input type="checkbox" value="remember-me">&nbsp;<spring:message code="l.rememberMe" />
    </label>
  </div>
  <button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="b.login" /></button>
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<form class="form-signin" id="facebookForm" action="/auth/facebook">
  <input type="hidden" name="scope" value="email, public_profile" />
  <div class="checkbox mb-3">
    <label><spring:message code="c.ifYouPrefer" /></label>
  </div>
  <button class="btn btn-block btn-social btn-facebook" type="submit"><span class="fab fa-facebook-f"></span><spring:message code="b.loginFacebook" /></button>
</form>