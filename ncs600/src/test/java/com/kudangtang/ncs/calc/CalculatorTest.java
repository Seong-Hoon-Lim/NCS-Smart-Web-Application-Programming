package com.kudangtang.ncs.calc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {

	static Calculator calc = null;
	
	@BeforeAll
	public static void init() {
		calc = new Calculator();
		calc.setResult(10);
	}
	
	@BeforeEach
	public void setup() {
		calc = new Calculator();
		calc.setResult(10);
	}
	
	@AfterEach
	public void clear() {
		calc.clear();
	}
	
	@Test
	@Order(1)
	void testAdd() {
		System.out.println("calc.getResult()=" + calc.getResult());
		calc.add(5);
		assertEquals(15, calc.getResult());
	}

	@Test
	@Order(2)
	void testSubtract() {
		System.out.println("calc.getResult()=" + calc.getResult());
		calc.subtract(8);
		assertEquals(2, calc.getResult());
	}

	@Test
	@Order(3)
	void testMultiply() {
		calc.multiply(3);
		assertEquals(30, calc.getResult());
	}

	@Test
	@Order(4)
	void testDivision() {
		calc.subtract(4);
		assertEquals(2, calc.getResult());
	}

}
