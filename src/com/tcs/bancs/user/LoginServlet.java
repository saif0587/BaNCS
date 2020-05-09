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
		
		System.out.println("Entered " + "username - " + request.getParameter("username") + " password - " + request.getParameter("password"));
		
		LoginPage.setUsername(request.getParameter("username"));
		LoginPage.setPassword(request.getParameter("password"));
		
		
		LoginPage = LoginDAO.login(LoginPage);
		
		if(LoginPage.isValid())
		{
			System.out.println("true");
			HttpSession session = request.getSession();
			session.setAttribute("firstname", LoginPage.getFirstname());
			session.setAttribute("ISAdmin", LoginPage.getISAdmin());
			session.setAttribute("username", LoginPage.getUsername());
			//setting session to expiry in 30 mins
			session.setMaxInactiveInterval(30*60);
			Cookie userName = new Cookie("firstname", LoginPage.getFirstname());
			session.setAttribute("ISAdmin", LoginPage.getISAdmin());
			session.setAttribute("username", LoginPage.getUsername());
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
