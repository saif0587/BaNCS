package com.tcs.bancs.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("SAIF AHMAD");
		LoginBean LoginPage = new LoginBean();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//LoginPage = LoginDAO.login(LoginPage);
		System.out.println("username - " + username + " password - " + password);
		if(username.equals("admin") && password.equals("admin"))
		{
			System.out.println("true");
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			//setting session to expiry in 30 mins
			session.setMaxInactiveInterval(30*60);
			Cookie userName = new Cookie("username", username);
			userName.setMaxAge(30*60);
			response.addCookie(userName);
			
			response.sendRedirect("home.jsp");
			return;
		}
		else
		{	
			System.out.println("false");
			response.sendRedirect("index.jsp");
			return;
		}
		
	}

}
