package es.everis.library.entity.business;

public enum WorkType {
	
	BOOK("Book"),
	FILM("Film");
	
	private String label;
	
	WorkType(String label) {
		this.label = label;
	}
	
	public String label() { return label; }

}
