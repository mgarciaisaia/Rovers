package ar.com.unwebmaster.rovers.executor;

import java.util.logging.Logger;
import ar.com.unwebmaster.rovers.executor.commands.RoverCommand;
import ar.com.unwebmaster.rovers.model.Grid;
import ar.com.unwebmaster.rovers.model.Location;
import ar.com.unwebmaster.rovers.model.Rover;
import ar.com.unwebmaster.rovers.parser.Formatter;
import ar.com.unwebmaster.rovers.parser.LocationFormatter;
import ar.com.unwebmaster.rovers.parser.RoverCommandFormatter;

public class RoversSystemExecutor {
	private static Logger logger = Logger.getLogger(RoversSystemExecutor.class.getName());

	public String execute(RoverExecutionSpecification specification) {
		String output = "";
		Formatter<Location> locationFormatter = new LocationFormatter();
		Formatter<RoverCommand> commandFormatter = new RoverCommandFormatter();
		logger.info("Executing specification");
		Grid ground = specification.getGroundSpecification().grid();
		logger.info("Ground size: " + ground.getLowestCorner() + " - " + ground.getTopCorner());
		for (RoverSpecification roverSpecification : specification.getRoverSpecifications()) {
			Rover rover = roverSpecification.rover();
			logger.info("Rover located at: " + locationFormatter.format(rover.getLocation()));
			for (RoverCommand command : roverSpecification.getCommands()) {
				command.execute(rover);
				logger.info("Rover executed " + commandFormatter.format(command) + " and got located at " + locationFormatter.format(rover.getLocation()));
			}
			logger.info("Rover's commands execution completed");
			output += locationFormatter.format(rover.getLocation()) + "\n";
		}
		return output;
	}
}