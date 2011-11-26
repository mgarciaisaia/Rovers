package ar.com.unwebmaster.rovers.parser;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import ar.com.unwebmaster.rovers.model.Orientation;
import ar.com.unwebmaster.rovers.model.orientations.EastOrientation;
import ar.com.unwebmaster.rovers.model.orientations.NorthOrientation;
import ar.com.unwebmaster.rovers.model.orientations.SouthOrientation;
import ar.com.unwebmaster.rovers.model.orientations.WestOrientation;
import ar.com.unwebmaster.rovers.parser.Formatter;
import ar.com.unwebmaster.rovers.parser.Parser;

public class OrientationFormatter implements Formatter<Orientation>, Parser<Orientation> {
	private Map<String, Orientation> orientations = new HashMap<String, Orientation>();
	private Map<Orientation, String> orientationsInverse = new HashMap<Orientation, String>();

	public OrientationFormatter() {
		orientations.put("N", new NorthOrientation());
		orientations.put("W", new WestOrientation());
		orientations.put("E", new EastOrientation());
		orientations.put("S", new SouthOrientation());

		for (Entry<String, Orientation> entry : orientations.entrySet()) {
			orientationsInverse.put(entry.getValue(), entry.getKey());
		}
	}

	@Override
	public String format(Orientation target) {
		return orientationsInverse.get(target);
	}

	@Override
	public Orientation parse(String text) {
		return orientations.get(text.toUpperCase().trim());
	}
}