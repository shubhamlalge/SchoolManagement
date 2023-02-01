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

@WebServlet("/FetchS")
public class FetchStudent extends HttpServlet
{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("user");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et  = em.getTransaction();
		
		
		String id = req.getParameter("Sid");
		
		
		int id2 = Integer.parseInt(id);
		
		Student s = em.find(Student.class, id2);
		PrintWriter pw = resp.getWriter();
		
		System.out.println(s.getId());
		System.out.println(s.getName());
		System.out.println(s.getLoc());
		System.out.println(s.getAge());
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/Student.html");
		rd.forward(req, resp);
	}

}
