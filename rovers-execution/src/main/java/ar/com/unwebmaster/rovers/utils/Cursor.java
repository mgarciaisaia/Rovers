package ar.com.unwebmaster.rovers.utils;

public interface Cursor<T> {
	T current();

	Boolean hasNext();

	T next();
	
	T peek();
}