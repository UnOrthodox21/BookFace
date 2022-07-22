package com.rihards.bookface.mappers;

import com.rihards.bookface.entities.BookEntity;
import com.rihards.bookface.entities.BorrowPeriodEntity;
import com.rihards.bookface.items.BookItem;
import com.rihards.bookface.items.BorrowPeriodItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    private final BorrowPeriodMapper borrowPeriodMapper;

    @Autowired
    public BookMapper(@Lazy BorrowPeriodMapper borrowPeriodMapper) {
        this.borrowPeriodMapper = borrowPeriodMapper;
    }

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

        bookEntity.setAuthor(bookItem.getAuthor());
        bookEntity.setTitle(bookItem.getTitle());
        bookEntity.setPublishingYear(bookItem.getPublishingYear());
        bookEntity.setPages(bookItem.getPages());


        return bookEntity;
    }

}
