package ar.com.unwebmaster.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

public class PointTest {
	@Test
	public void testAdd() {
		Point point = new Point(12, -15);
		Point samePoint = point.add(new Point(0, 0));
		assertEquals("Adding origin point failed", point, samePoint);
		
		Point firstQuadrant = new Point(2, 4);
		Point firstAdd = point.add(firstQuadrant);
		assertEquals("Adding first quadrant point failed", new Point(12 + 2, -15 + 4), firstAdd);
		
		Point secondQuadrant = new Point(-2, 4);
		Point secondAdd = point.add(secondQuadrant);
		assertEquals("Adding second quadrant point failed", new Point(12 - 2, -15 + 4), secondAdd);
		
		Point thirdQuadrant = new Point(-2, -4);
		Point thirdAdd = point.add(thirdQuadrant);
		assertEquals("Adding third quadrant point failed", new Point(12 - 2, -15 - 4), thirdAdd);
		
		Point fourthQuadrant = new Point(2, -4);
		Point fourthAdd = point.add(fourthQuadrant);
		assertEquals("Adding fourth quadrant point failed", new Point(12 + 2, -15 - 4), fourthAdd);
	}

	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}
}