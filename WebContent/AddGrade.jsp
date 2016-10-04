<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="Tool.DbUser"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Gradebook</title>
</head>
<body>

	<jsp:include page="bootstrap.jsp"></jsp:include>
	<jsp:include page="navbar.jsp"></jsp:include>
	<center>
		<form action="AddGrade" method="post">

			&nbsp;&nbsp;&nbsp;&nbsp;Candidate ID: &nbsp; <input id="userid"
				name="userid" type="text" value="" /><br> <br> <br>
			<%
				if ("false".equalsIgnoreCase(request.getParameter("isvaliduserid"))) {
			%>
			<script>alert("Candidate does not exist");</script>
			<%
				}
			%>
			&nbsp;&nbsp;&nbsp;&nbsp;Subject: &nbsp; <input id="subject"
				name="subject" type="text" value="" /><br> <br>
			&nbsp;&nbsp;&nbsp;&nbsp;Assignment: &nbsp; <input id="assignment"
				name="assignment" type="text" value="" /><br> <br> <br>
			&nbsp;&nbsp;&nbsp;&nbsp;AssignmentType: &nbsp; <input
				id="assignmenttype" name="assignmenttype" type="text" value="" /><br>
			<br> <br> &nbsp;&nbsp;&nbsp;&nbsp;Grade: &nbsp; <input
				id="grade" name="grade" type="text" value="" /><br> <br>

			<button id="update" type="submit" value="Submit">
				<font color="blue">Add</font>
			</button>
		</form>

	</center>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>