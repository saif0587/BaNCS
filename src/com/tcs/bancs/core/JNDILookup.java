/**
 * 
 */
package com.tcs.bancs.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * @author ahmad
 *
 */
public class JNDILookup {

		   static Context context = null;
		   static Connection connection = null;
		   
		   
		   public static Connection connectionManager()
		   {
			   Hashtable<String, String> hashtable = null;
			   
			   try {
				   System.out.println("Propertes Path " + System.getProperty("bancs.bootstrap.properties.path") + "\\Bootstrap\\bootstrap.properties");
				hashtable = hashTable.dataCaching(System.getProperty("bancs.bootstrap.properties.path") + "\\Bootstrap\\bootstrap.properties");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			   
			   try {

				   
				    System.out.println("Try Block");
				   	context = new InitialContext(hashtable);
				   	System.out.println("context initialised " + context.toString());
				   	
				    DataSource datasource = (DataSource)  context.lookup(hashtable.get("DataSourceName"));
				    System.out.println("datasource lookup done " + datasource.toString());
				    

				    
				    
				    connection = datasource.getConnection();
				    System.out.println("Connection Check " + connection.toString());
				     
				     
				   }
				   
				                  catch (NamingException e) {
				     e.printStackTrace();
				   }
				 
				                  catch (SQLException e) {
				 e.printStackTrace();
				   }
				 
				   
				
			   
			return connection;
			   
		   }

}
