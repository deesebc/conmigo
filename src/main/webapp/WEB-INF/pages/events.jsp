<%@ include file="../tiles/view/taglib.jsp"%>
<div class="starter-template">
	<h1>Events Page</h1>
	<p class="lead">
		Use this document as a way to quickly start any new project.<br>
		All you get is this text and a mostly barebones HTML document.
	</p>
	<p>Poner barra buscador</p>

	<c:if test="${not empty events}">
		<table style="width: 100%">
			<thead>
				<th>Type</th>
				<th>Name</th>
				<th>Place</th>
				<th>Date</th>
			</thead>
			<tbody>
				<c:forEach items="${events}" var="item" varStatus="status">
					<tr>
						<td>${item.type}</td>
						<td>${item.name}</td>
						<td>${item.place}</td>
						<td>${item.date}</td>
					</tr>
				</c:forEach>
			</tbody>
	</c:if>
	<br/>
	<p>Si no lo encuentras, crealo ;-) BUTTON</p>
</div>
