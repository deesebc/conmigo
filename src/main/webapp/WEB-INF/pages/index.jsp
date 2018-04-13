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
					<c:if test="${empty events.content}">
						<th scope="row" colspan="5"><spring:message code="c.thereIsNotEventCreateIt" /></td>
					</c:if>
					<c:if test="${not empty events.content}">
					<c:forEach items="${events.content}" var="item" varStatus="status">
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
    </security:authorize>
  </div>
</section>
