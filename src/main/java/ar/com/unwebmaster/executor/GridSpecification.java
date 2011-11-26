package ar.com.unwebmaster.executor;

import ar.com.unwebmaster.model.Grid;
import ar.com.unwebmaster.utils.Point;

public class GridSpecification {
	private Integer topX;
	private Integer topY;
	private Grid grid;

	public GridSpecification(Integer topX, Integer topY) {
		this.topX = topX;
		this.topY = topY;
	}

	public Grid grid() {
		if (grid == null) {
			synchronized (this) {
				if (grid == null) {
					grid = new Grid(new Point(0, 0), new Point(topX, topY));
				}
			}
		}
		return grid;
	}
}