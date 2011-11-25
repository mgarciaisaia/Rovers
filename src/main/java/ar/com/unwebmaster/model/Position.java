package ar.com.unwebmaster.model;

import ar.com.unwebmaster.utils.Point;

public class Position {
	private Point coordinate;
	private Grid ground;

	public Position(Point coordinate, Grid ground) {
		this.coordinate = coordinate;
		this.ground = ground;
	}

	public void setCoordinate(Point coordinate) {
		this.coordinate = coordinate;
	}

	public Point getCoordinate() {
		return coordinate;
	}

	public void setGround(Grid ground) {
		this.ground = ground;
	}

	public Grid getGround() {
		return ground;
	}
}