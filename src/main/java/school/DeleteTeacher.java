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

@WebServlet("/DeleteT")
public class DeleteTeacher extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("user");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et  = em.getTransaction();
		
		
		String id = req.getParameter("Tid");
		
		
		int id2 = Integer.parseInt(id);
		
		Teacher t = em.find(Teacher.class, id2);
		
		if(t!=null) {
		
		
		et.begin();
		em.remove(t);
		et.commit();
		}
		
		else {
			System.out.println("data not presented");
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/Teacher.html");
		rd.forward(req, resp);
	}

}
