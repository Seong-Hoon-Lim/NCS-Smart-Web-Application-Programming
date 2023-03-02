package com.kudangtang.jvx330.di.example7;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("menuItemService")
public class MenuItemServiceImpl implements MenuItemService {
	
	@Autowired
	private MenuItemDao menuItemDao;

	@Override
	public void addMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		menuItemDao.save(menuItem);
	}

	@Override
	public List<MenuItem> getAllMenuItemList() {
		// TODO Auto-generated method stub
		return menuItemDao.findAll();
	}

	@Override
	public MenuItem getMenuItem(String menuName) {
		// TODO Auto-generated method stub
		return menuItemDao.findByName(menuName);
	}

}
