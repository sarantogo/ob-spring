package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.models.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    private Logger log = LoggerFactory.getLogger(BookController.class);

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //CRUD on Book entity

    //Search all books (book list)
    /**
     http:localhost:8080/api/books
     **/
@GetMapping("/api/books")
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    //Search one book by id
    @GetMapping("/api/books/{id}")
    @ApiOperation("Search a book by primary key ID")
    public ResponseEntity<Book> findOneById(@ApiParam("Primary key of type Long")  @PathVariable Long id){
    Optional<Book> book= bookRepository.findById(id);

    if(book.isPresent()){
        return ResponseEntity.ok(book.get());
    }
    else{
        return ResponseEntity.notFound().build();
    }

    }

    //create and save a new book in database
@PostMapping("/api/books")
    public ResponseEntity<Book> create(@RequestBody Book book, @RequestHeader HttpHeaders headers){

    System.out.println("User-Agent: "+ headers.get("User-Agent"));
    if(book.getId()!=null){
        log.warn("Trying to create a book with id");
        return ResponseEntity.badRequest().build();
    }
        Book createdBook = bookRepository.save(book);
        return ResponseEntity.ok(createdBook);
    }

    //Update a book in database
    @PutMapping("/api/books")
    public ResponseEntity<Book> update(@RequestBody Book book){
    if(book.getId()==null){
        log.warn("Trying to update a non existing book");
        return ResponseEntity.badRequest().build();
    }
    if(!bookRepository.existsById(book.getId())){
        return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(bookRepository.save(book));
    }

    //Delete a book from database
    @ApiIgnore //Ignore this method in the swagger documentation
    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Book> delete (@PathVariable Long id){

    if(!bookRepository.existsById(id)){
        log.warn("Trying to delete a non existing book");
        return ResponseEntity.notFound().build();
    }

    bookRepository.deleteById(id);
    return ResponseEntity.noContent().build();

    }


}
