package mk.tomatoes.entity;

public enum PosterType {

	THUMBNAIL(0),
	PROFILE(1),
	DETAILED(2),
	ORIGINAL(3);
	
	private int value;
	
	public int getValue() {
		return value;
	}
	
	private PosterType(int value) {
		this.value = value;
	}
	
}
