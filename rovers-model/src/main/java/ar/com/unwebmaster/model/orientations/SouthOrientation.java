package ar.com.unwebmaster.model.orientations;

import ar.com.unwebmaster.model.Orientation;
import ar.com.unwebmaster.utils.Point;

public class SouthOrientation extends Orientation {

	@Override
	public Orientation atLeft() {
		return new EastOrientation();
	}

	@Override
	public Orientation atRight() {
		return new WestOrientation();
	}

	@Override
	public Point versor() {
		return new Point(0, -1);
	}
}