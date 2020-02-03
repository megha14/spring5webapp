package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.model.repositories.AuthorRepository;
import guru.springframework.spring5webapp.model.repositories.BookRepository;
import guru.springframework.spring5webapp.model.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book book = new Book("Domain Driven Design", "124343434");
        eric.getBooks().add(book);
        book.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(book);

        Author rod = new Author("Rod", "Johnson");
        Book jee = new Book("J2EE Development without EJB", "98097069898");
        rod.getBooks().add(jee);
        jee.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(jee);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books "+bookRepository.count());

        Publisher publisher = new Publisher("John Hem", "9 Hemingway", "Irvine", "CA", 97655);

        publisherRepository.save(publisher);
        System.out.println("Number of Publishers "+publisherRepository.count());
    }
}
