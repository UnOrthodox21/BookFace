package com.rihards.bookface.entities;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "book_requests")
public class BookRequestEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private CustomerEntity customer;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "pages", nullable = false)
    private int pages;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "creation_date_and_time", nullable = false)
    @CreationTimestamp
    private LocalDateTime creationDateAndTime;

    @Column(name = "end_date")
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
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
        BookRequestEntity that = (BookRequestEntity) o;
        return id == that.id && year == that.year && pages == that.pages && Objects.equals(customer, that.customer) && Objects.equals(author, that.author) && Objects.equals(title, that.title) && Objects.equals(status, that.status) && Objects.equals(creationDateAndTime, that.creationDateAndTime) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, author, title, year, pages, status, creationDateAndTime, endDate);
    }

    @Override
    public String toString() {
        return "BookRequestEntity{" +
                "id=" + id +
                ", customer=" + customer +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", pages=" + pages +
                ", status='" + status + '\'' +
                ", creationDateAndTime=" + creationDateAndTime +
                ", endDate=" + endDate +
                '}';
    }
}
