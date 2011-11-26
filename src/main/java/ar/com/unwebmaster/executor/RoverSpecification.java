package ar.com.unwebmaster.executor;

import java.util.List;
import ar.com.unwebmaster.model.Rover;

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