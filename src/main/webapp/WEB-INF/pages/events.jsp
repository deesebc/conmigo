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
		<form modelAttribute="eventForm" method="post" action="${pageContext.request.contextPath}/events/search" cssClass="form-signin">
		  <div class="row">
		  	<div class="col-md-10">
		  		<input id="name" name="name" cssErrorClass="form-control required haserror" type="text" maxlength="50" class="form-control required"  placeholder="Busca el evento al que quieres ir" />
		  	</div>
		  	<div class="col-md-2">
		  		<button type="submit" class="btn btn-primary"><spring:message code="b.search" /></button>
		  	</div>
		  </div>
		  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
		<c:if test="${not empty events}">
			<br/>
			<table class="table table-striped">
				<thead>
					<th><spring:message code="l.type" /></th>
					<th><spring:message code="l.name" /></th>
					<th><spring:message code="l.place" /></th>
					<th><spring:message code="l.date" /></th>
					<th><spring:message code="l.actions" /></th>
				</thead>
				<tbody>
					<c:forEach items="${events}" var="item" varStatus="status">
						<tr>
							<td><spring:message code="item.type" /></td>
							<td>${item.name}</td>
							<td>${item.place}</td>
							<td>${item.date}</td>
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
				</tbody>
			</table>
		</c:if>
		<br/>
		<p>
			<form id="createEventForm" action="${pageContext.request.contextPath}/event/create">
				<spring:message code="c.ifDontSeeCreateIt" />&nbsp;<button type="submit" class="btn btn-primary"><spring:message code="b.createIt" /></button>
			</form>
			<!-- acceso publico a la pagina, y si no tiene permiso se meustra el boton en gris con display que indique que para crear se tiene que logar -->
		</p>
	</div>
	<br/>
</div>
<div>
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
</div>
