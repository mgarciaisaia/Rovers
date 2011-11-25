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
}