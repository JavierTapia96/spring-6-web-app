package org.javiteq.spring6webapp.services;

import org.javiteq.spring6webapp.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
