package ar.com.unwebmaster.model;

public class Location {
	private Position position;
	private Orientation orientation;

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

	public Location leftLocation() {
		// FIXME: implement
				throw new RuntimeException("Location.leftLocation - not yet implemented");
	}

	public Location rightLocation() {
		// FIXME: implement
				throw new RuntimeException("Location.rightLocation - not yet implemented");
	}

	public Location forwardingLocation() {
		// FIXME: implement
				throw new RuntimeException("Location.forwardingLocation - not yet implemented");
	}
}