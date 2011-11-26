package ar.com.unwebmaster.rovers.executor.commands;

import ar.com.unwebmaster.rovers.model.Rover;

public class RightSpin extends RoverCommand {
	@Override
	public void execute(Rover target) {
		target.spinRight();
	}
}