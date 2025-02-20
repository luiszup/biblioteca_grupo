package br_com.zup.library_group.services;

import br_com.zup.library_group.dtos.BookRequest;
import br_com.zup.library_group.dtos.BookResponse;
import br_com.zup.library_group.dtos.Genre;
import br_com.zup.library_group.models.Book;
import br_com.zup.library_group.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookResponse addBook(BookRequest bookRequest) {

        Book addBook = new Book();
        addBook.setTitle(bookRequest.title());
        addBook.setAuthor(bookRequest.author());
        addBook.setPublicationYear(bookRequest.publicationYear());
        addBook.setGenre(Genre.fromString(bookRequest.genre()));

        Book savedBook = bookRepository.save(addBook);
        return new BookResponse(savedBook.getId(), savedBook.getTitle(), savedBook.getAuthor(), savedBook.getPublicationYear(), savedBook.getGenre().toString());
    }
    
    public BookResponse getBookById(Long id) {
        Optional<Book> boockOptional = bookRepository.findById(id);
        Book Listingbook = boockOptional.get();
        return new BookResponse(Listingbook.getId(), Listingbook.getTitle(), Listingbook.getAuthor(), Listingbook.getPublicationYear(), Listingbook.getGenre().toString());
    }

    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(getAllBooks -> new BookResponse(getAllBooks.getId(), getAllBooks.getTitle(), getAllBooks.getAuthor(), getAllBooks.getPublicationYear(), getAllBooks.getGenre().toString()))
                .collect(Collectors.toList());
    }

    public BookResponse updateBook(Long id, BookResponse bookResponse) {
        Optional<Book> booksOptional = bookRepository.findById(id);
        Book updateBook = booksOptional.get();
        updateBook.setTitle(bookResponse.title());
        updateBook.setAuthor(bookResponse.Author());
        updateBook.setPublicationYear(bookResponse.publicationYear());
        updateBook.setGenre(Genre.fromString(bookResponse.genre()));
        Book savedBook = bookRepository.save(updateBook);
        return new BookResponse(savedBook.getId(), savedBook.getTitle(), savedBook.getAuthor(), savedBook.getPublicationYear(), savedBook.getGenre().toString());
    }

    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }
}
