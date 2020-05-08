/**
 * 
 */
package com.tcs.bancs.core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

/**
 * @author ahmad
 *
 */
public class hashTable {
	
	
	public static Hashtable dataCaching(String filePath) throws IOException {
		// TODO Auto-generated method stub
		

		try {
			
			Hashtable<String, String> hashtable = new Hashtable<String, String>();
			FileReader file = new FileReader(filePath);
			BufferedReader reader = new BufferedReader(file);
			String data;
			while ((data = reader.readLine()) != null) {
				if(data.length() > 0 && data.contains("=")) 
				{
		        String[] lineFeed = data.split("=");
		        hashtable.put(lineFeed[0], lineFeed[1]);
				}
				
			}
			reader.close();
			return hashtable;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

		

	}
	
}
