package io.s3soft.proxyapp.util;

import java.util.ArrayList;

import io.s3soft.proxyapp.model.NavLink;

public class NavbarUtil {

	public static ArrayList<NavLink>  getAdminLinks(){
		ArrayList<NavLink> al=new ArrayList<>();
		al.add(new NavLink("Home", "/#/home"));
		al.add(new NavLink("Offers", "/#/products"));
		al.add(new NavLink("My Cart", "/#/MyCart"));
		al.add(new NavLink("Users", "/#/MyCart"));
		al.add(new NavLink("Products", "/#/MyCart"));
		al.add(new NavLink("Logout", "/logout"));
		return al;
	}
	public static ArrayList<NavLink> getUserLinks(){
		ArrayList<NavLink> al=new ArrayList<>();
		al.add(new NavLink("Home", "/#/home"));
		al.add(new NavLink("Offers", "/#/products"));
		al.add(new NavLink("My Cart", "/#/MyCart"));
		al.add(new NavLink("Logout", "/logout"));
	    al.add(new NavLink("Users Data","/#/user-data"));
		return al;
	}
	
}
