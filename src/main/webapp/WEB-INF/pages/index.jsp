<%@ include file="../tiles/view/taglib.jsp"%>
<section class="jumbotron text-center">
  <div class="container">
    <h1 class="jumbotron-heading">Index example</h1>
    <p class="lead text-muted">Texto introductorio</p>
    <security:authorize access="!isFullyAuthenticated()">
	    <p>
	      <a href="${pageContext.request.contextPath}/register" class="btn btn-primary my-2"><spring:message code="l.registerYou" /></a>
	      <a href="${pageContext.request.contextPath}/events/" class="btn btn-secondary my-2"><spring:message code="l.events" /></a>
	    </p>
    </security:authorize>
    <security:authorize access="isFullyAuthenticated()">
	    <p>
	      Poner listado de eventos de la ciudad que a&uacute;n no hayan pasado
	    </p>
    </security:authorize>
  </div>
</section>
