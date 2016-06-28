package com.javaeetraining;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/login")
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private List<Item> initializeItems(){
    	List<Item> items = new ArrayList<Item>();
    	
		Item pen = new Item();
		pen.setName("Pen");
		pen.setDescription("Ball point pen");
		pen.setDate("06/01/2016");
		pen.setPrice(15);
		pen.setQuantity(40);
		items.add(pen);
		
		Item notebook = new Item();
		notebook.setName("Notebook");
		notebook.setDescription("80 page ruled notebook");
		notebook.setDate("06/01/2016");
		notebook.setPrice(10);
		notebook.setQuantity(20);
		items.add(notebook);
		
		
		Item bag = new Item();
		bag.setName("Bag");
		bag.setDescription("School bag");
		bag.setDate("06/01/2016");
		bag.setPrice(20);
		bag.setQuantity(10);
		items.add(bag);
		
		return items;
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().write(LocalDateTime.now().toString());
		String name = request.getParameter("user");
		String password = request.getParameter("password");
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User user = (User)session.get(User.class, 1);
		session.close();
		
		if(user!=null && user.getUsername().equals(name) && user.getPassword().equals(password)){
			Cookie usercookie = new Cookie("userid", "1");
			response.addCookie(usercookie);
//			response.getWriter().write("Welcome " + name + " !");
			
			request.setAttribute("message","Welcome, today is Monday ..");
			
			List<Item> items = initializeItems();
			request.setAttribute("data", items);
			
			RequestDispatcher homedispatch = request.getRequestDispatcher("/WEB-INF/home.jsp");
			homedispatch.forward(request, response);
		}
		else{
			response.getWriter().write("Bad Login ");
			response.getWriter().write("<a href=\"index.jsp\">Back to Login page</a>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
