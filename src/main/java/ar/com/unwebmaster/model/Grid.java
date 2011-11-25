package ar.com.unwebmaster.model;

import java.util.HashMap;
import java.util.Map;
import ar.com.unwebmaster.utils.Point;

public class Grid {
	private Map<Point, Position> positions = new HashMap<Point, Position>();
	private Point topCorner;
	private Point lowestCorner;

	public Grid(Point lowestCorner, Point topCorner) {
		this.lowestCorner = lowestCorner;
		this.topCorner = topCorner;
	}

	public Position positionAt(Point coordinate) {
		this.validateCoordinate(coordinate);
		if (positions.get(coordinate) == null) {
			// Thread-safe lazy initialization
			synchronized (this) {
				if (positions.get(coordinate) == null) {
					positions.put(coordinate, new Position(coordinate, this));
				}
			}
		}
		return positions.get(coordinate);
	}

	private void validateCoordinate(Point coordinate) {
		// XXX: too much comparations. Should be a better way... (¿aPoint.greaterThan(anotherPoint)?)
		if (coordinate.getX() < lowestCorner.getX() || coordinate.getX() > topCorner.getX() || coordinate.getY() < lowestCorner.getY() || coordinate.getY() > topCorner.getY()) {
			throw new RuntimeException("Coordinate " + coordinate.toString() + " out of range " + lowestCorner.toString() + " - " + topCorner.toString());
		}
	}
}