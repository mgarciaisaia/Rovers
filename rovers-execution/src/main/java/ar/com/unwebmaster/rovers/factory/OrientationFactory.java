package ar.com.unwebmaster.rovers.factory;

import java.util.HashMap;
import java.util.Map;
import ar.com.unwebmaster.rovers.model.Orientation;
import ar.com.unwebmaster.rovers.model.orientations.EastOrientation;
import ar.com.unwebmaster.rovers.model.orientations.NorthOrientation;
import ar.com.unwebmaster.rovers.model.orientations.SouthOrientation;
import ar.com.unwebmaster.rovers.model.orientations.WestOrientation;

public class OrientationFactory {
	private Map<String, Orientation> orientations = new HashMap<String, Orientation>();

	public OrientationFactory() {
		orientations.put("N", new NorthOrientation());
		orientations.put("W", new WestOrientation());
		orientations.put("E", new EastOrientation());
		orientations.put("S", new SouthOrientation());
	}

	public Orientation orientation(String orientationCode) {
		return orientations.get(orientationCode);
	}
}