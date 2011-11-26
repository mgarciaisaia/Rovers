package ar.com.unwebmaster.parser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ar.com.unwebmaster.executor.GridSpecification;
import ar.com.unwebmaster.executor.LocationSpecification;
import ar.com.unwebmaster.executor.RoverExecutionSpecification;
import ar.com.unwebmaster.executor.RoverSpecification;
import ar.com.unwebmaster.executor.commands.LeftSpin;
import ar.com.unwebmaster.executor.commands.MoveForward;
import ar.com.unwebmaster.executor.commands.RightSpin;
import ar.com.unwebmaster.model.orientations.NorthOrientation;
import ar.com.unwebmaster.utils.Point;

public class StringInputParserTest {

	private StringRoverExecutionParser parser;

	@Before
	public void setUp() throws Exception {
		parser = new StringRoverExecutionParser();
	}

	@Test
	public void testParseGrid() {
		GridSpecification grid = parser.parseGrid("5 5");
		Assert.assertEquals("Grid spec lowest", new Point(0, 0), grid.grid().getLowestCorner());
		Assert.assertEquals("Grid spec top", new Point(5, 5), grid.grid().getTopCorner());
	}

	@Test
	public void testParseLocation() {
		GridSpecification grid = parser.parseGrid("5 5");
		LocationSpecification locationSpecification = parser.parseLocation("1 2 N", grid);
		Assert.assertEquals("Location's orientation", new NorthOrientation(), locationSpecification.location().getOrientation());
		Assert.assertEquals("Location's coordinate", new Point(1, 2), locationSpecification.location().getPosition().coordinate());
	}

	@Test
	public void testParseRover() {
		GridSpecification grid = parser.parseGrid("5 5");
		RoverSpecification roverSpecification = parser.parseRoverSpecification("1 2 N", "LMLMLMLMM", grid);
		Assert.assertEquals("Rover's Location's orientation", new NorthOrientation(), roverSpecification.rover().getLocation().getOrientation());
		Assert.assertEquals("Rover's Location's coordinate", new Point(1, 2), roverSpecification.rover().getLocation().getPosition().coordinate());

		Assert.assertEquals("Rover's commands size", 9, roverSpecification.getCommands().size());
		Assert.assertEquals("Rover's command #1", new LeftSpin(), roverSpecification.getCommands().get(0));
		Assert.assertEquals("Rover's command #2", new MoveForward(), roverSpecification.getCommands().get(1));
		Assert.assertEquals("Rover's command #3", new LeftSpin(), roverSpecification.getCommands().get(2));
		Assert.assertEquals("Rover's command #4", new MoveForward(), roverSpecification.getCommands().get(3));
		Assert.assertEquals("Rover's command #5", new LeftSpin(), roverSpecification.getCommands().get(4));
		Assert.assertEquals("Rover's command #6", new MoveForward(), roverSpecification.getCommands().get(5));
		Assert.assertEquals("Rover's command #7", new LeftSpin(), roverSpecification.getCommands().get(6));
		Assert.assertEquals("Rover's command #8", new MoveForward(), roverSpecification.getCommands().get(7));
		Assert.assertEquals("Rover's command #9", new MoveForward(), roverSpecification.getCommands().get(8));
	}

	@Test
	public void testParser() {
		RoverExecutionSpecification executionSpecification = parser.parse("5 5\n1 2 n\nlmlmlmlmm\n3 3 e\nmmrmmrmrrm");
		Assert.assertEquals("Rovers size", 2, executionSpecification.getRoverSpecifications().size());

		RoverSpecification firstRoverSpecification = executionSpecification.getRoverSpecifications().get(0);
		Assert.assertEquals("First Rover's commands size", 9, firstRoverSpecification.getCommands().size());
		Assert.assertEquals("First Rover's command #1", new LeftSpin(), firstRoverSpecification.getCommands().get(0));
		Assert.assertEquals("First Rover's command #2", new MoveForward(), firstRoverSpecification.getCommands().get(1));
		Assert.assertEquals("First Rover's command #3", new LeftSpin(), firstRoverSpecification.getCommands().get(2));
		Assert.assertEquals("First Rover's command #4", new MoveForward(), firstRoverSpecification.getCommands().get(3));
		Assert.assertEquals("First Rover's command #5", new LeftSpin(), firstRoverSpecification.getCommands().get(4));
		Assert.assertEquals("First Rover's command #6", new MoveForward(), firstRoverSpecification.getCommands().get(5));
		Assert.assertEquals("First Rover's command #7", new LeftSpin(), firstRoverSpecification.getCommands().get(6));
		Assert.assertEquals("First Rover's command #8", new MoveForward(), firstRoverSpecification.getCommands().get(7));
		Assert.assertEquals("First Rover's command #9", new MoveForward(), firstRoverSpecification.getCommands().get(8));

		RoverSpecification secondRoverSpecification = executionSpecification.getRoverSpecifications().get(1);
		Assert.assertEquals("Second Rover's commands size", 10, secondRoverSpecification.getCommands().size());
		Assert.assertEquals("Second Rover's command #1", new MoveForward(), secondRoverSpecification.getCommands().get(0));
		Assert.assertEquals("Second Rover's command #2", new MoveForward(), secondRoverSpecification.getCommands().get(1));
		Assert.assertEquals("Second Rover's command #3", new RightSpin(), secondRoverSpecification.getCommands().get(2));
		Assert.assertEquals("Second Rover's command #4", new MoveForward(), secondRoverSpecification.getCommands().get(3));
		Assert.assertEquals("Second Rover's command #5", new MoveForward(), secondRoverSpecification.getCommands().get(4));
		Assert.assertEquals("Second Rover's command #6", new RightSpin(), secondRoverSpecification.getCommands().get(5));
		Assert.assertEquals("Second Rover's command #7", new MoveForward(), secondRoverSpecification.getCommands().get(6));
		Assert.assertEquals("Second Rover's command #8", new RightSpin(), secondRoverSpecification.getCommands().get(7));
		Assert.assertEquals("Second Rover's command #9", new RightSpin(), secondRoverSpecification.getCommands().get(8));
		Assert.assertEquals("Second Rover's command #10", new MoveForward(), secondRoverSpecification.getCommands().get(9));
	}
}