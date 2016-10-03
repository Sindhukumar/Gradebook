<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<form action="Update" method="post"	onsubmit="return verifyPassword()">
		
			&nbsp;&nbsp;&nbsp;&nbsp;Candidate: &nbsp; <input id="username"
				name="username" type="text" value="${sessionScope.grade.user.username}"
				disabled /><br> <br> <br> 
			&nbsp;&nbsp;&nbsp;Email:&nbsp; <input id="useremail" name="useremail" type="text"
				value="${sessionScope.grade.user.useremail}" disabled /><br> <br>
			
			<input id="gradebookid"
				name="gradebookid" type="hidden" value="${sessionScope.grade.gradebookid}"   />
				<br> 
				&nbsp;&nbsp;&nbsp;&nbsp;Subject: &nbsp; <input id="subject"
				name="subject" type="text" value="${sessionScope.grade.subject}"  /><br>
			<br> &nbsp;&nbsp;&nbsp;&nbsp;Assignment: &nbsp; <input id="assignment"
				name="assignment" type="text" value="${sessionScope.grade.assignment}"  /><br>
			<br>
			<br> &nbsp;&nbsp;&nbsp;&nbsp;AssignmentType: &nbsp; <input id="assignmenttype"
				name="assignmenttype" type="text" value="${sessionScope.grade.assignmenttype}"  /><br>
			<br>
			<br> &nbsp;&nbsp;&nbsp;&nbsp;Grade: &nbsp; <input id="grade"
				name="grade" type="text" value="${sessionScope.grade.grade}"  /><br>
			<br>
			<button id="update" type="submit" value="Submit">
				<font color="blue">Update</font>
			</button>
		</form>

	</center>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>