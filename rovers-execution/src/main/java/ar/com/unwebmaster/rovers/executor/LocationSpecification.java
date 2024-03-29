package ar.com.unwebmaster.rovers.executor;

import ar.com.unwebmaster.rovers.model.Location;
import ar.com.unwebmaster.rovers.model.Orientation;
import ar.com.unwebmaster.rovers.model.Position;
import ar.com.unwebmaster.rovers.utils.Point;

public class LocationSpecification {

	private Integer x;
	private Integer y;
	private GridSpecification groundSpecification;
	private Orientation orientation;
	private Location location;

	public LocationSpecification(Integer x, Integer y, GridSpecification groundSpecification, Orientation orientation) {
		this.x = x;
		this.y = y;
		this.groundSpecification = groundSpecification;
		this.orientation = orientation;
	}

	public Location location() {
		if (location == null) {
			synchronized (this) {
				if (location== null) {
					location = new Location(new Position(new Point(x, y), groundSpecification.grid()), orientation);
				}
			}
		}
		return location;
	}
}