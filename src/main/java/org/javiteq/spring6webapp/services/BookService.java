package org.javiteq.spring6webapp.services;

import org.javiteq.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
