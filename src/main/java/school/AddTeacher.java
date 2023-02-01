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

@WebServlet("/AddT")
public class AddTeacher extends HttpServlet
{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("user");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et  = em.getTransaction();
		
		
		String id = req.getParameter("Tid");
		String name =req.getParameter("Tname");
		String loc = req.getParameter("Tloc");
		String subject = req.getParameter("Tsubject");
		
		int id2 = Integer.parseInt(id);
		
		Teacher t =  new Teacher();
	
		t.setId(id2);
		t.setName(name);
		t.setLoc(loc);
		t.setSubject(subject);
		
		et.begin();
		em.persist(t);
		et.commit();
		
		RequestDispatcher rd = req.getRequestDispatcher("/Teacher.html");
		rd.forward(req, resp);
		
		
	}

}
