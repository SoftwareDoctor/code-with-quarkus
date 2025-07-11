package it.softwaredoctor.dto;

import it.softwaredoctor.model.Book;

import lombok.Builder;

@Builder
public record BookDTO(
        String title,
        String author
) {

    public static BookDTO fromEntity(Book book) {
        return BookDTO.builder()
                .title(book.getTitle())
                .author(book.getAuthor())
                .build();
    }
}
