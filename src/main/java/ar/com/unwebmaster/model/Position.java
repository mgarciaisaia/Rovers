package ar.com.unwebmaster.model;

import ar.com.unwebmaster.utils.Point;

public class Position {
	private Point coordinate;
	private Grid ground;

	public Position(Point coordinate, Grid ground) {
		this.coordinate = coordinate;
		this.ground = ground;
	}

	public Point coordinate() {
		return coordinate;
	}

	public Grid ground() {
		return ground;
	}
}