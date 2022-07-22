package com.rihards.bookface.services;

import com.rihards.bookface.entities.BookEntity;
import com.rihards.bookface.entities.BorrowPeriodEntity;
import com.rihards.bookface.entities.CustomerEntity;
import com.rihards.bookface.items.BorrowPeriodItem;
import com.rihards.bookface.mappers.BookMapper;
import com.rihards.bookface.mappers.BorrowPeriodMapper;
import com.rihards.bookface.mappers.CustomerMapper;
import com.rihards.bookface.repositories.BorrowPeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BorrowPeriodService {

    private final BorrowPeriodRepository borrowPeriodRepository;
    private final BorrowPeriodMapper borrowPeriodMapper;
    private final BookMapper bookMapper;
    private final CustomerMapper customerMapper;

    @Autowired
    public BorrowPeriodService(BorrowPeriodRepository borrowPeriodRepository, BorrowPeriodMapper borrowPeriodMapper,
                               BookMapper bookMapper, CustomerMapper customerMapper) {
        this.borrowPeriodRepository = borrowPeriodRepository;
        this.borrowPeriodMapper = borrowPeriodMapper;
        this.bookMapper = bookMapper;
        this.customerMapper = customerMapper;
    }

    public List<BorrowPeriodItem> getAllBorrowPeriods() {

        List<BorrowPeriodEntity> allBorrowPeriodEntities = borrowPeriodRepository.findAll();

        List<BorrowPeriodItem> allBorrowPeriodItems =  allBorrowPeriodEntities.stream()
                .map(borrowPeriodEntity -> borrowPeriodMapper.toBorrowPeriodItem(borrowPeriodEntity))
                .collect(Collectors.toList());

        return allBorrowPeriodItems;
    }

    public Optional<BorrowPeriodItem> getBorrowPeriodByBorrowPeriodId(long borrowPeriodId) {

        Optional<BorrowPeriodEntity> foundBorrowPeriodEntity = borrowPeriodRepository.findById(borrowPeriodId);
        BorrowPeriodItem foundBorrowPeriodItem = borrowPeriodMapper.toBorrowPeriodItem(foundBorrowPeriodEntity.get());
        return Optional.of(foundBorrowPeriodItem);
    }

    public BorrowPeriodItem createBorrowPeriod(BorrowPeriodItem borrowPeriodItem) {
        BorrowPeriodEntity borrowPeriodEntity = borrowPeriodMapper.toBorrowPeriodEntity(borrowPeriodItem);
        BorrowPeriodEntity savedBookEntity = borrowPeriodRepository.save(borrowPeriodEntity);
        BorrowPeriodItem savedBorrowPeriodItem = borrowPeriodMapper.toBorrowPeriodItem(savedBookEntity);
        return savedBorrowPeriodItem;
    }

    public void deleteBorrowPeriodById(long borrowPeriodId) {
        borrowPeriodRepository.deleteById(borrowPeriodId);
    }

    public BorrowPeriodItem updateBorrowPeriodById(long borrowPeriodId, BorrowPeriodItem borrowPeriodItem) {
        BorrowPeriodEntity borrowPeriodEntityToUpdate = borrowPeriodRepository.findById(borrowPeriodId).get();

        if(borrowPeriodItem.getCreationDateAndTime() != null) {
            borrowPeriodEntityToUpdate.setCreationDateAndTime(borrowPeriodItem.getCreationDateAndTime());
        }

        if(!borrowPeriodItem.getStatus().equals("")) {
            borrowPeriodEntityToUpdate.setStatus(borrowPeriodItem.getStatus());
        }

        if(borrowPeriodItem.getStartDate() != null) {
            borrowPeriodEntityToUpdate.setStartDate(borrowPeriodItem.getStartDate());
        }

        if(borrowPeriodItem.getEndDate() != null) {
            borrowPeriodEntityToUpdate.setEndDate(borrowPeriodItem.getEndDate());
        }

        if(borrowPeriodItem.getBook() != null) {
            BookEntity bookEntity = bookMapper.toBookEntity(borrowPeriodItem.getBook());
            borrowPeriodEntityToUpdate.setBook(bookEntity);
        }

        if(borrowPeriodItem.getCustomer() != null) {
            CustomerEntity customerEntity = customerMapper.toCustomerEntity(borrowPeriodItem.getCustomer());
            borrowPeriodEntityToUpdate.setCustomer(customerEntity);
        }

        BorrowPeriodEntity savedBorrowPeriodEntity = borrowPeriodRepository.save(borrowPeriodEntityToUpdate);

        BorrowPeriodItem savedBorrowPeriodItem = borrowPeriodMapper.toBorrowPeriodItem(savedBorrowPeriodEntity);

        return savedBorrowPeriodItem;
    }

}
