package ar.com.unwebmaster.rovers.parser;

public interface Parser<T> {
	T parse(String input);

	Boolean isValid(String input);
}