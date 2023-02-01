package school;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FetchT")
public class FetchTeacher extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("user");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et  = em.getTransaction();
		
		
		String id = req.getParameter("id");
		
		
		int id2 = Integer.parseInt(id);
		
		Teacher t = em.find(Teacher.class, id2);
		PrintWriter pw = resp.getWriter();
		
		System.out.println(t.getId());
		System.out.println(t.getName());
		System.out.println(t.getLoc());
		System.out.println(t.getSubject());
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/Teacher.html");
		rd.forward(req, resp);
	}
	

}
