package com.github.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
	
	private StringCalculator calc = new StringCalculator();
	
	@Test
	public void testEmptyString() {
		assertEquals(0, calc.add(""));
	}
	
	@Test
	public void testSingleNumber() {
		assertEquals(1, calc.add("1"));
	}
	
	@Test
	public void testTwoNumber() {
		assertEquals(3, calc.add("1,2"));
	}
	
}
