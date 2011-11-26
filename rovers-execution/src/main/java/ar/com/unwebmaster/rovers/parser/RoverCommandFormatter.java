package ar.com.unwebmaster.rovers.parser;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import ar.com.unwebmaster.rovers.executor.commands.LeftSpin;
import ar.com.unwebmaster.rovers.executor.commands.MoveForward;
import ar.com.unwebmaster.rovers.executor.commands.RightSpin;
import ar.com.unwebmaster.rovers.executor.commands.RoverCommand;

public class RoverCommandFormatter implements Formatter<RoverCommand>, Parser<RoverCommand> {

	private Map<String, RoverCommand> commands = new HashMap<String, RoverCommand>();
	private Map<RoverCommand, String> commandsInverse = new HashMap<RoverCommand, String>();

	// TODO: keeps smelling
	public RoverCommandFormatter() {
		commands.put("L", new LeftSpin());
		commands.put("R", new RightSpin());
		commands.put("M", new MoveForward());

		for (Entry<String, RoverCommand> entry : commands.entrySet()) {
			commandsInverse.put(entry.getValue(), entry.getKey());
		}
	}

	@Override
	public String format(RoverCommand target) {
		return commandsInverse.get(target);
	}

	@Override
	public RoverCommand parse(String input) {
		return commands.get(input);
	}

	public RoverCommand parse(Character input) {
		return this.parse("" + input);
	}
}