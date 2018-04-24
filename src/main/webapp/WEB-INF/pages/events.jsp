<%@ include file="../tiles/view/taglib.jsp"%>
<c:set var="btnJoinDisable" value="disabled" />
<security:authorize access="isFullyAuthenticated()">
	<c:set var="btnJoinDisable" value="" />
</security:authorize>
<div class="starter-template">
	<div class="col-md-12">
		<br/>
		<security:authorize access="!isFullyAuthenticated()">
			<div class="alert alert-warning" role="alert">
			  <spring:message code="c.joinAndSearchPerson" />
			  <a href="${pageContext.request.contextPath}/register" class="alert-link"><spring:message code="b.registerYou" /></a>
			  &nbsp;<spring:message code="c.or" />&nbsp;
			  <a href="${pageContext.request.contextPath}/login" class="alert-link"><spring:message code="b.login" /></a>
			</div>
		</security:authorize>
		<form:form modelAttribute="eventSearchForm" method="post" action="${pageContext.request.contextPath}/events/search" id="eventSearchForm">
		  <div class="row">
		  	<div class="col-md-10">
		  		<input id="name" name="name" cssErrorClass="form-control required haserror" type="text" maxlength="50" class="form-control required"  placeholder="Busca el evento al que quieres ir" />
		  	</div>
		  	<div class="col-md-2">
		  		<button type="submit" class="btn btn-primary"><spring:message code="b.search" /></button>
		  	</div>
		  </div>
		  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		  <form:hidden path="page" id="page"/>
		</form:form>
		<c:if test="${not empty events}">
			<br/>
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
								<button class="btn btn-primary" onclick="javascript: seeEvent(${item.id});"><spring:message code="b.see" /></button>&nbsp;&nbsp;
								<c:choose>
								  <c:when test="${fn:contains(userEvents, item.id)}">
								    <button class="btn btn-primary" onclick="javascript: disjoinToEvent(${item.id});" ><spring:message code="b.disjoin" /></button>
								  </c:when>
								  <c:otherwise>
								    <button class="btn btn-primary ${btnJoinDisable}" onclick="javascript: joinToEvent(${item.id});" ${btnJoinDisable}><spring:message code="b.join" /></button>
								  </c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
					</c:if>
				</tbody>
			</table>
			<nav aria-label="Page navigation example">
			  <ul class="pagination justify-content-end">
				<c:if test="${events.number gt 0}">
			  		<li class="page-item"><a class="page-link"  onclick="javascript: searchPaginate(0)" href="#">First</a></li>
			  		<li class="page-item"><a class="page-link" onclick="javascript: searchPaginate(${events.number-1})" href="#">Previous</a></li>
			  	</c:if>
			  	<c:if test="${events.number eq 0}">
			  		<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">First</a></li>
			  		<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">Previous</a></li>
			  	</c:if>
			  	<c:if test="${events.number gt 1}">
			  		<a class="page-link" onclick="javascript: searchPaginate(${events.number-2})" href="#" tabindex="-1">${events.number - 1}</a>
			  	</c:if>
			  	<c:if test="${events.number gt 0}">
			  		<a class="page-link" onclick="javascript: searchPaginate(${events.number-1})" href="#" tabindex="-1">${events.number}</a>
			  	</c:if>
			  	<li class="page-item active"><a class="page-link" href="#">${events.number + 1} <span class="sr-only">(current)</span></a></li>
			  	<c:if test="${events.number + 1 lt events.totalPages}">
			  		<a class="page-link" onclick="javascript: searchPaginate(${events.number+1})" href="#" tabindex="-1">${events.number + 2}</a>
			  	</c:if>
			    <c:if test="${events.number + 2 lt events.totalPages}">
			  		<a class="page-link" onclick="javascript: searchPaginate(${events.number+2})" href="#" tabindex="-1">${events.number + 3}</a>
			  	</c:if>
			  	<c:if test="${events.number + 1 lt events.totalPages}">
			  		<li class="page-item"><a class="page-link" onclick="javascript: searchPaginate(${events.number+1});" href="#">Next</a></li>
			  		<li class="page-item"><a class="page-link" onclick="javascript: searchPaginate(${events.totalPages});" href="#">Last</a></li>
			  	</c:if>
			  	<c:if test="${events.number+1 eq events.totalPages}">
			  		<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">Next</a></li>
			  		<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">Last</a></li>
			  	</c:if>
			  	
			  </ul>
			</nav>
		</c:if>
		<p>
			<form id="createEventForm" action="${pageContext.request.contextPath}/event/create">
				<spring:message code="c.ifDontSeeCreateIt" />&nbsp;&nbsp;<button type="submit" class="btn btn-primary"><spring:message code="b.createIt" /></button>
			</form>
			<!-- acceso publico a la pagina, y si no tiene permiso se meustra el boton en gris con display que indique que para crear se tiene que logar -->
		</p>
	</div>
	<br/>
</div>
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
