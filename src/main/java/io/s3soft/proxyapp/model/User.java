package io.s3soft.proxyapp.model;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @author shaiksha
 *
 */

public class User implements Serializable,Comparable<User>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 73L;

	private int userId;
	
    private boolean enabled;
	

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private List<String> roles;
	private Date accountCreated;
	private Date modifiedDate;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public Date getAccountCreated() {
		return accountCreated;
	}
	public void setAccountCreated(Date accountCreated) {
		this.accountCreated = accountCreated;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", enabled=" + enabled + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", password=" + password + ", roles=" + roles + ", accountCreated="
				+ accountCreated + ", modifiedDate=" + modifiedDate + "]";
	}
	public User() {
		super();
	}
	public User(int userId, boolean enabled, String firstName, String lastName, String email, String password,
			List<String> roles, Date accountCreated, Date modifiedDate) {
		super();
		this.userId = userId;
		this.enabled = enabled;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.accountCreated = accountCreated;
		this.modifiedDate = modifiedDate;
	}
	@Override
	public int compareTo(User user) {
		// TODO Auto-generated method stub
		return this.getFirstName().compareTo(user.getFirstName());
	}
	
}
