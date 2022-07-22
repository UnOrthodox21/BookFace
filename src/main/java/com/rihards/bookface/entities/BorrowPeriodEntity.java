package com.rihards.bookface.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "borrow_periods")
public class BorrowPeriodEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id", nullable=false)
    private CustomerEntity customer;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="book_id", nullable=false)
    private BookEntity book;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "creation_date_and_time", nullable = false)
    @CreationTimestamp
    private LocalDateTime creationDateAndTime;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreationDateAndTime() {
        return creationDateAndTime;
    }

    public void setCreationDateAndTime(LocalDateTime creationDateAndTime) {
        this.creationDateAndTime = creationDateAndTime;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BorrowPeriodEntity that = (BorrowPeriodEntity) o;
        return id == that.id && Objects.equals(customer, that.customer) && Objects.equals(book, that.book) && Objects.equals(status, that.status) && Objects.equals(creationDateAndTime, that.creationDateAndTime) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, book, status, creationDateAndTime, startDate, endDate);
    }

    @Override
    public String toString() {
        return "BorrowPeriodEntity{" +
                "id=" + id +
                ", customer=" + customer +
                ", book=" + book +
                ", status='" + status + '\'' +
                ", creationDateAndTime=" + creationDateAndTime +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
