package ar.com.unwebmaster.utils;

public class Point {
	private Integer x;
	private Integer y;

	public Point(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getX() {
		return x;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public Integer getY() {
		return y;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
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
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}	
}