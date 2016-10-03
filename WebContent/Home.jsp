<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
</head>
<body>
	<jsp:include page="bootstrap.jsp"></jsp:include>
	<jsp:include page="navbar.jsp"></jsp:include>

	<div class="container">

		<table class="table table-bordered table-striped table-hover"
			id="myTable">
			<thead>
				<tr>
					<th>Name</th>
					<th>Subject</th>
					<th>Assignment</th>
					<th>Assignment Type</th>
					<th>Grade</th>
				</tr>
			</thead>
			<tbody>
				<%
					User user = (User) session.getAttribute("user");
					if ("teacher".equalsIgnoreCase(user.getUserrole())) {
				%>
				<c:forEach var="grade" items="${Allgrades}">
					<tr>
						<td><img alt="${grade.user.useremail}"
							src="${gravatarURLsmall.getGravatarURL(grade.user.useremail, 25)}" /><a
							href="ProfileServlet?action=viewprofile&userid=<c:out value="${grade.user.userid}"/>"><c:out
									value="${grade.user.useremail}" /></a></td>
						<td><c:out value="${grade.subject}" /></td>
						<td><c:out value="${grade.assignment}" /></td>
						<td><c:out value="${grade.assignmenttype}" /></td>
						<td><c:out value="${grade.grade}" /></td>
						<td><a
							href="Update?gradebookid=<c:out value="${grade.gradebookid}"/>"><button>Update</button></a></td>
					</tr>
				</c:forEach>
				<%
					} else {
				%>
				<c:forEach var="grade" items="${grades}">
					<tr>
						<td><img alt="${grade.user.useremail}"
							src="${gravatarURLsmall.getGravatarURL(grade.user.useremail, 25)}" /><a
							href="ProfileServlet?action=viewprofile&userid=<c:out value="${grade.user.userid}"/>"><c:out
									value="${grade.user.useremail}" /></a></td>
						<td><c:out value="${grade.subject}" /></td>
						<td><c:out value="${grade.assignment}" /></td>
						<td><c:out value="${grade.assignmenttype}" /></td>
						<td><c:out value="${grade.grade}" /></td>
					</tr>
				</c:forEach>

				<%
					}
				%>
			</tbody>
		</table>

	</div>


	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>