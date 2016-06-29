package com.javaeetraining;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
import org.hibernate.query.Query;
import org.hibernate.type.descriptor.java.LocalDateTimeJavaDescriptor;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/login-post")
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
    private List<Item> initializeItems(User user){
    	
		List<Item> items = new ArrayList<>();

    	Set<Item> useritems = user.getItems();
    	for(Item item: useritems){
    		items.add(item);
    	}
    
		return items;
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("user");
		String password = request.getParameter("password");
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from User as user where user.username = :name").setString("name", name);
		List<User> userlist = query.list();
		
		if(!userlist.isEmpty() && userlist.get(0).getUsername().equals(name) && userlist.get(0).getPassword().equals(password)){
			Cookie usercookie = new Cookie("userid", Integer.toString(userlist.get(0).getUserid()));
			response.addCookie(usercookie);

			request.setAttribute("message","Welcome, today is " + LocalDateTime.now().getDayOfWeek().name() + " !");
//			
//			List<Item> items = initializeItems(userlist.get(0));
			session.close();
//			request.setAttribute("data", items);
			
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
