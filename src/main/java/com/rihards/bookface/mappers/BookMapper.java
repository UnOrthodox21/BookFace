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

        List<BorrowPeriodEntity> borrowPeriodEntityList = bookEntity.getBorrowPeriods();
        List<BorrowPeriodItem> borrowPeriodItemList = borrowPeriodEntityList.stream()
                .map(borrowPeriodEntity -> borrowPeriodMapper.toBorrowPeriodItem(borrowPeriodEntity))
                .collect(Collectors.toList());

        return new BookItem.Builder()
                .author(bookEntity.getAuthor())
                .title(bookEntity.getTitle())
                .year(bookEntity.getYear())
                .pages(bookEntity.getPages())
                .borrowPeriods(borrowPeriodItemList)
                .build();
    }


    public BookEntity toBookEntity(BookItem bookItem) {

        if (bookItem == null) {
            return null;
        }

        List<BorrowPeriodItem> borrowPeriodItemList = bookItem.getBorrowPeriods();
        List<BorrowPeriodEntity> borrowPeriodsEntityList = borrowPeriodItemList.stream()
                .map(borrowPeriodItem -> borrowPeriodMapper.toBorrowPeriodEntity(borrowPeriodItem))
                .collect(Collectors.toList());


        BookEntity bookEntity = new BookEntity();

        bookEntity.setAuthor(bookItem.getAuthor());
        bookEntity.setTitle(bookItem.getTitle());
        bookEntity.setYear(bookItem.getYear());
        bookEntity.setPages(bookItem.getPages());
        bookEntity.setBorrowPeriods(borrowPeriodsEntityList);

        return bookEntity;
    }

}
