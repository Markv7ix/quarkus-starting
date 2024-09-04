package mv.quarkus.starting.books;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import mv.quarkus.starting.books.model.Book;
import mv.quarkus.starting.books.repository.BookRepository;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

	@Inject
	BookRepository bookRepository;
	
	@Inject
	Logger logger;
	
	@GET
	public List<Book> getAllBooks() {
		logger.info("Getting all books");
		return bookRepository.getAllBooks();
	}

	@GET 
	@Path("/count")
	@Produces(MediaType.TEXT_PLAIN)
	public int countAllBooks() {
		logger.info("Counting all books");
		return bookRepository.getAllBooks().size();
	}
	
	@GET
	@Path("{id}")
	public Optional<Book> getBookById(@PathParam("id") Long id) {
		logger.info("Getting book by id: " + id);
		return bookRepository.getBookById(id);
	}
	
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		logger.info("Saying hello!!");
		return "Hello World & Universe RESTEasy!! :D";
	}
}
