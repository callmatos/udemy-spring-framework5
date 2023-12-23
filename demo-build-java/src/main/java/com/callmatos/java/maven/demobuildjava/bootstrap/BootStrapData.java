package com.callmatos.java.maven.demobuildjava.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.callmatos.java.maven.demobuildjava.domain.Author;
import com.callmatos.java.maven.demobuildjava.domain.Book;
import com.callmatos.java.maven.demobuildjava.domain.Publisher;
import com.callmatos.java.maven.demobuildjava.repositories.AuthorRepository;
import com.callmatos.java.maven.demobuildjava.repositories.BookRepository;
import com.callmatos.java.maven.demobuildjava.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner{

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository pRepository;

    
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository pRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.pRepository = pRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        
        System.out.println("Started bootStrapData");

        Publisher p1 = new Publisher("Charles Araujo", "Av. Barcelos", "Manaus", "Amazonas", "69020-200");
        pRepository.save(p1);

        Author eric = new Author("Eric", "Evans");
        Book b1 = new Book("Domain Driven Design","#123123");

        eric.getBooks().add(b1);
        b1.getAuthors().add(eric);

        p1.getBooks().add(b1);
        b1.setPublisher(p1);

        authorRepository.save(eric);
        bookRepository.save(b1);
        
        // =============================

        Author call = new Author("Charles", "Araujo");
        Book b2 = new Book("Java Programmer","#15454");

        call.getBooks().add(b2);
        b2.getAuthors().add(call);

        p1.getBooks().add(b2);
        b2.setPublisher(p1);

        authorRepository.save(call);
        bookRepository.save(b2);

        this.pRepository.save(p1);
        
        System.out.println("Number of Books "+ bookRepository.count());
        System.out.println("Getting the total of Publisher: "+this.pRepository.count());
        System.out.println("Description of Publisher \n"+pRepository.findById(p1.getId()).get().toString());
        System.out.println("Publisher number book: "+p1.getBooks().size());
    }
    
    
}
