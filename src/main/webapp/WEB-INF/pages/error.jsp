<%@ include file="../tiles/view/taglib.jsp"%>


<div class="row">
	<div class="bodyErrorPage">
		<p class="titleCometa">&iexcl;OOOPS!</p>
		<spring:message code="e.page.error" />
		<p class="txtCometa">
	</p>
		<img class="imgCometa img-responsive"
			src="${pageContext.request.contextPath}/resources/img/pageError.gif" alt="error" title="error" />
		<p class="footerCometa"><spring:message code="e.contact.support" /></p>
		</div>
</div>

<!--
    Error Status: ${errorstatus}
    Error Code: ${errorCode}
    Error Message: ${errorMessage}
    <c:forEach items="${errorTrace}" var="ste">${ste}</c:forEach>
  -->
