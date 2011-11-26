package ar.com.unwebmaster.executor.commands;

import ar.com.unwebmaster.executor.RoverCommand;
import ar.com.unwebmaster.model.Rover;

public class LeftSpin implements RoverCommand {

	@Override
	public void execute(Rover target) {
		target.spinLeft();
	}
}