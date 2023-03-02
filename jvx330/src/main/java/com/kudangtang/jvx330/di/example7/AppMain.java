package com.kudangtang.jvx330.di.example7;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class AppMain {
	public static void main(String[] args) {
		
		GenericApplicationContext context = 
					new AnnotationConfigApplicationContext(AppConfig.class);
		
		MenuItemService menuService = context.getBean("menuItemService", MenuItemService.class);
		
		System.out.println("메뉴 추가");
		menuService.addMenuItem(new MenuItem("아메리카노", 2500.0));
		menuService.addMenuItem(new MenuItem("카페라떼", 3000.0));
		menuService.addMenuItem(new MenuItem("카페모카", 3500.0));
		
		System.out.println("\n메뉴 목록");
		for (MenuItem item : menuService.getAllMenuItemList()) {
			System.out.println(item);
		}
		
		System.out.println("\n메뉴 검색");
		MenuItem menuItem = menuService.getMenuItem("아메리카노");
		System.out.println("menuItem " + menuItem);
		
		context.close();
	}

}
