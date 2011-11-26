package ar.com.unwebmaster.rovers.model.orientations;

import ar.com.unwebmaster.rovers.model.Orientation;
import ar.com.unwebmaster.rovers.utils.Point;

public class EastOrientation extends Orientation {

	@Override
	public Orientation atLeft() {
		return new NorthOrientation();
	}

	@Override
	public Orientation atRight() {
		return new SouthOrientation();
	}

	@Override
	public Point versor() {
		return new Point(1, 0);
	}
}