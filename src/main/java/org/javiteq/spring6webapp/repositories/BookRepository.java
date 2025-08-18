package org.javiteq.spring6webapp.repositories;

import org.javiteq.spring6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
