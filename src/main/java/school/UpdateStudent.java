package school;

import java.io.IOException;

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

@WebServlet("/UpdateS")
public class UpdateStudent extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("user");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et  = em.getTransaction();
		
		
		String id = req.getParameter("Sid");
		String name =req.getParameter("Sname");
		String loc = req.getParameter("Sloc");
		String age  = req.getParameter("Sage");
		
		int id2 = Integer.parseInt(id);
		
		Student s = new Student();
		
		s.setId(id2);
		s.setName(name);
		s.setLoc(loc);
		s.setAge(age);
		
		et.begin();
		em.merge(s);
		et.commit();
		
		RequestDispatcher rd = req.getRequestDispatcher("/Student.html");
		rd.forward(req, resp);
	}

}
