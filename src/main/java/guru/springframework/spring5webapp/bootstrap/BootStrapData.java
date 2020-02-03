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
        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");
        publisherRepository.save(publisher);
        System.out.println("Number of publishers "+publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book book = new Book("Domain Driven Design", "124343434");
        eric.getBooks().add(book);
        book.getAuthors().add(eric);

        book.setPublisher(publisher);
        publisher.getBooks().add(book);

        authorRepository.save(eric);
        bookRepository.save(book);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book jee = new Book("J2EE Development without EJB", "98097069898");
        rod.getBooks().add(jee);
        jee.getAuthors().add(rod);

        jee.setPublisher(publisher);
        publisher.getBooks().add(jee);

        authorRepository.save(rod);
        bookRepository.save(jee);
        publisherRepository.save(publisher);


        System.out.println("Number of Books "+bookRepository.count());
        System.out.println("Number of books with publisher "+publisher.getBooks().size());
    }
}
