<%@ include file="../tiles/view/taglib.jsp"%>
<div class="starter-template col-md-12">
	<c:if test="${event eq null}">
		<form:form modelAttribute="eventForm" method="post" action="${pageContext.request.contextPath}/event/create" cssClass="form-signin">
			<div class="col-md-12">
				<h2 class="form-signin-heading">Create your Event</h2>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label for="name">Evento</label>
					<form:select path="type" id="type" class="js-example-basic-single form-control required" cssErrorClass="form-control required haserror">
						<form:option value="" selected="selected"><spring:message code="c.choose.option" /></form:option>
						<form:options items="${types}" />
					</form:select>
				</div>
				  
				<div class="form-group">
				    <label for="name">Name</label>
				    <form:input path="name" id="name" cssErrorClass="form-control required haserror" type="text" maxlength="50" cssClass="form-control required" aria-describedby="nameHelp" placeholder="Enter name" />
				    <small id="nameHelp" class="form-text text-muted">Nombre del evento al que quieres ir</small>
				     <form:errors path="name" cssClass="error-label" element="label" />
				  </div>
			</div>
			<div class="col-md-6">  
				  <div class="form-group">
				    <label for="place">Place</label>
				    <form:input path="place" id="place" cssErrorClass="form-control required haserror" type="text" maxlength="50" cssClass="form-control required" aria-describedby="placeHelp" placeholder="Enter place" />
				    <small id="placeHelp" class="form-text text-muted">Nombre del evento al que quieres ir</small>
				    <form:errors path="place" cssClass="error-label" element="label" />
				  </div>
				  
		           <div class="form-group">
		               <div class='input-group date' id='datetimepicker'>
		                   <form:input path="date" id="date" cssErrorClass="form-control required haserror" type="text" maxlength="50" cssClass="form-control required" aria-describedby="dateHelp" placeholder="Enter date" />
		                   <span class="input-group-addon">
		                       <span class="glyphicon glyphicon-calendar" ></span>
		                   </span>
		               </div>
		               <small id="dateHelp" class="form-text text-muted">Fecha del evento al que quieres ir</small>
		           </div>
		    </div>
		    <div class="col-md-12">
				<div class="col-md-6">	  
					<button class="btn btn-lg btn-primary btn-block" type="submit" id="pass" name="pass">Create</button>
				</div>
				<div class="col-md-6">
					<button class="btn btn-lg btn-primary btn-block" type="submit" id="join" name="join">Create And Join</button>
				</div>
			</div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form:form>
	</c:if>
	<c:if test="${event ne null}">
		<security:authentication var="user" property="principal" />
		<div class="col-md-12">
			<div class="col-md-12">
				<h2 class="form-signin-heading">VIEW your Event</h2>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label for="name">Evento</label>
					<spring:message code="${event.type }" />
				</div>
				  
				<div class="form-group">
				    <label for="name">Name</label>
				    ${event.name }
				  </div>
			</div>
			<div class="col-md-6">  
				  <div class="form-group">
				    <label for="place">Place</label>
				    ${event.place }
				  </div>
				  
		           <div class="form-group">
		           	 <label for="place">Date</label>
		               ${event.date }
		           </div>
		    </div>
		    <c:if test="${ not empty event.users}">
			    <table class="table table-striped">
					<thead>
						<th>Name</th>
						<th>Email</th>
						<th>Acciones</th>
					</thead>
					<tbody>
						<c:forEach items="${event.users}" var="item" varStatus="status">
							<tr>
								<td>${item.name}</td>
								<td>${item.email}</td>
								<td>
									<c:if test="${item.id ne user.id}">
										<button class="btn btn-primary" onclick="javascript: sendMessage(${item.id})">ENVIAR MENSAJES</button>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</c:if>
</div>