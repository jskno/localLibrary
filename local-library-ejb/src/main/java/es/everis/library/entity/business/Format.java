package es.everis.library.entity.business;

public enum Format {
	
	PAPERBACK("Paperback", WorkType.BOOK),
	HARDCOVER("Hardcover", WorkType.BOOK),
	EBOOK("Ebook" , WorkType.BOOK),
	DVD("Dvd", WorkType.FILM),
	MP3("mp3", WorkType.FILM);
	
	private final String label;
	private final WorkType workType;
	
	Format(String label, WorkType workType) {
		this.label = label;
		this.workType = workType;
	}
	
	public String label() { return label; }
	public WorkType workType() { return workType; }
	
	public Format getFormat(String label) {
		return Format.valueOf(label.toUpperCase());
	}

}
