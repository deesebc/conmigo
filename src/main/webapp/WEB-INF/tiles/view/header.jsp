<%@ include file="taglib.jsp"%>
<c:set var="actReqtUri" value="${requestScope['javax.servlet.forward.request_uri']}" />
  <a class="navbar-brand" href="/"><spring:message code="l.conmigo" /></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarCollapse">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item ${fn:contains(actReqtUri, 'events') ? 'active':''}">
      	<a class="nav-link" href="${pageContext.request.contextPath}/events/"><spring:message code="l.events" /></a>
      </li>
      <li class="nav-item ${fn:contains(actReqtUri, 'messages') ? 'active':''}">
      	<a class="nav-link" href="${pageContext.request.contextPath}/messages/"><spring:message code="l.messages" /></a>
      </li>
      <security:authorize access="isFullyAuthenticated()">
	    <li class="${fn:contains(actReqtUri, 'profile') ? 'active':''}">
	    	<a class="nav-link" href="${pageContext.request.contextPath}/profile/"><spring:message code="l.profile" /></a>
	    </li>
	    <li><a class="nav-link" href="${pageContext.request.contextPath}/logout"><spring:message code="l.logout" /></a></li>
	    <li><a class="nav-link" href="#"><spring:message code="l.hello" /> <security:authentication property="principal.username" /></a><li>
	  </security:authorize>
      <security:authorize access="!isFullyAuthenticated()">
	    <li class="${fn:contains(actReqtUri, 'login') ? 'active':''}">
	    	<a class="nav-link" href="${pageContext.request.contextPath}/login"><spring:message code="l.login" /></a>
	    </li>
	  	<li class="${fn:contains(actReqtUri, 'register') ? 'active':''}">
	  		<a class="nav-link" href="${pageContext.request.contextPath}/register"><spring:message code="l.registerYou" /></a>
	  	</li>
	  </security:authorize>
    </ul>
    <!-- 
    <form class="form-inline mt-2 mt-md-0">
      <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
    -->
  </div>

