package mv.quarkus.starting.books.repository;

import java.util.List;
import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;
import mv.quarkus.starting.books.model.Book;

@ApplicationScoped
public class BookRepository {
	
	public List<Book> getAllBooks() {
		return List.of(new Book(1L, "The Hobbit", "J.R.R. Tolkien", "1937", "Fantasy", 310),
				new Book(2L, "The Lord of the Rings", "J.R.R. Tolkien", "1954", "Fantasy", 1178),
				new Book(3L, "The Silmarillion", "J.R.R. Tolkien", "1977", "Fantasy", 365),
				new Book(4L, "The Great Gatsby", "F. Scott Fitzgerald", "1925", "Fiction", 180),
				new Book(5L, "Thinking in Java", "Bruce Eckel", "2006", "Programming", 1150),
				new Book(6L, "Understanding Quarkus", "Antonio Goncalves", "2021", "Programming", 350));
	}
	
	public Optional<Book> getBookById(Long id) {
		return getAllBooks().stream().filter(b -> b.getId().equals(id)).findFirst();
	}
}
