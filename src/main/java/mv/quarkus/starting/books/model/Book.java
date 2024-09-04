package mv.quarkus.starting.books.model;

public class Book {

	private Long id;
	private String title;
	private String author;
	private String year;
	private String genre;
	private int pages;

	public Book() {
	}

	public Book(Long id, String title, String author, String year, String genre, int pages) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.year = year;
		this.genre = genre;
		this.pages = pages;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}
	
}
