package ar.com.unwebmaster.factory;

import java.util.HashMap;
import java.util.Map;
import ar.com.unwebmaster.executor.RoverCommand;
import ar.com.unwebmaster.executor.commands.LeftSpin;
import ar.com.unwebmaster.executor.commands.MoveForward;
import ar.com.unwebmaster.executor.commands.RightSpin;

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