package br_com.zup.library_group.controllers;

import br_com.zup.library_group.dtos.BookRequest;
import br_com.zup.library_group.dtos.BookResponse;
import br_com.zup.library_group.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookResponse> registerBook(@Valid @RequestBody BookRequest bookRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addBook(bookRequest));
    }
}

//        public boocksDto registerBook(boocksDto) {
//
//            books newBook = new books;
//            //doing the sets and gets
//
//            //Salvando
//            books savingBoocks = boocksRepository.save(newBoocks);
//            //validações
//            return boocksDto(savingBoocks.get)
//            throw new handleGenericException201(" " + gender + ". Escolha uma categoria valida.");
//
//        }
//
//        // Listingallbooks
//        public List<boocksDto> getBookById() {
//            return boocksRepository.findabyID()
//                    .map(produtos -> new boocksDto(produtos.getNomeProduto(), produtos.getPrecoProduto(), produtos.getQuantidade()))
//                    .collect(Collectors.toList());
//            throw new handleGenericException200("ListingBoocks");
//
//        }
//
//        //Lisingbook
//        public boocksDto Listingbook(long id) {
//            Optional<books> booksOptional = booksRepository.findById(cpf);
//            Books books = booksOptional.get();
//            if (boock.isEmpty()) {
//                return new BooksDto(books.getCpf(), books.getEmail(), books.getNomeUsuario());
//                throw new handleGenericException200("ListingBoock");
//            }
//            else {
//                throw new handleGenericException404("Book not found");
//            }
//        }
//        // atualizeBoock
//        public BooksDto updateBook(Long id, BooksDto booksDto) {
//            Optional<books> booksOptional = booksRepository.findById(id);
//            genderValidator(String gender);
//            if (booksOptional.isPresent()) {
//                Boock BoockAtualizad = booksptional.get();
//                BoockAtualizad.setNomeUsuario(booksDTO.getNomeUsuario());
//                BoockAtualizad.setCpf(booksDTO.getCpf());
//                BoockAtualizad.setEmail(clientesDTO.getEmail());
//                Boock BoockSalvo = clientesRepository.save(clienteAtualizado);
//                return new BooksDto(clienteSalvo.getCpf(), clienteSalvo.getEmail(), clienteSalvo.getNomeUsuario());
//            } else {
//                throw new handleGenericException("Cliente não encontrado!");
//            }
//        }
//
//        //DeleteBoock
//        public BooksDto deleteBook(long id,BooksDto booksDto){
//            BoockRepository.deleteById(id);
//
//            throw new handleGenericException201("livro deletado");
//
//
//        }
//
//        //---------------------------
//        private Void BoockCategori(String BoockCategori) {
//            BoockCategori.get
//            if (gender != (gender < FICTION || NON_FICTION || SCIENCE || HISTORY || FANTASY >))
//                throw new handleGenericException("Aviso: não esiste a categoria: " + gender + ". Escolha uma categoria valida.");
//        }
//    }