package ar.com.unwebmaster.model;

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
		// FIXME: implement
		throw new RuntimeException("Not yet implemented");
	}
	
	public void spinRight() {
		// FIXME: implement
		throw new RuntimeException("Not yet implemented");
	}
	
	public void moveForward() {
		// FIXME: implement
		throw new RuntimeException("Not yet implemented");
	}
}