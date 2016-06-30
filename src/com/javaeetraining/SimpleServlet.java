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
@WebServlet("/home")
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
		session.close();
		
		if(!userlist.isEmpty() && userlist.get(0).getUsername().equals(name) && userlist.get(0).getPassword().equals(password)){
	
			request.setAttribute("message","Welcome, today is " + LocalDateTime.now().getDayOfWeek().name() + " !");
			Cookie usercookie = new Cookie("userid", Integer.toString(userlist.get(0).getUserid()));
			response.addCookie(usercookie);
			Cookie usernamecookie = new Cookie("username", userlist.get(0).getUsername());
			response.addCookie(usernamecookie);
			request.getSession().setAttribute("userid", Integer.toString(userlist.get(0).getUserid()));
			request.getSession().setAttribute("username", userlist.get(0).getUsername());
			
			RequestDispatcher homedispatch = request.getRequestDispatcher("/WEB-INF/home.jsp");
			homedispatch.forward(request, response);
		}
		else{
			RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/badlogin.jsp");
			dispatch.forward(request, response);
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
