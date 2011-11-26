package ar.com.unwebmaster.rovers.model.orientations;

import ar.com.unwebmaster.rovers.model.Orientation;
import ar.com.unwebmaster.rovers.utils.Point;

public class NorthOrientation extends Orientation {

	@Override
	public Orientation atLeft() {
		return new WestOrientation();
	}

	@Override
	public Orientation atRight() {
		return new EastOrientation();
	}

	@Override
	public Point versor() {
		return new Point(0, 1);
	}
}