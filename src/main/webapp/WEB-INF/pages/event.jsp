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
		  
		  <div class="form-group">
		    <label for="name">Name</label>
		    <!--<input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="nameHelp" placeholder="Enter email">-->
		    <form:input path="name" id="name" cssErrorClass="form-control required haserror" type="text" maxlength="50" cssClass="form-control required" aria-describedby="nameHelp" placeholder="Enter name" />
		    <small id="nameHelp" class="form-text text-muted">Nombre del evento al que quieres ir</small>
		     <form:errors path="name" cssClass="error-label" element="label" />
		  </div>
		  
		  <div class="form-group">
		    <label for="place">Place</label>
		    <!--<input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="nameHelp" placeholder="Enter email">-->
		    <form:input path="place" id="place" cssErrorClass="form-control required haserror" type="text" maxlength="50" cssClass="form-control required" aria-describedby="placeHelp" placeholder="Enter place" />
		    <small id="nameHelp" class="form-text text-muted">Nombre del evento al que quieres ir</small>
		     <form:errors path="place" cssClass="error-label" element="label" />
		  </div>
		  
		  <div class="form-group">
		    <label for="date">Date</label>
		    <!--<input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="nameHelp" placeholder="Enter email">-->
		    <form:input path="date" id="date" cssErrorClass="form-control required haserror" type="text" maxlength="50" cssClass="form-control required" aria-describedby="dateHelp" placeholder="Enter date" />
		    <small id="dateHelp" class="form-text text-muted">Fecha del evento</small>
		     <form:errors path="date" cssClass="error-label" element="label" />
		  </div>
		  
		  <div class='col-sm-6'>
            <div class="form-group">
                <div class='input-group date' id='datetimepicker1'>
                    <input type='text' class="form-control" />
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>
        </div>
		  
		  <button class="btn btn-lg btn-primary btn-block" type="submit">Create</button>
		  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form:form>
	</div>
</div>