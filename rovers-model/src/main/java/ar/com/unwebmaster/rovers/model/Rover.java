package ar.com.unwebmaster.rovers.model;

public class Rover {
	private Location location;

	public Rover(Location location) {
		this.setLocation(location);
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Location getLocation() {
		return location;
	}

	public void spinLeft() {
		this.location = location.leftLocation();
	}

	public void spinRight() {
		this.location = location.rightLocation();
	}

	public void moveForward() {
		this.location = location.forwardingLocation();
	}
}