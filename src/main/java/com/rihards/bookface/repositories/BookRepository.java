package com.rihards.bookface.repositories;

import com.rihards.bookface.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
