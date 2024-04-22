package Lab02.AimsProject.src.hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Media	{
	// Attributes
	private String director;
	private int length;
	
	// Getters and Setters
	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getLength() {
		return length;
	}

	// Constructors
	public DigitalVideoDisc(String title) {
		super();
		this.setTitle(title);
		this.setCost(0);
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.setTitle(title);
		this.setCategory(category);
		this.setCost(cost);
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.setTitle(title);
		this.setCategory(category);
		this.setDirector(director);
		this.setCost(cost);
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.setTitle(title);
		this.setCategory(category);
		this.setDirector(director);
		this.setLength(length);
		this.setCost(cost);
	}

	@Override
	public String toString() {
		return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + " : " + getCost() + "$";
	}

	public boolean isMatch(String title) {
		return this.getTitle().equals(title);
	}
}
