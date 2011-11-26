package ar.com.unwebmaster.rovers.model.orientations;

import ar.com.unwebmaster.rovers.model.Orientation;
import ar.com.unwebmaster.rovers.utils.Point;

public class WestOrientation extends Orientation {

	@Override
	public Orientation atLeft() {
		return new SouthOrientation();
	}

	@Override
	public Orientation atRight() {
		return new NorthOrientation();
	}

	@Override
	public Point versor() {
		return new Point(-1, 0);
	}
}