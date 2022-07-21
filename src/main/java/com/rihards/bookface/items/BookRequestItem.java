package com.rihards.bookface.items;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@JsonDeserialize(builder = BookRequestItem.Builder.class)
public class BookRequestItem {

    private final CustomerItem customer;
    private final String author;
    private final String title;
    private final int year;
    private final int pages;
    private final String status;
    private final LocalDateTime creationDateAndTime;
    private final LocalDate endDate;

    private BookRequestItem(BookRequestItem.Builder builder) {
        this.customer = builder.customer;
        this.author = builder.author;
        this.title = builder.title;
        this.year = builder.year;
        this.pages = builder.pages;
        this.status = builder.status;
        this.creationDateAndTime = builder.creationDateAndTime;
        this.endDate = builder.endDate;
    }

    public CustomerItem getCustomer() {
        return customer;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getPages() {
        return pages;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreationDateAndTime() {
        return creationDateAndTime;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookRequestItem that = (BookRequestItem) o;
        return year == that.year && pages == that.pages && Objects.equals(customer, that.customer) && Objects.equals(author, that.author) && Objects.equals(title, that.title) && Objects.equals(status, that.status) && Objects.equals(creationDateAndTime, that.creationDateAndTime) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, author, title, year, pages, status, creationDateAndTime, endDate);
    }

    @Override
    public String toString() {
        return "BookRequestItem{" +
                "customer=" + customer +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", pages=" + pages +
                ", status='" + status + '\'' +
                ", creationDateAndTime=" + creationDateAndTime +
                ", endDate=" + endDate +
                '}';
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {
        private CustomerItem customer;
        private String author;
        private String title;
        private int year;
        private int pages;
        private String status;
        private LocalDateTime creationDateAndTime;
        private LocalDate endDate;

        public Builder() {
        }

        public BookRequestItem.Builder customer(CustomerItem customer) {
            this.customer = customer;
            return this;
        }

        public BookRequestItem.Builder author(String author) {
            this.author = author;
            return this;
        }

        public BookRequestItem.Builder title(String title) {
            this.title = title;
            return this;
        }

        public BookRequestItem.Builder year(int year) {
            this.year = year;
            return this;
        }

        public BookRequestItem.Builder pages(int pages) {
            this.pages = pages;
            return this;
        }

        public BookRequestItem.Builder status(String status) {
            this.status = status;
            return this;
        }

        public BookRequestItem.Builder creationDateAndTime(LocalDateTime creationDateAndTime) {
            this.creationDateAndTime = creationDateAndTime;
            return this;
        }

        public BookRequestItem.Builder endDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public BookRequestItem build() {
            return new BookRequestItem(this);
        }

    }

}
