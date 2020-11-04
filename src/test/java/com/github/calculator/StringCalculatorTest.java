package com.github.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
	
	private StringCalculator calc = new StringCalculator();
	
	@Test
	public void testEmptyStringTest() throws Exception {
		assertEquals(0, calc.add(""));
	}
	
	@Test
	public void testSingleNumberTest() throws Exception {
		assertEquals(1, calc.add("1"));
	}
	
	@Test
	public void testTwoNumberTest() throws Exception {	
		assertEquals(3, calc.add("1,2"));
	}
	
	@Test
	public void testTwoNumberWithNewLineTest() throws Exception {
		assertEquals(6, calc.add("1\n2,3"));
	}
	
	@Test
	public void defaultDelimiterTest() throws Exception {
		assertEquals(6, calc.add("//;\n2;3\n1"));
	}
	
	@Test
	public void negativeExceptionTest() throws Exception {
		Exception exception = assertThrows(Exception.class, () -> calc.add("1,2,-3"));
		assertEquals(exception.getMessage(), "negatives not allowed [-3]");
	}
	
	@Test
	public void ignoreMoreThan1000Test() throws Exception {
		assertEquals(6, calc.add("2,3,1001,1,5306"));
	}
	
	
}
