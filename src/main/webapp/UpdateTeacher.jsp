<%@page import="school.Teacher"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UpdateTeacher</title>
</head>
<body>

<%
	String id = request.getParameter("id");
	int id1 = Integer.parseInt(id);
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("user");
	EntityManager em = emf.createEntityManager();
	Teacher t = em.find(Teacher.class, id1);
	%>

	<form action="update" method="post">
		id: <input type="text" value="<%=t.getId()%>" name="id">
		name: <input type="text" value="<%=t.getName()%>" name="name">
		Location: <input type="text" value="<%= t.getLoc() %>" name="location">
		subject: <input type="text" value="<%=t.getSubject()%>"name="subject">
		<input type="submit">
	</form>

		

</body>
</html>