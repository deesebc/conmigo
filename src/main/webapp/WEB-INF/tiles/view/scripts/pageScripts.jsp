<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<script src="/webjars/jquery/1.11.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
	var config = {
		contextPath : "${pageContext.request.contextPath}",
	};
	var translations = {
			eMessageNotEmpty: "<spring:message code="e.message.not.empty" />",
			eAjaxError: "<spring:message code="e.ajax.error" />",
			sMessageCreate: "<spring:message code="s.message.create" />"
	};
</script>
<script src="${pageContext.request.contextPath}/resources/js/conmigo.js"></script>
