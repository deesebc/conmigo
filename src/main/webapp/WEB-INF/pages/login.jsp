<%@ include file="../tiles/view/taglib.jsp"%>
<form class="form-signin" action="${pageContext.request.contextPath}/login" method="post">
  <h1 class="h3 mb-3 font-weight-normal"><spring:message code="c.pleaseSignIn" /></h1>
  <label for="inputEmail" class="sr-only"><spring:message code="l.email" /></label>
  <input type="email" id="inputEmail" class="form-control" placeholder="Email address" name="username" required autofocus>
  <label for="inputPassword" class="sr-only"><spring:message code="l.password" /></label>
  <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password" required>
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
  <h1 class="h6 mb-3 font-weight-normal"><spring:message code="c.pleaseAuthFacebook" /></h1>
  <button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="b.login" /></button>
</form>