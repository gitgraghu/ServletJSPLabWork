package com.javaeetraining;

import java.io.IOException;
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

/**
 * Servlet implementation class DataServlet
 */
@WebServlet("/data")
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataServlet() {
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
		// TODO Auto-generated method stub
		int userid = 0;
		for(Cookie cookie: request.getCookies()){
			if(cookie.getName().equals("userid")){
				userid = Integer.parseInt(cookie.getValue());
			}
		}
		
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		User user = (User)session.get(User.class, userid);
		List<Item> items = initializeItems(user);
		request.setAttribute("data", items);
		session.close();
		
		RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/data.jsp");
		dispatch.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
