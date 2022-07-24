package com.rihards.bookface.services;

import com.rihards.bookface.entities.BookEntity;
import com.rihards.bookface.entities.BorrowPeriodEntity;
import com.rihards.bookface.entities.CustomerEntity;
import com.rihards.bookface.items.BookItem;
import com.rihards.bookface.items.BorrowPeriodItem;
import com.rihards.bookface.items.CustomerItem;
import com.rihards.bookface.mappers.BookMapper;
import com.rihards.bookface.mappers.BorrowPeriodMapper;
import com.rihards.bookface.mappers.CustomerMapper;
import com.rihards.bookface.repositories.BorrowPeriodRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class BorrowPeriodServiceTest {

    @Mock
    private BorrowPeriodRepository borrowPeriodRepository;

    @Mock
    private BorrowPeriodMapper borrowPeriodMapper;

    @Mock
    private BookMapper bookMapper;

    @Mock
    private CustomerMapper customerMapper;

    @InjectMocks
    BorrowPeriodService borrowPeriodService;

    BorrowPeriodEntity borrowPeriodEntity = new BorrowPeriodEntity();
    BorrowPeriodItem borrowPeriodItem = new BorrowPeriodItem.Builder().build();


    @BeforeEach
    public void setup() {
        borrowPeriodEntity = getBorrowPeriodEntity();
        borrowPeriodItem = getBorrowPeriodItem();
    }

    @Test
    void testGetAllBorrowPeriods() {

        List<BorrowPeriodEntity> borrowPeriodEntityList = new ArrayList<BorrowPeriodEntity>();
        borrowPeriodEntityList.add(borrowPeriodEntity);

        // Mock
        when(borrowPeriodRepository.findAll()).thenReturn(borrowPeriodEntityList);
        when(borrowPeriodMapper.toBorrowPeriodEntity(borrowPeriodItem)).thenReturn(borrowPeriodEntity);
        when(borrowPeriodMapper.toBorrowPeriodItem(borrowPeriodEntity)).thenReturn(borrowPeriodItem);

        // Perform
        List<BorrowPeriodItem> foundBorrowPeriodItemList = borrowPeriodService.getAllBorrowPeriods();
        BorrowPeriodItem firstFoundBorrowPeriodItem = foundBorrowPeriodItemList.get(0);

        // Assert
        assert (foundBorrowPeriodItemList.size() == 1);
        assert (firstFoundBorrowPeriodItem.getId() == borrowPeriodItem.getId());
        assert (firstFoundBorrowPeriodItem.getStatus()).equals(borrowPeriodItem.getStatus());
        assert (firstFoundBorrowPeriodItem.getStartDate()).equals(borrowPeriodItem.getStartDate());
        assert (firstFoundBorrowPeriodItem.getEndDate()).equals(borrowPeriodItem.getEndDate());
        assert (firstFoundBorrowPeriodItem.getCreationDateAndTime() == borrowPeriodItem.getCreationDateAndTime());
        assert (firstFoundBorrowPeriodItem.getBook().getId() == borrowPeriodItem.getBook().getId());
        assert (firstFoundBorrowPeriodItem.getCustomer().getId() == borrowPeriodItem.getCustomer().getId());

    }

    @Test
    void testGetBorrowPeriodByBorrowPeriodId() {

        // Mock
        when(borrowPeriodRepository.findById(borrowPeriodEntity.getId())).thenReturn(Optional.of(borrowPeriodEntity));
        when(borrowPeriodMapper.toBorrowPeriodEntity(borrowPeriodItem)).thenReturn(borrowPeriodEntity);
        when(borrowPeriodMapper.toBorrowPeriodItem(borrowPeriodEntity)).thenReturn(borrowPeriodItem);
        when(customerMapper.toCustomerEntity(any(CustomerItem.class))).thenReturn(new CustomerEntity());
        when(customerMapper.toCustomerItem(any(CustomerEntity.class))).thenReturn(new CustomerItem.Builder().build());
        when(bookMapper.toBookEntity(any(BookItem.class))).thenReturn(new BookEntity());
        when(bookMapper.toBookItem(any(BookEntity.class))).thenReturn(new BookItem.Builder().build());

        // Perform
        Optional<BorrowPeriodItem> foundBorrowPeriodItem = borrowPeriodService.getBorrowPeriodByBorrowPeriodId(borrowPeriodEntity.getId());

        // Assert
        assert (foundBorrowPeriodItem.get().getId() == borrowPeriodItem.getId());
        assert (foundBorrowPeriodItem.get().getStartDate()).equals(borrowPeriodItem.getStartDate());
        assert (foundBorrowPeriodItem.get().getEndDate()).equals(borrowPeriodItem.getEndDate());
        assert (foundBorrowPeriodItem.get().getCreationDateAndTime()).equals(borrowPeriodItem.getCreationDateAndTime());
        assert (foundBorrowPeriodItem.get().getStatus()).equals(borrowPeriodItem.getStatus());
        assert (foundBorrowPeriodItem.get().getBook()).equals(borrowPeriodItem.getBook());
        assert (foundBorrowPeriodItem.get().getCustomer()).equals(borrowPeriodItem.getCustomer());

        // Verify
        verify(borrowPeriodRepository, times(1)).findById(borrowPeriodEntity.getId());
    }

    @Test
    void testCreateBorrowPeriod() {

        // Mock
        when(borrowPeriodRepository.save(borrowPeriodEntity)).thenReturn(borrowPeriodEntity);
        when(borrowPeriodMapper.toBorrowPeriodEntity(borrowPeriodItem)).thenReturn(borrowPeriodEntity);
        when(borrowPeriodMapper.toBorrowPeriodItem(borrowPeriodEntity)).thenReturn(borrowPeriodItem);

        // Perform
        BorrowPeriodItem createdBorrowPeriodItem = borrowPeriodService.createBorrowPeriod(borrowPeriodItem);

        // Assert
        assert (createdBorrowPeriodItem.getStatus()).equals(borrowPeriodItem.getStatus());

        // Verify
        verify(borrowPeriodRepository, times(1)).save(borrowPeriodEntity);

    }

    @Test
    void testDeleteBorrowPeriodById() {

        // Perform
        borrowPeriodService.deleteBorrowPeriodById(borrowPeriodEntity.getId());

        // Verify
        verify(borrowPeriodRepository, times(1)).deleteById(borrowPeriodEntity.getId());

    }

    @Test
    void testUpdateBorrowPeriodById() {
        // Mock
        when(borrowPeriodRepository.findById(borrowPeriodEntity.getId())).thenReturn(Optional.of(borrowPeriodEntity));
        when(borrowPeriodRepository.save(borrowPeriodEntity)).thenReturn(borrowPeriodEntity);
        when(borrowPeriodMapper.toBorrowPeriodEntity(borrowPeriodItem)).thenReturn(borrowPeriodEntity);
        when(borrowPeriodMapper.toBorrowPeriodItem(borrowPeriodEntity)).thenReturn(borrowPeriodItem);


        // Perform
        BorrowPeriodItem updatedBorrowPeriodItem = borrowPeriodService.updateBorrowPeriodById(borrowPeriodItem.getId(), borrowPeriodItem);

        // Assert
        assert (updatedBorrowPeriodItem.getStatus()).equals(borrowPeriodItem.getStatus());

        // Verify
        verify(borrowPeriodRepository, times(1)).save(borrowPeriodEntity);

    }


    // Helper functions

    private BorrowPeriodEntity getBorrowPeriodEntity() {
        BorrowPeriodEntity borrowPeriodEntity = new BorrowPeriodEntity();
        borrowPeriodEntity.setId(6L);
        borrowPeriodEntity.setCustomer(new CustomerEntity());
        borrowPeriodEntity.setBook(new BookEntity());
        borrowPeriodEntity.setStatus("TEST STATUS");
        borrowPeriodEntity.setCreationDateAndTime(LocalDateTime.now());
        borrowPeriodEntity.setStartDate(LocalDate.now());

        return borrowPeriodEntity;
    }

    private BorrowPeriodItem getBorrowPeriodItem() {
        return new BorrowPeriodItem
                .Builder()
                .id(6L)
                .customer(new CustomerItem.Builder().build())
                .book(new BookItem.Builder().build())
                .status("TEST STATUS")
                .creationDateAndTime(LocalDateTime.now())
                .startDate(LocalDate.now())
                .endDate(LocalDate.now())
                .build();
    }

}
