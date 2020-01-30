package net.samitkumar.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathUtilsTest {

	@Test
	void testAdd() {
		MathUtils m = new MathUtils();
		int val = m.add(10, 1);
		assertEquals(11, val,"Should be 11");
	}
	
	
	@Test
	void testComputeRadius() {
		MathUtils mathUtils = new MathUtils();
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10),"Should return right circle area");
	}
}
