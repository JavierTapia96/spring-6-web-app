package org.javiteq.spring6webapp.bootstrap;

import org.javiteq.spring6webapp.domain.Author;
import org.javiteq.spring6webapp.domain.Book;
import org.javiteq.spring6webapp.domain.Publisher;
import org.javiteq.spring6webapp.repositories.AuthorRepository;
import org.javiteq.spring6webapp.repositories.BookRepository;
import org.javiteq.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository,
                         BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");
        authorRepository.save(eric);

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");
        authorRepository.save(rod);

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("654321");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);
        dddSaved.getAuthors().add(ericSaved);
        noEJBSaved.getAuthors().add(rodSaved);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("New York Publications");
        publisher.setAddress("123 Main St");
        publisher.setCity("New York City");
        publisher.setState("New York");
        publisher.setZip("10001");

        Publisher publisherSaved = publisherRepository.save(publisher);

        dddSaved.setPublisher(publisherSaved);
        noEJBSaved.setPublisher(publisherSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
