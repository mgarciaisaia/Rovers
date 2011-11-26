package ar.com.unwebmaster.rovers.executor;

import java.util.List;

public class RoverExecutionSpecification {
	private GridSpecification groundSpecification;
	private List<RoverSpecification> roverSpecifications;

	public RoverExecutionSpecification(GridSpecification groundSpecification, List<RoverSpecification> roverSpecifications) {
		this.groundSpecification = groundSpecification;
		this.roverSpecifications = roverSpecifications;
	}

	public void setGroundSpecification(GridSpecification groundSpecification) {
		this.groundSpecification = groundSpecification;
	}

	public GridSpecification getGroundSpecification() {
		return groundSpecification;
	}

	public void setRoverSpecifications(List<RoverSpecification> roverSpecifications) {
		this.roverSpecifications = roverSpecifications;
	}

	public List<RoverSpecification> getRoverSpecifications() {
		return roverSpecifications;
	}

}