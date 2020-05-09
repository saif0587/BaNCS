/**
 * 
 */
package com.tcs.bancs.user;

/**
 * @author ahmad
 *
 */
public class LoginBean {

	private String username;
    private String password;
    private int ISAdmin;
    private String firstname;
    public boolean valid;
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public int getISAdmin() {
		return ISAdmin;
	}
	public void setISAdmin(int iSAdmin) {
		ISAdmin = iSAdmin;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
    

}
