package io.s3soft.proxyapp.model;

import java.util.List;

public class NavBar {

	private User user;
	
	private List<NavLink> navLinks;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<NavLink> getNavLinks() {
		return navLinks;
	}

	public void setNavLinks(List<NavLink> navLinks) {
		this.navLinks = navLinks;
	}

	public NavBar(User user, List<NavLink> navLinks) {
		super();
		this.user = user;
		this.navLinks = navLinks;
	}

	public NavBar() {
		super();
	}

	@Override
	public String toString() {
		return "NavBar [user=" + user + "]";
	}
	
	
}
