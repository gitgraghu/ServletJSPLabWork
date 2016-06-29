package com.javaeetraining;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

	private int userid;
	private String username;
	private String password;
	
	private Set<Item> items =  new HashSet<Item>();
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
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
	
	public Set<Item> getItems(){
		return items;
	}
	
	public void setItems(Set<Item> itemlist){
		items = itemlist;
	}

}

