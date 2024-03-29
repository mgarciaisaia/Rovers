package ar.com.unwebmaster.rovers.utils;

public class Point {
	private final Integer x;
	private final Integer y;

	public Point(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}

	public Integer x() {
		return x;
	}

	public Integer y() {
		return y;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	public Point add(Point anotherPoint) {
		return new Point(x + anotherPoint.x(), y + anotherPoint.y());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		return x.equals(other.x()) && y.equals(other.y());
	}	
}