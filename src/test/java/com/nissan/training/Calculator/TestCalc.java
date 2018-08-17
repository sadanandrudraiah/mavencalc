package com.nissan.training.Calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCalc {

	@Test
	public void testadd() {
		Calc c=new Calc();
		assertEquals(4,c.add(2,2));
	}
	@Test
	public void testsub() {
		Calc c=new Calc();
		assertEquals(5,c.sub(8,3));
	}

}
