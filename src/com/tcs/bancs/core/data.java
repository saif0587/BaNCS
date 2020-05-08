/**
 * 
 */
package com.tcs.bancs.core;

/**
 * @author ahmad
 *
 */
public class data {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String contextroot = "/Bancs";
		String toReplace = null;
		String newURI = null;
		int positionIndex;
		int lastIndex;
		String URL = "http://localhost:8080/Bancs/UserGui/hjjhijij/LoginServlet";
		//String URL = "http://localhost:8080/Bancs/UserGui/dfsdfdsdf/login.html";
		

		
		
		if(!URL.contains(".html"))
		{
		positionIndex = nth(URL,"/",4);
		lastIndex = URL.lastIndexOf("/");
		String data = URL.substring(0, positionIndex) + URL.substring(lastIndex, URL.length());
		System.out.println("Start " + positionIndex);
		System.out.println("End " + lastIndex);
		System.out.println("SubString " + URL.substring(positionIndex, lastIndex));
		System.out.println("URL " + data);
		}
		else
		{
			System.out.println(URL);
		}
		
		
		

	}
	
	public static int nth(String source, String pattern, int n) {

		   int i = 0, pos = 0, tpos = 0;

		   while (i < n) {

		      pos = source.indexOf(pattern);
		      if (pos > -1) {
		         source = source.substring(pos+1);
		         tpos += pos+1;
		         i++;
		      } else {
		         return -1;
		      }
		   }

		   return tpos - 1;
		}
}
