package ar.com.unwebmaster.model;

import ar.com.unwebmaster.utils.Point;

// FIXME: implement
public interface Orientation {
	public Orientation atLeft();

	public Orientation atRight();

	public Point coordinateForwarding(Position position);
}