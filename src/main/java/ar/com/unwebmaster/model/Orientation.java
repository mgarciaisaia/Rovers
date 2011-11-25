package ar.com.unwebmaster.model;

import ar.com.unwebmaster.utils.Point;

// TODO: need to subclass? can't there be just 4 instances and that's it?
public abstract class Orientation {
	public abstract Orientation atLeft();

	public abstract Orientation atRight();
	
	public abstract Point versor();

	public Point coordinateForwarding(Position position) {
		return position.getCoordinate().add(this.versor());
	}
}