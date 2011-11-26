package ar.com.unwebmaster.executor.commands;

import ar.com.unwebmaster.model.Rover;

public class RightSpin implements RoverCommand {

	@Override
	public void execute(Rover target) {
		target.spinRight();
	}
}