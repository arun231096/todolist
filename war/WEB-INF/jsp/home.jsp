<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<html>
<head>
	<title>Home</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="col-sm-12" style="padding:40px;">
		<h1>Welcome to ToDo!</h1>
	<c:if test="${not empty lists}">

		<table border="1" class="table table-striped">
			<tr>
				<th>Id</th>
				<th>Title</th>
				<th>Estimation</th>
				<th>Start Date</th>
				<th>Due Date</th>
				<th>Message</th>
				<th>Status</th>
				<th>Edit Progress</th>
				<th>Remove Progress</th>
			</tr>
			<c:forEach var="listValue" items="${lists}">
				<tr>
					<td>${listValue.id}</td>
					<td>${listValue.title}</td>
					<td>${listValue.estimation}</td>
					<td>${listValue.startdate}</td>
					<td>${listValue.duedate}</td>
					<td>${listValue.messgae}</td>
					<td>${listValue.status}</td>
					<td><form action="read">
							<input type="hidden" value="${listValue.id}" name="id" id="id" class="id"/>
							<input type="submit" value="Edit" class="btn btn-primary center-block">
						</form>
					</td>
					<td><form action="delete">
							<input type="hidden" value="${listValue.id}" name="id" id="id" class="id"/>
							<input type="submit" value="Delete" class="btn btn-primary center-block">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</div>
	<div class="col-sm-4" style="padding:40px;">
		<h2>Create Your TODO</h2>
		<form action="create" method="post">
			<div class="form-group">
			<label>Title</label>
			<input type="text" name="title" class="form-control">
			</div>
			<div class="form-group">
			<label>Message</label>
			<input type="text" name="message" class="form-control">
			</div>
			<div class="form-group">
			<label>Estimation</label>
			<input type="text" name="estimation" class="form-control">
			</div>
			<div class="form-group">
			<label>Status</label>
			<input type="text" name="status" class="form-control">
			</div>
			<div class="form-group">
			<label>Start Date</label>
			<input type="text" name="startdate" class="form-control">
			</div>
			<div class="form-group">
			<label>Due Date</label>
			<input type="text" name="duedate" class="form-control">
			</div>
			<div class="form-group">
			<input type="submit" value="Create" class="btn btn-primary">
			</div>
		</form>
	</div>
</body>
</html>
