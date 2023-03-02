package com.kudangtang.jvx330.di.example7;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Component;

@Component("menuItemDao")
public class MenuItemDao {
	private static List<MenuItem> MENU = new ArrayList<>();
	
	public void save(MenuItem item) {
		// TODO Auto-generated method stub
		if (MENU.contains(item)) {
			MENU.add(item);
		}		
	}

	public List<MenuItem> findAll() {
		// TODO Auto-generated method stub
		return MENU;
	}

	public MenuItem findByName(String name) {
		// TODO Auto-generated method stub
		for (MenuItem item : MENU) {
			if (item.getName().equals(name)) {
				return item;
			}					
		}
		throw new RuntimeErrorException(null, name + "메뉴가 없다.");
		
	}
	

}
