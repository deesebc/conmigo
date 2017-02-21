<%@ include file="../tiles/view/taglib.jsp"%>
<div class="starter-template">
	<div class="col-md-12">
		<form modelAttribute="eventForm" method="post" action="${pageContext.request.contextPath}/events/search" cssClass="form-signin">
		  <div class="form-group">
		  	<div class="col-md-10">
		  		<input id="name" name="name" cssErrorClass="form-control required haserror" type="text" maxlength="50" class="form-control required"  placeholder="Busca el evento al que quieres ir" />
		  	</div>
		  	<div class="col-md-2">
		  		<button type="submit" class="btn btn-primary">Buscar</button>
		  	</div>
		  </div>
		  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	<br/><br/><br/><br/>
		<c:if test="${not empty events}">
			<table class="table table-striped">
				<thead>
					<th>Type</th>
					<th>Name</th>
					<th>Place</th>
					<th>Date</th>
				</thead>
				<tbody>
					<c:forEach items="${events}" var="item" varStatus="status">
						<tr>
							<td><spring:message code="${item.type}" /></td>
							<td>${item.name}</td>
							<td>${item.place}</td>
							<td>${item.date}</td>
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
</div>
