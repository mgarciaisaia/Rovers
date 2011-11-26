package ar.com.unwebmaster.rovers.utils;

public class CharactersCursor implements Cursor<Character> {
	private CharSequence target;
	private Integer index = -1;

	public CharactersCursor(CharSequence target) {
		this.target = target;
	}

	@Override
	public Character current() {
		return target.charAt(index);
	}

	@Override
	public Boolean hasNext() {
		return index < target.length() - 1;
	}

	@Override
	public Character next() {
		return target.charAt(++index);
	}
	
	@Override
	public Character peek() {
		return target.charAt(index + 1);
	}
}