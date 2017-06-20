<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<script type="text/javascript"
	src="resources/javascript/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="resources/javascript/crud.js"></script>
<title>List</title>
<style type="text/css">
.list_table {
	border: 1px solid black;
	border-bottom: none;
	border-right: none;
}

.list_table td, th {
	border-bottom: 1px solid black;
	border-right: 1px solid black;
	text-align: center;
	vertical-align: middle;
	padding: 5px;
}
#errorDiv{
	color: red;
	margin-bottom: 5px;
}
</style>
</head>
<body>
	<div id = "errorDiv"></div>
	<table class="list_table" cellspacing="0" cellpadding="0">
		<tr>
			<th>Image</th>
			<th>Name</th>
			<th>Description</th>
			<th colspan="2">Action</th>
		</tr>
		<c:forEach items="${items}" var="item">
			<tr>
				<td><img src="${item.imageUrl}" width="64px" height="64px"
					alt="?" /></td>
				<td>${item.name}</td>
				<td>${item.description}</td>
				<td colspan="2">
					<button>Edit</button> |
					<button class="deleteBtn" data-id="${item.id}">Delete</button>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>