package com.rihards.bookface.repositories;

import com.rihards.bookface.entities.BookRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRequestRepository extends JpaRepository<BookRequestEntity, Long> {
}
