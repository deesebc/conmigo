<%@ include file="../tiles/view/taglib.jsp"%>
<div class="starter-template">
	<div class="col-md-12">
		<c:if test="${not empty messages}">
			<table class="table table-striped">
				<thead>
					<th>User</th>
					<th>Date</th>
					<th>Acciones</th>
				</thead>
				<tbody>
					<c:forEach items="${messages}" var="item" varStatus="status">
						<tr>
							<td>${item.sender.name}</td>
							<td>${item.date}</td>
							<td></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</div>
