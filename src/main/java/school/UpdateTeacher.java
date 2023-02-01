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

@WebServlet("/update")
public class UpdateTeacher extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("user");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et  = em.getTransaction();
		
		
		String id = req.getParameter("id");
		String name =req.getParameter("name");
		String loc = req.getParameter("location");
		String subject = req.getParameter("subject");
		
		int id2 = Integer.parseInt(id);
		
		Teacher t = new Teacher();
		
		t.setId(id2);
		t.setName(name);
		t.setLoc(loc);
		t.setSubject(subject);
		
		et.begin();
		em.merge(t);
		et.commit();
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter() ;
		pw.write("updated successfully");
		
		RequestDispatcher rd = req.getRequestDispatcher("/Teacher.html");
		rd.forward(req, resp);
	}

}
