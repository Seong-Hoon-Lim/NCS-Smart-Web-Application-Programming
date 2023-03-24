package com.kudangtang.ncs.order;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	public List<LineItem> itemList;
	
	public Cart() {
		itemList = new ArrayList<>();
	}
	
	
	/**
	 * 주문한 메뉴아이템과 수량을 카트에 추가
	 * 동일 메뉴에 대해서는 수량만 증가시킨다.
	 * 
	 * @param item
	 * @param quantity
	 */
	public void addCart(MenuItem item, int quantity) {
		boolean duplicated = false;
		for(LineItem li : itemList) {
			if (item.getName().equals(li.getMenuItem().getName())) {
				li.setQuantity(li.getQuantity() + quantity);
				duplicated = true;
				break;
			}
		}
			if(!duplicated) {
				itemList.add(new LineItem(item, quantity));
		}
			
	}
		
	
	/**
	 * 주문한 메뉴 종류에 대한 갯수를 리턴한다.
	 * @return
	 */
	public int savedItemSize() {
		return itemList.size();
	}
	
	public int totalPrice() {
		int total = 0;
		for(LineItem li : itemList) {
			total += li.getMenuItem().getPrice() * li.getQuantity();
		}
		return total;
	}
	
	/**
	 * 카트내역 초기화
	 */
	public void clear() {
		itemList.clear();
	}
	
	/**
	 * 주문한 메뉴들의 정보들을 수량과 함께 문자열로 리턴
	 * @return
	 */
	public String toString() {
		StringBuilder result = new StringBuilder();
		for(LineItem li : itemList) {
			result.append(li.getMenuItem().getName());
			result.append(", ");
			result.append(li.getQuantity());
			result.append("\n");
		}
		return result.toString();
	}
}
