package com.rihards.bookface.mappers;

import com.rihards.bookface.entities.BookEntity;
import com.rihards.bookface.items.BookItem;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public BookItem toBookItem(BookEntity bookEntity) {

        if (bookEntity == null) {
            return null;
        }

        return new BookItem.Builder()
                .id(bookEntity.getId())
                .author(bookEntity.getAuthor())
                .title(bookEntity.getTitle())
                .publishingYear(bookEntity.getPublishingYear())
                .pages(bookEntity.getPages())
                .build();
    }


    public BookEntity toBookEntity(BookItem bookItem) {

        if (bookItem == null) {
            return null;
        }

        BookEntity bookEntity = new BookEntity();

        bookEntity.setId(bookItem.getId());
        bookEntity.setAuthor(bookItem.getAuthor());
        bookEntity.setTitle(bookItem.getTitle());
        bookEntity.setPublishingYear(bookItem.getPublishingYear());
        bookEntity.setPages(bookItem.getPages());

        return bookEntity;
    }

}
