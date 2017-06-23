<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<script type="text/javascript"
	src="../../resources/javascript/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../../resources/javascript/crud.js"></script>
<title>${title}</title>
</head>
<body>
	<input type="hidden" name="updated" value="${updated}" />
	<div id="updatedDiv" style="display: none;">Couldn't update item!</div>
	<c:choose>
		<c:when test="${empty item}">
			<h4>Item not found</h4>
		</c:when>
		<c:otherwise>
			<form:form action="" method="post" commandName="item">
				<table>
					<tr>
						<td>Name:</td>
						<td><form:input path="name" type="text" value="${item.name}" /></td>
					</tr>
					<tr>
						<td>Description:</td>
						<td><form:input path="description" type="text"
								value="${item.description}" /></td>
					</tr>
					<tr>
						<td>Image Url:</td>
						<td><form:input path="imageUrl" type="text"
								value="${item.imageUrl}" /></td>
					</tr>
					<tr>
						<td><button type="button" class="backBtn"
								data-url="../../list">Back</button></td>
						<td><button type="submit">Update</button></td>
					</tr>
				</table>
			</form:form>
		</c:otherwise>
	</c:choose>
</body>
</html>