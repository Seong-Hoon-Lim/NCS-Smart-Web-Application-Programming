package com.kudangtang.jvx330.di.example7;

import java.util.List;

public interface MenuItemService {
	/**
	 * �޴��� �߰� ���
	 * @param menuItem
	 */
	void addMenuItem(MenuItem menuItem);
	/**
	 * ��� �޴� ��� ��ȸ ���
	 * @return
	 */
	List<MenuItem> getAllMenuItemList();
	/**
	 * �޴� �̸����� ��ȸ�ϴ� ���
	 * @param menuName
	 * @return
	 */
	MenuItem getMenuItem(String menuName);
}
