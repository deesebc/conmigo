<%@ include file="../tiles/view/taglib.jsp"%>
<div class="starter-template">
	<h1>Event Page</h1>
	<div>
		<form:form modelAttribute="eventForm" method="post" action="${pageContext.request.contextPath}/event" cssClass="form-signin">
		  <h2 class="form-signin-heading">Create your Event</h2>
		  <form:select path="type" id="type" class="js-example-basic-single form-control required" cssErrorClass="form-control required haserror">
			  <form:option value="" selected="selected"><spring:message code="c.choose.option" /></form:option>
			  <form:options items="${types}" />
		  </form:select>
		  <label for="inputName" class="sr-only">Name</label>
		  <form:input path="name" id="name" class="form-control required" cssErrorClass="form-control required haserror" type="text" maxlength="50" />
		  <form:errors path="name" cssClass="error-label" element="label" />
		  <label for="inputPlace" class="sr-only">Place</label>
		  <form:input path="place" id="place" class="form-control required" cssErrorClass="form-control required haserror" type="text" maxlength="50"  />
		  <form:errors path="place" cssClass="error-label" element="label" />
		  <label for="inputDate" class="sr-only">Date</label>
		  <form:input path="date" id="date" class="form-control required" cssErrorClass="form-control required haserror" type="text" maxlength="50"  />
		  <form:errors path="date" cssClass="error-label" element="label" />
		  <button class="btn btn-lg btn-primary btn-block" type="submit">Create</button>
		  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form:form>
	</div>
</div>
