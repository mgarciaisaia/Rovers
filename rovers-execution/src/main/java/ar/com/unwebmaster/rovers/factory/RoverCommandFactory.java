package ar.com.unwebmaster.rovers.factory;

import java.util.HashMap;
import java.util.Map;
import ar.com.unwebmaster.rovers.executor.commands.LeftSpin;
import ar.com.unwebmaster.rovers.executor.commands.MoveForward;
import ar.com.unwebmaster.rovers.executor.commands.RightSpin;
import ar.com.unwebmaster.rovers.executor.commands.RoverCommand;

public class RoverCommandFactory {
	private Map<Character, RoverCommand> commands = new HashMap<Character, RoverCommand>();

	public RoverCommandFactory() {
		commands.put('L', new LeftSpin());
		commands.put('R', new RightSpin());
		commands.put('M', new MoveForward());
	}

	public RoverCommand command(Character commandCode) {
		return commands.get(commandCode);
	}
}