package io.s3soft.proxyapp.model;

public class NavLink {
	
	private String linkName;
	private String urlPattern;
	public String getLinkName() {
		return linkName;
	}
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	public String getUrlPattern() {
		return urlPattern;
	}
	public void setUrlPattern(String urlPattern) {
		this.urlPattern = urlPattern;
	}
	public NavLink(String linkName, String urlPattern) {
		super();
		this.linkName = linkName;
		this.urlPattern = urlPattern;
	}
	public NavLink() {
		super();
	}
	@Override
	public String toString() {
		return "NavLink [linkName=" + linkName + ", urlPattern=" + urlPattern + "]";
	}
}
