package mv.quarkus.starting;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.Response.Status.OK;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
class BookResourceTest {
    
	@BeforeAll
	static void setup() {
//		RestAssured.baseURI = "http://localhost";
//		RestAssured.port = 8081;
	}
	
	@Test
    public void testHelloEndpoint() {
        given()
          .when().get("/api/books/hello")
          .then()
             .statusCode(OK.getStatusCode())
             .body(is("Hello World & Universe RESTEasy!! :D"));
    }
	
	@Test
	public void testGetAllBooks() {
		given().
			header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
		when().
			get("/api/books").
		then().
			statusCode(OK.getStatusCode()).
			body("size()", is(6));
	}
	
	@Test
	public void testCountAllBooks() {
		given().
			header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN).
		when().
			get("/api/books/count").
		then().
			statusCode(OK.getStatusCode()).
			body(is("6"));
	}
	
	@Test
	public void testGetBookById() {
		given().
			header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
			pathParam("id", 1L).
		when().
			get("/api/books/{id}").
		then().
			statusCode(OK.getStatusCode()).
			body("title", is("The Hobbit"), 
					"author", is("J.R.R. Tolkien"), 
					"year", is("1937"), 
					"genre", is("Fantasy"), 
					"pages", is(310));
	}

}