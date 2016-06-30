package com.javaeetraining;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/create")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String itemname = request.getParameter("itemname");
		String itemdesc = request.getParameter("itemdescription");
		String date = request.getParameter("date");
		int price = Integer.parseInt(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		Item newitem = new Item();
		newitem.setName(itemname);
		newitem.setDate(date);
		newitem.setDescription(itemdesc);
		newitem.setPrice(price);
		newitem.setQuantity(quantity);
		
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		
		User user = session.get(User.class, Integer.parseInt(request.getParameter("userid")));
		
		newitem.setUser(user);
		session.save(newitem);
		session.getTransaction().commit();
		session.close();
		
		RequestDispatcher dispatch = request.getRequestDispatcher("/data");
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
