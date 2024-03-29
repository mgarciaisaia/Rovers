package ar.com.unwebmaster.rovers.executor;

import java.util.List;
import ar.com.unwebmaster.rovers.executor.commands.RoverCommand;
import ar.com.unwebmaster.rovers.model.Rover;

public class RoverSpecification {
	private LocationSpecification locationSpecification;
	private List<RoverCommand> commands;
	private Rover rover;

	public RoverSpecification(LocationSpecification locationSpecification, List<RoverCommand> commands) {
		this.locationSpecification = locationSpecification;
		this.commands = commands;
	}

	public Rover rover() {
		if (rover == null) {
			synchronized (this) {
				if (rover == null) {
					rover = new Rover(locationSpecification.location());
				}
			}
		}
		return rover;
	}

	public List<RoverCommand> getCommands() {
		return commands;
	}
}