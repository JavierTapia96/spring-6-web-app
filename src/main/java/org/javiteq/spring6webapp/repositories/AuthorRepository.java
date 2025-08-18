package org.javiteq.spring6webapp.repositories;

import org.javiteq.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
