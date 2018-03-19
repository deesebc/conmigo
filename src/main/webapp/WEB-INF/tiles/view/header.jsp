<%@ include file="taglib.jsp"%>
<header>
<div class="navbar-header">
  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
    <span class="sr-only">Toggle navigation</span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
  </button>
  <a class="navbar-brand active" href="/">Conmigo</a>
</div>
<div id="navbar" class="collapse navbar-collapse">
  <ul class="nav navbar-nav">
    <li class=${fn:contains(requestScope['javax.servlet.forward.request_uri'], 'events') ? 'active':''}><a href="/events/">Eventos</a></li>
    <li class=${fn:contains(requestScope['javax.servlet.forward.request_uri'], 'messages') ? 'active':''}><a href="/messages/">Mensajes</a></li>
    <security:authorize access="!isFullyAuthenticated()">
    	<li><a href="/profile/">Perfil</a></li>
    	<li><a href="${pageContext.request.contextPath}/login">Login</a></li>
    	<li><a href="${pageContext.request.contextPath}/register">Register</a></li>
    </security:authorize>
    <security:authorize access="isFullyAuthenticated()">
    	<li><a href="#contact">Hola <security:authentication property="principal.username" /></a></li>
    	<li><a href="/logout">Logout</a></li>
    </security:authorize>
  </ul>
</div><!--/.nav-collapse -->
</header>