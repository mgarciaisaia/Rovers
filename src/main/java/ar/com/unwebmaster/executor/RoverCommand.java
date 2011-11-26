package ar.com.unwebmaster.executor;

import ar.com.unwebmaster.model.Rover;

public interface RoverCommand {
	public void execute(Rover target);
}