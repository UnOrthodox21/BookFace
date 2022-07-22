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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id")
    private CustomerEntity customer;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "publishing_year", nullable = false)
    private int publishingYear;

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

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
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
        return id == that.id && publishingYear == that.publishingYear && pages == that.pages && Objects.equals(customer, that.customer) && Objects.equals(author, that.author) && Objects.equals(title, that.title) && Objects.equals(status, that.status) && Objects.equals(creationDateAndTime, that.creationDateAndTime) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, author, title, publishingYear, pages, status, creationDateAndTime, endDate);
    }

    @Override
    public String toString() {
        return "BookRequestEntity{" +
                "id=" + id +
                ", customer=" + customer +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", publishingYear=" + publishingYear +
                ", pages=" + pages +
                ", status='" + status + '\'' +
                ", creationDateAndTime=" + creationDateAndTime +
                ", endDate=" + endDate +
                '}';
    }
}
