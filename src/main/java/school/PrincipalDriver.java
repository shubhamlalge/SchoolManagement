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
@WebServlet("/register")
public class PrincipalDriver extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("user");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et  = em.getTransaction();
		
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		int id2 = Integer.parseInt(id);
		
		
		Principal p = new Principal();
		p.setId(id2);
		p.setName(name);
		p.setEmail(email);
		p.setPassword(password);
		
		
		et.begin();
		em.persist(p);
		et.commit();
		
		System.out.println("Data inserted");
		
		RequestDispatcher rd =req.getRequestDispatcher("/login.html");
		
		rd.forward(req, resp);
	}
		 
		
		
		
		
		
	}
		
		
		
		
	


