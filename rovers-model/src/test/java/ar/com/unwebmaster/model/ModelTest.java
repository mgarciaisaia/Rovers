package ar.com.unwebmaster.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ar.com.unwebmaster.model.orientations.EastOrientation;
import ar.com.unwebmaster.model.orientations.NorthOrientation;
import ar.com.unwebmaster.utils.Point;

public class ModelTest {

	private Grid plateau;
	private Rover firstRover;
	private Rover secondRover;

	@Before
	public void setUp() throws Exception {
		plateau = new Grid(new Point(0, 0), new Point(5, 5));
		firstRover = new Rover(new Location(new Position(new Point(1, 2), plateau), new NorthOrientation()));
		secondRover = new Rover(new Location(new Position(new Point(3, 3), plateau), new EastOrientation()));
	}

	@Test
	public void testComplete() {
		firstRover.spinLeft();
		firstRover.moveForward();
		firstRover.spinLeft();
		firstRover.moveForward();
		firstRover.spinLeft();
		firstRover.moveForward();
		firstRover.spinLeft();
		firstRover.moveForward();
		firstRover.moveForward();
		Assert.assertEquals("First rover's orientation failed", new NorthOrientation(), firstRover.getLocation().getOrientation());
		Assert.assertEquals("First rover's coordinate failed", new Point(1, 3), firstRover.getLocation().getPosition().coordinate());

		secondRover.moveForward();
		secondRover.moveForward();
		secondRover.spinRight();
		secondRover.moveForward();
		secondRover.moveForward();
		secondRover.spinRight();
		secondRover.moveForward();
		secondRover.spinRight();
		secondRover.spinRight();
		secondRover.moveForward();
		Assert.assertEquals("Second rover's orientation failed", new EastOrientation(), secondRover.getLocation().getOrientation());
		Assert.assertEquals("Second rover's coordinate failed", new Point(5, 1), secondRover.getLocation().getPosition().coordinate());
	}
}