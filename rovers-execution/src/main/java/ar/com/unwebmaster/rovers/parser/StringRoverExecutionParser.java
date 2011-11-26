package ar.com.unwebmaster.rovers.parser;

import java.util.ArrayList;
import java.util.List;
import ar.com.unwebmaster.rovers.executor.GridSpecification;
import ar.com.unwebmaster.rovers.executor.LocationSpecification;
import ar.com.unwebmaster.rovers.executor.RoverExecutionSpecification;
import ar.com.unwebmaster.rovers.executor.RoverSpecification;
import ar.com.unwebmaster.rovers.executor.commands.RoverCommand;
import ar.com.unwebmaster.rovers.utils.CharactersCursor;
import ar.com.unwebmaster.rovers.utils.Cursor;

// FIXME: get a name :)
public class StringRoverExecutionParser {
	private OrientationFormatter orientationsFormatter = new OrientationFormatter();
	private RoverCommandFormatter commandsFormatter = new RoverCommandFormatter();

	public RoverExecutionSpecification parse(String inputCommand) {
		Cursor<Character> commandsString = new CharactersCursor(this.clean(inputCommand));
		GridSpecification ground = this.parseGrid(commandsString);
		List<RoverSpecification> rovers = new ArrayList<RoverSpecification>();
		while (commandsString.hasNext()) {
			rovers.add(this.parseRoverSpecification(commandsString, ground));
		}
		return new RoverExecutionSpecification(ground, rovers);
	}

	public String clean(String inputCommand) {
		String cleanInput = "";
		// String are not Iterable (as if they we're not a List<Character>...)
		for (Integer index = 0; index < inputCommand.length(); index++) {
			Character character = inputCommand.charAt(index);
			if (!Character.isWhitespace(character)) {
				cleanInput += character;
			}
		}
		return cleanInput.toUpperCase();
	}
	
	public RoverSpecification parseRoverSpecification(Cursor<Character> commandsString, GridSpecification ground) {
		LocationSpecification location = this.parseLocation(commandsString, ground);
		List<RoverCommand> commands = this.parseRoverCommands(commandsString);
		return new RoverSpecification(location, commands);
	}

	private List<RoverCommand> parseRoverCommands(Cursor<Character> commandsString) {
		List<RoverCommand> roverCommands = new ArrayList<RoverCommand>();
		while(commandsString.hasNext() && commandsFormatter.isValid(commandsString.peek())) {
			roverCommands.add(commandsFormatter.parse(commandsString.next()));
		}
		return roverCommands;
	}

	public LocationSpecification parseLocation(Cursor<Character> commandsString, GridSpecification ground) {
		return new LocationSpecification(new Integer(commandsString.next().toString()), new Integer(commandsString.next().toString()), ground, orientationsFormatter.parse(commandsString.next().toString()));
	}

	public GridSpecification parseGrid(Cursor<Character> commandsString) {
		// TODO: improve (regex?)
		return new GridSpecification(new Integer(commandsString.next().toString()), new Integer(commandsString.next().toString()));
	}
}