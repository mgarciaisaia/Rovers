package ar.com.unwebmaster.rovers.executor.commands;

import ar.com.unwebmaster.rovers.model.Rover;

public abstract class RoverCommand {
	public abstract void execute(Rover target);
	
	@Override
	public boolean equals(Object object) {
		if(object == null) {
			return false;
		}
		return object.getClass().equals(getClass());
	}
	
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}