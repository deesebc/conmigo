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
	    <table class="table">
				<thead>
					<th scope="col"><spring:message code="l.type" /></th>
					<th scope="col"><spring:message code="l.name" /></th>
					<th scope="col"><spring:message code="l.place" /></th>
					<th scope="col"><spring:message code="l.date" /></th>
					<th scope="col"><spring:message code="l.actions" /></th>
				</thead>
				<tbody>
					<c:if test="${empty events}">
						<th scope="row" colspan="5"><spring:message code="c.thereIsNotEventCreateIt" /></td>
					</c:if>
					<c:if test="${not empty events}">
					<c:forEach items="${events}" var="item" varStatus="status">
						<tr>
							<th scope="row"><spring:message code="${item.type}" /></td>
							<td>${item.name}</td>
							<td>${item.place}</td>
							<td><javatime:format value="${item.date}" style="MS" /></td>
							<td>
								<button class="btn btn-primary" onclick="javascript: seeEvent(${item.id})"><spring:message code="b.see" /></button>&nbsp;&nbsp;
								<c:choose>
								  <c:when test="${fn:contains(userEvents, item.id)}">
								    <button class="btn btn-primary" onclick="javascript: disjoinToEvent(${item.id})" ><spring:message code="b.disjoin" /></button>
								  </c:when>
								  <c:otherwise>
								    <button class="btn btn-primary ${btnJoinDisable}" onclick="javascript: joinToEvent(${item.id})" ${btnJoinDisable}"><spring:message code="b.join" /></button>
								  </c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
					</c:if>
				</tbody>
			</table>
			<form id="seeEventForm" action="${pageContext.request.contextPath}/event/" method="post">
				<input type="hidden" id="idSeeEvent" name="id" />
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
			<form id="joinEventForm" action="${pageContext.request.contextPath}/event/join" method="post">
				<input type="hidden" id="idJoinEvent" name="id" />
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
			<form id="disjoinEventForm" action="${pageContext.request.contextPath}/event/disjoin" method="post">
				<input type="hidden" id="idDisjoinEvent" name="id" />
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
    </security:authorize>
  </div>
</section>
