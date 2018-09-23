package regex;


import ee.nortal.testassignment.Solution;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class SolutionTest {

	@Test
	public void testCalculation1() throws Exception {
		assertEquals(13, Solution.calculate("6 + 7"));
	}

	@Test
	public void testCalculation2() throws Exception {
		assertEquals(5, Solution.calculate("24 + 26 - 45"));
	}

	@Test
	public void testCalculation3() throws Exception {
		assertEquals(4, Solution.calculate("24 - 10 * 2"));
	}

	@Test
	public void testCalculation4() throws Exception {
		assertEquals(28, Solution.calculate("(24 - 10) * 2"));
	}

	@Test
	public void testCalculation5() throws Exception {
		assertEquals(19, Solution.calculate("24 - 10 / 2"));
	}

	@Test
	public void testCalculation6() throws Exception {
		assertEquals(-16, Solution.calculate("24 - 10 * 2 ^ 2"));
	}

	@Test
	public void testCalculation7() throws Exception {
		assertEquals(784, Solution.calculate("((24 - 10) * 2) ^ 2"));
	}

	@Test
	public void testCalculation8() throws Exception {
		assertThrows(Exception.class, () -> Solution.calculate("15 / (11 * 2 - 7 - 3 * 5)"));
	}

}
