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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().write(LocalDateTime.now().toString());
		String name = request.getParameter("user");
		String password = request.getParameter("password");
		if("admin".equals(name) && "password".equals(password)){
			Cookie usercookie = new Cookie("userid", "1");
			response.addCookie(usercookie);
//			response.getWriter().write("Welcome " + name + " !");
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
