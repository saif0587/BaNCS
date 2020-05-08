/**
 * 
 */
package com.tcs.bancs.user;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.tcs.bancs.core.JNDILookup;

/**
 * @author ahmad
 *
 */
public class LoginDAO {
	
	static Connection connection = null;
    static ResultSet resultSet = null; 
    
    
    public static LoginBean login(LoginBean bean) {
    	
        //preparing some objects for connection 
        Statement statement = null;    
	
        String username = bean.getUsername();    
        String password = bean.getPassword();   
	    
        String searchQuery =
              "select * from users where username='"
                       + username
                       + "' AND password='"
                       + password
                       + "'";

	    
     try 
     {
    	 connection = JNDILookup.connectionManager();
    	 statement = connection.createStatement();
        
    	 resultSet = statement.executeQuery(searchQuery);	        
         boolean more = resultSet.next();
	       
        // if user does not exist set the isValid variable to false
        if (!more) 
        {
           System.out.println("Sorry, you are not a registered user! Please sign up first");
           bean.setValid(false);
        } 
	        
        //if user exists set the isValid variable to true
        else if (more) 
        {
           bean.setValid(true);
        }
     } 

     catch (Exception ex) 
     {
        System.out.println("Log In failed: An Exception has occurred! " + ex);
     } 
	    
     //some exception handling
     finally 
     {
        if (resultSet != null)	{
           try {
        	   resultSet.close();
           } catch (Exception e) {}
           resultSet = null;
           }
	
        if (statement != null) {
           try {
        	   statement.close();
           } catch (Exception e) {}
           statement = null;
           }
	
        if (connection != null) {
           try {
        	   connection.close();
           } catch (Exception e) {
           }

           connection = null;
        }
     }

return bean;
	
     }

}
