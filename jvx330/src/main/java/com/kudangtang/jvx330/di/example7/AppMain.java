package com.kudangtang.jvx330.di.example7;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class AppMain {
	public static void main(String[] args) {
		
		GenericApplicationContext context = 
					new AnnotationConfigApplicationContext(AppConfig.class);
		
		MenuItemService menuService = context.getBean("menuItemService", MenuItemService.class);
		
		System.out.println("�޴� �߰�");
		menuService.addMenuItem(new MenuItem("�Ƹ޸�ī��", 2500.0));
		menuService.addMenuItem(new MenuItem("ī���", 3000.0));
		menuService.addMenuItem(new MenuItem("ī���ī", 3500.0));
		
		System.out.println("\n�޴� ���");
		for (MenuItem item : menuService.getAllMenuItemList()) {
			System.out.println(item);
		}
		
		System.out.println("\n�޴� �˻�");
		MenuItem menuItem = menuService.getMenuItem("�Ƹ޸�ī��");
		System.out.println("menuItem " + menuItem);
		
		context.close();
	}

}
