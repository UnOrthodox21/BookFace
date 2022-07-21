package com.rihards.bookface.repositories;

import com.rihards.bookface.entities.BorrowPeriodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowPeriodRepository extends JpaRepository<BorrowPeriodEntity, Long> {
}
