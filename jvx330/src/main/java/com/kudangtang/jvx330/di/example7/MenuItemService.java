package com.kudangtang.jvx330.di.example7;

import java.util.List;

public interface MenuItemService {
	/**
	 * 메뉴를 추가 기능
	 * @param menuItem
	 */
	void addMenuItem(MenuItem menuItem);
	/**
	 * 모든 메뉴 목록 조회 기능
	 * @return
	 */
	List<MenuItem> getAllMenuItemList();
	/**
	 * 메뉴 이름으로 조회하는 기능
	 * @param menuName
	 * @return
	 */
	MenuItem getMenuItem(String menuName);
}
