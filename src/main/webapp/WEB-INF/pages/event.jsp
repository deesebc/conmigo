<%@ include file="../tiles/view/taglib.jsp"%>
<div class="starter-template col-md-12">
	<div class="col-xs-12 global-messages"></div>
	<c:if test="${event eq null}">
		<form:form modelAttribute="eventForm" method="post" action="${pageContext.request.contextPath}/event/create" cssClass="form-signin">
			<div class="col-md-12">
				<h2 class="form-signin-heading"><spring:message code="c.createYourEvent" /></h2>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label for="name"><spring:message code="l.event" /></label>
					<form:select path="type" id="type" class="js-example-basic-single form-control required" cssErrorClass="form-control required haserror">
						<form:option value="" selected="selected"><spring:message code="c.choose.option" /></form:option>
						<form:options items="${types}" />
					</form:select>
				</div>
				  
				<div class="form-group">
				    <label for="name"><spring:message code="l.name" /></label>
				    <form:input path="name" id="name" cssErrorClass="form-control required haserror" type="text" maxlength="50" cssClass="form-control required" aria-describedby="nameHelp" placeholder="Enter name" />
				    <small id="nameHelp" class="form-text text-muted"><spring:message code="c.nameEventWhichYouWant" /></small>
				     <form:errors path="name" cssClass="error-label" element="label" />
				  </div>
			</div>
			<div class="col-md-6">  
				  <div class="form-group">
				    <label for="place"><spring:message code="l.place" /></label>
				    <form:input path="place" id="place" cssErrorClass="form-control required haserror" type="text" maxlength="50" cssClass="form-control required" aria-describedby="placeHelp" placeholder="Enter place" />
				    <small id="placeHelp" class="form-text text-muted"><spring:message code="c.nameEventWhichYouWant" /></small>
				    <form:errors path="place" cssClass="error-label" element="label" />
				  </div>
				  
		           <div class="form-group">
		               <div class='input-group date' id='datetimepicker'>
		                   <form:input path="date" id="date" cssErrorClass="form-control required haserror" type="text" maxlength="50" cssClass="form-control required" aria-describedby="dateHelp" placeholder="Enter date" />
		                   <span class="input-group-addon">
		                       <span class="glyphicon glyphicon-calendar" ></span>
		                   </span>
		               </div>
		               <small id="dateHelp" class="form-text text-muted"><spring:message code="c.eventDate" /></small>
		           </div>
		    </div>
		    <div class="col-md-12">
				<div class="col-md-6">	  
					<button class="btn btn-lg btn-primary btn-block" type="submit" id="pass" name="pass"><spring:message code="b.createIt" /></button>
				</div>
				<div class="col-md-6">
					<button class="btn btn-lg btn-primary btn-block" type="submit" id="join" name="join"><spring:message code="b.createAndJoin" /></button>
				</div>
			</div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form:form>
	</c:if>
	<c:if test="${event ne null}">
		<c:set var="showBtnJoin" value="true" />
		<security:authentication var="user" property="principal" />
		<br/>
		<div class="col-md-12">
			<div class="col-md-6">
				<div class="form-group">
					<label for="name"><spring:message code="l.event" /></label>
					<spring:message code="event.type" />
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
									<security:authorize access="isFullyAuthenticated()">
										<c:if test="${item.id ne user.id}">
											<button class="btn btn-primary" type="button" data-toggle="modal" data-target="#mesaggeDialog" onclick="javascript: setUserIdMessageTo(${item.id},${user.id});"><spring:message code="b.sendMessage" /></button>
										</c:if>
										<c:if test="${item.id eq user.id}">
											<button class="btn btn-primary" onclick="javascript: joinToEvent(${item.id})""><spring:message code="b.disjoin" /></button>
											<c:set var="showBtnJoin" value="false" />
										</c:if>
									</security:authorize>
									<security:authorize access="!isFullyAuthenticated()">
										<button class="btn btn-primary disabled" type="button" disabled><spring:message code="b.sendMessage" /></button>
									</security:authorize>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
		<section class="row">
		  <div class="btn-group center">
		  	<form action="${pageContext.request.contextPath}/events/">
		    &nbsp;<button type="submit" class="btn btn-secondary"><spring:message code="b.back" /></button>&nbsp;
		    </form>
		    <security:authorize access="isFullyAuthenticated()">
		  		<c:if test="${showBtnJoin}">
		    		&nbsp;<button type="button" class="btn btn-primary"><spring:message code="b.join" /></button>&nbsp;
		  		</c:if>
		  	</security:authorize>
		  </div>
		</section>
	</c:if>
</div>
<!-- Modal -->
<div class="modal fade" id="mesaggeDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel"><spring:message code="b.sendMessage" /></h4>
      </div>
      <div class="modal-body interest-grid col-xs-12"> 
      	<div class="create-popup-messages"></div>
      	<textarea id="message" name="message"></textarea> 	
      </div>
      <div class="modal-footer">
        <button id="save-message" onclick="javascript:sendMessage();" class="btn btn-primary"><spring:message code="b.sendMessage" /></button>
      </div>
    </div>
  </div>
</div>