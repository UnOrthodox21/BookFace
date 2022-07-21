package com.rihards.bookface.services;

import com.rihards.bookface.entities.BookRequestEntity;
import com.rihards.bookface.entities.CustomerEntity;
import com.rihards.bookface.items.BookRequestItem;
import com.rihards.bookface.mappers.BookRequestMapper;
import com.rihards.bookface.mappers.CustomerMapper;
import com.rihards.bookface.repositories.BookRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookRequestService {

    private final BookRequestRepository bookRequestRepository;
    private final BookRequestMapper bookRequestMapper;
    private final CustomerMapper customerMapper;

    @Autowired
    public BookRequestService(BookRequestRepository bookRequestRepository, BookRequestMapper bookRequestMapper,
                              CustomerMapper customerMapper) {
        this.bookRequestRepository = bookRequestRepository;
        this.bookRequestMapper = bookRequestMapper;
        this.customerMapper = customerMapper;
    }

    public List<BookRequestItem> getAllBookRequests() {

        List<BookRequestEntity> allBookRequestEntities = bookRequestRepository.findAll();

        List<BookRequestItem> allBooKRequestItems =  allBookRequestEntities.stream()
                .map(bookRequestEntity -> bookRequestMapper.toBookRequestItem(bookRequestEntity))
                .collect(Collectors.toList());

        return allBooKRequestItems;
    }

    public Optional<BookRequestItem> getBookRequestByBookRequestId(long bookRequestId) {

        Optional<BookRequestEntity> foundBookRequestEntity = bookRequestRepository.findById(bookRequestId);
        BookRequestItem foundBookRequestItem = bookRequestMapper.toBookRequestItem(foundBookRequestEntity.get());
        return Optional.of(foundBookRequestItem);
    }

    public BookRequestItem createBookRequest(BookRequestItem bookRequestItem) {
        BookRequestEntity bookRequestEntity = bookRequestMapper.toBookRequestEntity(bookRequestItem);
        BookRequestEntity savedBookRequestEntity = bookRequestRepository.save(bookRequestEntity);
        BookRequestItem savedBookRequestItem = bookRequestMapper.toBookRequestItem(savedBookRequestEntity);
        return savedBookRequestItem;
    }

    public void deleteBookRequestById(long bookRequestId) {
        bookRequestRepository.deleteById(bookRequestId);
    }

    public BookRequestItem updateBookRequestById(long bookRequestId, BookRequestItem bookRequestItem) {
        BookRequestEntity bookRequestEntityToUpdate = bookRequestRepository.findById(bookRequestId).get();


        if(bookRequestItem.getCustomer() != null) {
            CustomerEntity customerEntity = customerMapper.toCustomerEntity(bookRequestItem.getCustomer());
            bookRequestEntityToUpdate.setCustomer(customerEntity);
        }

        if(bookRequestItem.getAuthor() != "") {
            bookRequestEntityToUpdate.setAuthor(bookRequestItem.getAuthor());
        }

        if(bookRequestItem.getTitle() != "") {
            bookRequestEntityToUpdate.setTitle(bookRequestItem.getTitle());
        }

        if(bookRequestItem.getYear() > 0) {
            bookRequestEntityToUpdate.setYear(bookRequestItem.getYear());
        }

        if(bookRequestItem.getPages() > 0) {
            bookRequestEntityToUpdate.setPages(bookRequestItem.getPages());
        }

        if(bookRequestItem.getStatus() != "") {
            bookRequestEntityToUpdate.setStatus(bookRequestItem.getStatus());
        }

        if(bookRequestItem.getCreationDateAndTime() != null) {
            bookRequestEntityToUpdate.setCreationDateAndTime(bookRequestItem.getCreationDateAndTime());
        }

        if(bookRequestItem.getEndDate() != null) {
            bookRequestEntityToUpdate.setEndDate(bookRequestItem.getEndDate());
        }

        BookRequestEntity savedBookRequestEntity = bookRequestRepository.save(bookRequestEntityToUpdate);

        BookRequestItem savedBookRequestItem = bookRequestMapper.toBookRequestItem(savedBookRequestEntity);

        return savedBookRequestItem;
    }
}
