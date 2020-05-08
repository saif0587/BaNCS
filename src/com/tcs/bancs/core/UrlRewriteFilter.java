package com.tcs.bancs.core;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class UrlRewriteFilter
 */

public class UrlRewriteFilter implements Filter {

    

	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @return 
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here 
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		System.out.println("=== Paths ===\n");
		System.out.println("Request URL : " + req.getRequestURL());
		System.out.println("Request URI : " + req.getRequestURI());
		System.out.println("Servlet path : " + req.getServletPath());

		
		System.out.println("\n=== Headers ===\n");
		Enumeration<String> e = req.getHeaderNames();
		while(e.hasMoreElements()){
			String param = (String) e.nextElement();
			System.out.println(param + " : " + req.getHeader(param));
		}
		
		System.out.println("\n=== Parameters ===\n");
		Map<String, String[]> paramsMap = req.getParameterMap();
		for (String key : paramsMap.keySet()) {
			System.out.println(key + " : " + req.getParameter(key));
		}
		
		System.out.println("\n=== Session ===\n");
		// returns 0:0:0:0:0:0:0:1 if executed from localhost
		System.out.println("Client IP address : " + req.getRemoteAddr());
		System.out.println("Session ID : " + req.getRequestedSessionId());

		chain.doFilter(request, response);	
	}
	
	public static int nth(String requestURL, String pattern, int n) {

		   int i = 0, pos = 0, tpos = 0;

		   while (i < n) {

		      pos = requestURL.indexOf(pattern);
		      if (pos > -1) {
		         requestURL = requestURL.substring(pos+1);
		         tpos += pos+1;
		         i++;
		      } else {
		         return -1;
		      }
		   }

		   return tpos - 1;
		}
	

	

}
