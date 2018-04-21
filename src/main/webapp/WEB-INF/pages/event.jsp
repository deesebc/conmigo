<%@ include file="../tiles/view/taglib.jsp"%>
<div class="starter-template col-md-12">
	<div class="col-xs-12 global-messages"></div>
	<c:if test="${event eq null}">
		<form:form modelAttribute="eventForm" method="post" action="${pageContext.request.contextPath}/event/create" id="eventForm">
			<div class="col-md-12">
				<h2 class="form-signin-heading"><spring:message code="c.createYourEvent" /></h2>
			</div>
			<div class="form-group row">
				<div class="col"><label for="type" class="col-form-label"><spring:message code="l.event" /></label></div>
				<div class="col-4">
					<form:select path="type" class="required" aria-describedby="typeHelp">
			     		<form:option value="-" selected="selected"><spring:message code="c.choose.option" /></form:option>
			     		<form:options cssClass="form-control" items="${typeList}"/>
			     	</form:select>
			     	<small id="typeHelp" class="form-text text-muted"><spring:message code="h.eventType" /></small>
		     	</div>
		     	<div class="col"><label for="name" class="col-form-label"><spring:message code="l.name" /></label></div>
		     	<div class="col-4">
				    <form:input path="name" id="name" cssErrorClass="form-control required haserror" type="text" maxlength="50" cssClass="form-control required" aria-describedby="nameHelp" placeholder="Enter name"  />
				    <small id="nameHelp" class="form-text text-muted"><spring:message code="h.eventName" /></small>
				    <form:errors path="name" cssClass="error-label" element="label" />
			    </div>
			</div>
			<div class="form-group row">
				<div class="col"><label for="place" class="col-form-label"><spring:message code="l.place" /></label></div>
				<div class="col-4">
					<form:input path="place" id="place" cssErrorClass="form-control required haserror" type="text" maxlength="50" cssClass="form-control required" aria-describedby="placeHelp" placeholder="Enter place"  />
				    <small id="placeHelp" class="form-text text-muted"><spring:message code="h.eventPlace" /></small>
				    <form:errors path="place" cssClass="error-label" element="label" />
		     	</div>
		     	<div class="col"><label for="date" class="col-form-label"><spring:message code="l.date" /></label></div>
			     <div class="col-4">
				    <form:input path="date" id="date" cssErrorClass="form-control haserror" type="datetime-local" cssClass="form-control" aria-describedby="dateHelp" placeholder="Enter Date"  />
				    <small id="dateHelp" class="form-text text-muted"><spring:message code="h.eventDate" /></small>
				    <form:errors path="date" cssClass="error-label" element="label" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col"><label for="provinceId" class="col-form-label"><spring:message code="l.province" /></label></div>
			    <div class="col-4">
				    <form:select path="provinceId">
			     		<form:option value="">-</form:option>
			     		<form:options cssClass="form-control" items="${provinceList}" itemLabel="provincia" itemValue="id"/>
			     	</form:select>
				    <small id="provinceHelp" class="form-text text-muted"><spring:message code="h.province" /></small>
				    <form:errors path="provinceId" cssClass="error-label" element="label" />
				</div>
		     	<div class="col"></div>
			    <div class="col-4"></div>
			</div>
			<div class="form-group row">
				<div class="col">
					<button class="btn btn-primary" type="submit" id="pass" name="pass"><spring:message code="b.createIt" /></button>
				</div>
				<div class="col">
					<button class="btn btn-primary" type="submit" id="join" name="join"><spring:message code="b.createAndJoin" /></button>
				</div>
			</div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form:form>
	</c:if>
	<c:if test="${event ne null}">
		<c:set var="showBtnJoin" value="true" />
		<security:authentication var="user" property="principal" />
			<div class="col-md-12">
				<h2 class="form-signin-heading"><spring:message code="c.Event" /></h2>
			</div>
			<div class="form-group row">
				<div class="col"><label for="type" class="col-form-label"><spring:message code="l.event" /></label></div>
				<div class="col-4"><spring:message code="${event.type}" /></div>
		     	<div class="col"><label for="name" class="col-form-label"><spring:message code="l.name" /></label></div>
		     	<div class="col-4">${event.name }</div>
			</div>
			<div class="form-group row">
				<div class="col"><label for="type" class="col-form-label"><spring:message code="l.place" /></label></div>
				<div class="col-4">${event.place}</div>
		     	<div class="col"><label for="name" class="col-form-label"><spring:message code="l.date" /></label></div>
		     	<div class="col-4"><javatime:format value="${event.date}" style="MS" /></div>
			</div>
			<div class="form-group row">
				<div class="col"><label for="type" class="col-form-label"><spring:message code="l.province" /></label></div>
				<div class="col-4">${event.province.provincia}</div>
		     	<div class="col"></div>
		     	<div class="col-4"></div>
			</div>
			<c:if test="${ not empty event.users}">
			    <table class="table">
					<thead>
						<th scope="col"><spring:message code="l.username" /></th>
						<th scope="col"><spring:message code="l.datas" /></th>
						<th scope="col"><spring:message code="l.actions" /></th>
					</thead>
					<tbody>
						<c:forEach items="${event.users}" var="item" varStatus="status">
							<tr>
								<th scope="row">${item.username}</td>
								<td>
									<c:if test="${item.gender eq 'F'}"><i class="fas fa-female"></i></c:if>
									<c:if test="${item.gender eq 'M'}"><i class="fas fa-male"></i></c:if>
									<c:if test="${not empty item.birthdate}">${cf:getBirthdateRange(item.birthdate)}</c:if>
								</td>
								<td>
									<security:authorize access="isFullyAuthenticated()">
										<c:if test="${item.id ne user.id}">
											<button class="btn btn-primary" type="button" onclick="javascript: sendMessageTo(${event.id},${item.id});"><spring:message code="b.sendMessage" /></button>
										</c:if>
										<c:if test="${item.id eq user.id}">
											<button class="btn btn-primary" onclick="javascript: joinToEvent(${item.id})"><spring:message code="b.disjoin" /></button>
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
<!-- hidden forms -->
<form id="sendMessageToForm" action="${pageContext.request.contextPath}/chatroom/" method="post">
	<input type="hidden" id="eventId" name="eventId" />
	<input type="hidden" id="receiverId" name="receiverId" />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>