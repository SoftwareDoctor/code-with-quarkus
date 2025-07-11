package it.softwaredoctor.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import it.softwaredoctor.model.Book;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookRepository implements PanacheRepository<Book> {
}
