package ar.com.unwebmaster.executor.commands;

import ar.com.unwebmaster.model.Rover;

public class LeftSpin extends RoverCommand {
	@Override
	public void execute(Rover target) {
		target.spinLeft();
	}
}