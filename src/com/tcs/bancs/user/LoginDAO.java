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
        		"SELECT * FROM (SELECT QU.USERID USERID, QU.PASSWORD PASSWORD, QU.ISADMIN ISADMIN, QU.CONNECTIONSTAT CONNECTIONSTAT, UP.FIRSTNAME FIRSTNAME, UP.LASTAME LASTAME, UP.USERSTAT USERSTAT FROM Q_USER QU JOIN USER_PROFILE UP USING (LOGINID)) WHERE USERID = '"
        				+ username
        				+ "' AND PASSWORD = '"
        				+ password
        				+ "'";
        
        System.out.println("Search Query " + searchQuery);

	    
     try 
     {
    	 connection = JNDILookup.connectionManager();
    	 statement = connection.createStatement();
        
    	 resultSet = statement.executeQuery(searchQuery);
    	 
    	 while (resultSet.next()) 
    	 {
    		 
    		 System.out.println("From DB " + "username - " + resultSet.getString("USERID") + " password - " + resultSet.getString("PASSWORD") + " connectionstat " + resultSet.getInt("CONNECTIONSTAT"));
    		 
    		 if ((username.equals(resultSet.getString("USERID"))) && (password.equals(resultSet.getString("PASSWORD"))) && resultSet.getInt("CONNECTIONSTAT") == 0) 
    		 {
    			 
    			 System.out.println("User varified. Login action initiated");
    	         bean.setValid(true);
    	         bean.setISAdmin(resultSet.getInt("ISADMIN"));
    	         bean.setFirstname(resultSet.getString("FIRSTNAME"));	 
    		 }
    		 else
    		 {
    			   System.out.println("Sorry, you are not a registered user! Please sign up first");
    	           bean.setValid(false);
    		 }

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
