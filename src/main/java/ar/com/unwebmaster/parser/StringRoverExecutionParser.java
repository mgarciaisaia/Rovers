package ar.com.unwebmaster.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import ar.com.unwebmaster.executor.GridSpecification;
import ar.com.unwebmaster.executor.LocationSpecification;
import ar.com.unwebmaster.executor.RoverExecutionSpecification;
import ar.com.unwebmaster.executor.RoverSpecification;
import ar.com.unwebmaster.executor.commands.RoverCommand;
import ar.com.unwebmaster.factory.OrientationFactory;
import ar.com.unwebmaster.factory.RoverCommandFactory;

// FIXME: get a name :)
public class StringRoverExecutionParser {
	private OrientationFactory orientationsFactory = new OrientationFactory();
	private RoverCommandFactory commandsFactory = new RoverCommandFactory();

	public RoverExecutionSpecification parse(String inputCommand) {
		StringTokenizer tokenizer = new StringTokenizer(inputCommand.trim().toUpperCase(), "\n");
		GridSpecification ground = this.parseGrid(tokenizer.nextToken());
		List<RoverSpecification> rovers = new ArrayList<RoverSpecification>();
		while (tokenizer.hasMoreTokens()) {
			rovers.add(this.parseRoverSpecification(tokenizer.nextToken(), tokenizer.nextToken(), ground));
		}
		return new RoverExecutionSpecification(ground, rovers);
	}

	public RoverSpecification parseRoverSpecification(String locationString, String commandsString, GridSpecification ground) {
		// String are not Iterable (as if they we're not a List<Character>...)
		List<RoverCommand> commands = new ArrayList<RoverCommand>();
		for (Integer index = 0; index < commandsString.length(); index++) {
			commands.add(commandsFactory.command(commandsString.charAt(index)));
		}
		return new RoverSpecification(this.parseLocation(locationString, ground), commands);
	}

	public LocationSpecification parseLocation(String locationString, GridSpecification ground) {
		String[] locationParameters = locationString.split(" ", 3);
		return new LocationSpecification(new Integer(locationParameters[0]), new Integer(locationParameters[1]), ground, orientationsFactory.orientation(locationParameters[2]));
	}

	public GridSpecification parseGrid(String gridParameters) {
		// TODO: improve (regex?)
		String[] parameters = gridParameters.split(" ", 2);
		return new GridSpecification(new Integer(parameters[0]), new Integer(parameters[1]));
	}
}