<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<h3>Todos for ${name}</h3>
<div class="container">
	<table class="table table-bordered table-condensed table-hover ">
		<caption><spring:message code="todo.caption" /></caption>

		<thead>
			<tr>
				<th>Description</th>
				<th>Date</th>
				<th>Completed</th>
				<th></th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.desc}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${todo.targetDate}" /></td>
					<td>${todo.done}</td>
					<td>
						<a type="button" class="btn btn-success" href="/todo/update-todo?id=${todo.id}">Edit</a>
						<a type="button" class="btn btn-danger" href="/todo/delete-todo?id=${todo.id}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<a class="btn btn-primary" href="/todo/add-todo">Add</a>
	</div>
</div>

<%@ include file="common/footer.jspf"%>