package school;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginValidation extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("user");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et  = em.getTransaction();
		
		String email= req.getParameter("email");
		String password = req.getParameter("password");
		
		Query q = em.createQuery("select u from Principal u where u.email=?1 and u.password=?2");
		 q.setParameter(1, email);
		q.setParameter(2, password);
		
		List<Principal> login = q.getResultList();
		
		PrintWriter pw = resp.getWriter();
		
		if(login.size()>0) {
			
			RequestDispatcher rd = req.getRequestDispatcher("/TeacherStudent.html");
			rd.forward(req, resp);
		}
		else {
			pw.write("Login details invalide");
		}
		
	}

}
