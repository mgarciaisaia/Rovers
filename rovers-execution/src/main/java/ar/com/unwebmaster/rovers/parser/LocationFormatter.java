package ar.com.unwebmaster.rovers.parser;

import ar.com.unwebmaster.rovers.model.Location;
import ar.com.unwebmaster.rovers.utils.Point;

public class LocationFormatter implements Formatter<Location> {

	private OrientationFormatter orientations = new OrientationFormatter();

	@Override
	public String format(Location target) {
		Point coordinate = target.getPosition().coordinate();
		return coordinate.x() + " " + coordinate.y() + " " + orientations.format(target.getOrientation());
	}
}