package ar.com.unwebmaster.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import ar.com.unwebmaster.executor.RoverCommand;
import ar.com.unwebmaster.executor.RoverExecutionSpecification;
import ar.com.unwebmaster.executor.RoverSpecification;
import ar.com.unwebmaster.factory.OrientationFactory;
import ar.com.unwebmaster.factory.RoverCommandFactory;
import ar.com.unwebmaster.model.Grid;
import ar.com.unwebmaster.model.Location;
import ar.com.unwebmaster.model.Position;
import ar.com.unwebmaster.model.Rover;
import ar.com.unwebmaster.utils.Point;

// FIXME: get a name :)
public class StringRoverExecutionParser {
	private OrientationFactory orientationsFactory = new OrientationFactory();
	private RoverCommandFactory commandsFactory = new RoverCommandFactory();

	public Object parse(String inputCommand) {
		StringTokenizer tokenizer = new StringTokenizer(inputCommand);
		Grid ground = this.parseGrid(tokenizer.nextToken());
		List<RoverSpecification> rovers = new ArrayList<RoverSpecification>();
		while (tokenizer.hasMoreTokens()) {
			rovers.add(this.parseRoverSpecification(tokenizer.nextToken(), tokenizer.nextToken(), ground));
		}
		return new RoverExecutionSpecification(ground, rovers);
	}

	// FIXME: shouldn't receive a GridSpecification? Seems like messing
	// specifications with model
	private RoverSpecification parseRoverSpecification(String locationString, String commandsString, Grid ground) {
		Rover rover = new Rover(this.parseLocation(locationString, ground));
		// String are not Iterable (as if they we're not a List<Character>...)
		List<RoverCommand> commands = new ArrayList<RoverCommand>();
		for (Integer index = 0; index < commandsString.length(); index++) {
			commandsFactory.command(commandsString.charAt(index));
		}
		return new RoverSpecification(rover, commands);
	}

	private Location parseLocation(String locationString, Grid ground) {
		String[] locationParameters = locationString.split(" ", 3);
		return new Location(new Position(new Point(new Integer(locationParameters[0]), new Integer(locationParameters[1])), ground), orientationsFactory.orientation(locationParameters[2]));
	}

	private Grid parseGrid(String gridParameters) {
		// TODO: improve (regex?)
		String[] parameters = gridParameters.split(" ", 2);
		return new Grid(new Point(0, 0), new Point(new Integer(parameters[0]), new Integer(parameters[1])));
	}
}