package ar.com.unwebmaster.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StringIterator implements Iterator<Character> {

	private Iterator<Character> iterator;

	public StringIterator(String source) {
		List<Character> characters = new ArrayList<Character>();
		for (Integer index = 0; index < source.length(); index++) {
			characters.add(source.charAt(index));
		}
		iterator = characters.iterator();
	}

	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}

	@Override
	public Character next() {
		return iterator.next();
	}

	@Override
	public void remove() {
		iterator.remove();
	}
}