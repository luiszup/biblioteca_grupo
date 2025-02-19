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

        Book book = new Book();
        book.setTitle(bookRequest.title());
        book.setAuthor(bookRequest.author());
        book.setPublicationYear(bookRequest.publicationYear());
        book.setGenre(Genre.fromString(bookRequest.genre()));

        Book savedBook = bookRepository.save(book);
        return new BookResponse(
                savedBook.getId(), savedBook.getTitle(), savedBook.getAuthor(), savedBook.getPublicationYear(),
                savedBook.getGenre().toString()
        );
    }


}
