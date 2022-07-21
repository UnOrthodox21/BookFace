package com.rihards.bookface.controllers;

import com.rihards.bookface.items.BorrowPeriodItem;
import com.rihards.bookface.services.BorrowPeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookface/borrow-periods")
public class BorrowPeriodController {

    private final BorrowPeriodService borrowPeriodService;

    @Autowired
    public BorrowPeriodController(BorrowPeriodService borrowPeriodService) {
        this.borrowPeriodService = borrowPeriodService;
    }

    @GetMapping
    public List<BorrowPeriodItem> getAllBorrowPeriods() {
        return borrowPeriodService.getAllBorrowPeriods();
    }

    @GetMapping("/{borrowPeriodId}")
    public Optional<BorrowPeriodItem> getBorrowPeriodByBorrowPeriodId(@PathVariable("borrowPeriodId") long borrowPeriodId) {
        return borrowPeriodService.getBorrowPeriodByBorrowPeriodId(borrowPeriodId);
    }

    @PostMapping
    public BorrowPeriodItem createBorrowPeriod(@RequestBody BorrowPeriodItem borrowPeriodItem) {
        return borrowPeriodService.createBorrowPeriod(borrowPeriodItem);
    }

    @DeleteMapping("/{borrowPeriodId}")
    public void deleteBorrowPeriodById(@PathVariable("borrowPeriodId") long borrowPeriodId) {
        borrowPeriodService.deleteBorrowPeriodById(borrowPeriodId);
    }

    @PutMapping("/{borrowPeriodId}")
    public BorrowPeriodItem updateBorrowPeriodById(@RequestBody BorrowPeriodItem borrowPeriodItem, @PathVariable("borrowPeriodId") long borrowPeriodId) {
        return borrowPeriodService.updateBorrowPeriodById(borrowPeriodId, borrowPeriodItem);
    }

}
