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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordinate == null) ? 0 : coordinate.hashCode());
		result = prime * result + ((ground == null) ? 0 : ground.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (coordinate == null) {
			if (other.coordinate != null)
				return false;
		} else if (!coordinate.equals(other.coordinate))
			return false;
		if (ground == null) {
			if (other.ground != null)
				return false;
		} else if (!ground.equals(other.ground))
			return false;
		return true;
	}
}