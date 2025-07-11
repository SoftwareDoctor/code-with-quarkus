package it.softwaredoctor.service;

import it.softwaredoctor.dto.BookDTO;
import it.softwaredoctor.model.Book;
import it.softwaredoctor.repository.BookRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class BookService {

    @Inject
    BookRepository bookRepository;

    public List<BookDTO> listAll() {
        return bookRepository
                .findAll()
                .stream()
                .map(BookDTO::fromEntity)
                .toList();
    }

    @Transactional
    public void create(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.title());
        book.setAuthor(bookDTO.author());
        bookRepository.persist(book);
    }
}
