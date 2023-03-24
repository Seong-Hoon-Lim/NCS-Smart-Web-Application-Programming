package com.kudangtang.ncs.order;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CartTest {
	static Cart cart = new Cart();
	
	@Test
	public void addCartTest() {
		cart.addCart(new MenuItem("아메리카노", 3000), 1);
		cart.addCart(new MenuItem("카페라떼", 4000), 1);
		assertEquals(2, cart.savedItemSize());
	}
	
	@Test
	public void addCartTest2() {
		cart.addCart(new MenuItem("아메리카노", 3000), 1);
		cart.addCart(new MenuItem("아메리카노", 3000), 1);
		assertEquals(1, cart.savedItemSize());
	}
	
	@Test
	public void addCartTest3() {
		cart.addCart(new MenuItem("아메리카노", 3000), 1);
		cart.addCart(new MenuItem("아메리카노", 3000), 1);
		cart.addCart(new MenuItem("카페라떼", 4000), 1);
		assertEquals(2, cart.savedItemSize());
	}
	
}
