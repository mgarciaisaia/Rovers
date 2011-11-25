package ar.com.unwebmaster.model;

public class Location {
	private Position position;
	private Orientation orientation;

	public Location(Position position, Orientation orientation) {
		this.position = position;
		this.orientation = orientation;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Position getPosition() {
		return position;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public Orientation getOrientation() {
		return orientation;
	}
	
	public Grid ground() {
		return position.getGround();
	}

	public Location leftLocation() {
		return new Location(position, orientation.atLeft());
	}

	public Location rightLocation() {
		return new Location(position, orientation.atRight());
	}

	public Location forwardingLocation() {
		return new Location(this.ground().positionAt(orientation.coordinateForwarding(position)), orientation);
	}
}