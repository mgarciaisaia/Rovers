package ar.com.unwebmaster.model;

import java.util.HashMap;
import java.util.Map;
import ar.com.unwebmaster.utils.Point;

public class Grid {
	private Map<Point, Position> positions = new HashMap<Point, Position>();

	public Position positionAt(Point coordinate) {
		// TODO: validate grid dimensions
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
}