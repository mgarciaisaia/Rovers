package ar.com.unwebmaster.model;

import ar.com.unwebmaster.utils.Point;

// TODO: need to subclass? can't there be just 4 instances and that's it?
public abstract class Orientation {
	public abstract Orientation atLeft();

	public abstract Orientation atRight();
	
	public abstract Point versor();

	public Point coordinateForwarding(Position position) {
		return position.coordinate().add(this.versor());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.versor().hashCode();
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
		Orientation other = (Orientation) obj;
		return this.versor().equals(other.versor());
	}
}