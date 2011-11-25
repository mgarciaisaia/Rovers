package ar.com.unwebmaster.utils;

public class Point {
	private Number x;
	private Number y;

	public Point(Number x, Number y) {
		this.x = x;
		this.y = y;
	}

	public void setX(Number x) {
		this.x = x;
	}

	public Number getX() {
		return x;
	}

	public void setY(Number y) {
		this.y = y;
	}

	public Number getY() {
		return y;
	}
}