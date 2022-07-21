package com.rihards.bookface.services;

import com.rihards.bookface.entities.BookEntity;
import com.rihards.bookface.items.BookItem;
import com.rihards.bookface.mappers.BookMapper;
import com.rihards.bookface.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Autowired
    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public List<BookItem> getAllBooks() {

        List<BookEntity> allBookEntities = bookRepository.findAll();

        List<BookItem> allBookItems =  allBookEntities.stream()
                .map(bookEntity -> bookMapper.toBookItem(bookEntity))
                .collect(Collectors.toList());

        return allBookItems;
    }

    public Optional<BookItem> getBookByBookId(long bookId) {

        Optional<BookEntity> foundBookEntity = bookRepository.findById(bookId);
        BookItem foundBookItem = bookMapper.toBookItem(foundBookEntity.get());
        return Optional.of(foundBookItem);
    }

    public BookItem createBook(BookItem bookItem) {
        BookEntity bookEntity = bookMapper.toBookEntity(bookItem);
        BookEntity savedBookEntity = bookRepository.save(bookEntity);
        BookItem savedBookItem = bookMapper.toBookItem(savedBookEntity);
        return savedBookItem;
    }

    public void deleteBookById(long bookId) {
        bookRepository.deleteById(bookId);
    }

    public BookItem updateBookById(long bookId, BookItem bookItem) {
        BookEntity bookEntityToUpdate = bookRepository.findById(bookId).get();

        if(bookItem.getAuthor() != "") {
            bookEntityToUpdate.setAuthor(bookItem.getAuthor());
        }

        if(bookItem.getTitle() != "") {
            bookEntityToUpdate.setTitle(bookItem.getTitle());
        }

        if(bookItem.getYear() > 0) {
            bookEntityToUpdate.setYear(bookItem.getYear());
        }

       BookEntity savedBookEntity = bookRepository.save(bookEntityToUpdate);

       BookItem savedBookItem = bookMapper.toBookItem(savedBookEntity);

       return savedBookItem;
    }

}
