package ar.com.unwebmaster.rovers.parser;

public interface Parser<T> {
	public T parse(String input);
}