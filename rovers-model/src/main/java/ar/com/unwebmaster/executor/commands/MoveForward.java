package ar.com.unwebmaster.executor.commands;

import ar.com.unwebmaster.model.Rover;

public class MoveForward extends RoverCommand {
	@Override
	public void execute(Rover target) {
		target.moveForward();
	}
}