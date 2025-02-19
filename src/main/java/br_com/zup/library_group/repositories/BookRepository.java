package br_com.zup.library_group.repositories;

import br_com.zup.library_group.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {


}
