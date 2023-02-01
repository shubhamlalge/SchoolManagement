<%@page import="school.Student"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String id = request.getParameter("id");
	int id1 = Integer.parseInt(id);
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("user");
	EntityManager em = emf.createEntityManager();
	Student t = em.find(Student.class, id1);
	%>

	<form action="updateS" method="post">
		id: <input type="text" value="<%=t.getId()%>" name="id">
		name: <input type="text" value="<%=t.getName()%>" name="name">
		Location: <input type="text" value="<%= t.getLoc() %>" name="location">
		Age: <input type="text" value="<%= t.getAge()%>"name="subject">
		<input type="submit">
	</form>

		

</body>
</html>