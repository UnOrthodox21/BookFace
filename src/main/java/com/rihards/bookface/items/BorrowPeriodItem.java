package com.rihards.bookface.items;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@JsonDeserialize(builder = BorrowPeriodItem.Builder.class)
public class BorrowPeriodItem {

    private final CustomerItem customer;
    private final BookItem book;
    private final String status;
    private final LocalDateTime creationDateAndTime;
    private final LocalDate startDate;
    private final LocalDate endDate;


    public BorrowPeriodItem(BorrowPeriodItem.Builder builder) {
        this.customer = builder.customer;
        this.book = builder.book;
        this.status = builder.status;
        this.creationDateAndTime = builder.creationDateAndTime;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
    }

    public CustomerItem getCustomer() {
        return customer;
    }

    public BookItem getBook() {
        return book;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreationDateAndTime() {
        return creationDateAndTime;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BorrowPeriodItem that = (BorrowPeriodItem) o;
        return Objects.equals(customer, that.customer) && Objects.equals(book, that.book) && Objects.equals(status, that.status) && Objects.equals(creationDateAndTime, that.creationDateAndTime) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, book, status, creationDateAndTime, startDate, endDate);
    }

    @Override
    public String toString() {
        return "BorrowPeriodItem{" +
                "customer=" + customer +
                ", book=" + book +
                ", status='" + status + '\'' +
                ", creationDateAndTime=" + creationDateAndTime +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {
        private CustomerItem customer;
        private BookItem book;
        private String status;
        private LocalDateTime creationDateAndTime;
        private LocalDate startDate;
        private LocalDate endDate;

        public Builder() {
        }

        public BorrowPeriodItem.Builder customer(CustomerItem customer) {
            this.customer = customer;
            return this;
        }

        public BorrowPeriodItem.Builder book(BookItem book) {
            this.book = book;
            return this;
        }

        public BorrowPeriodItem.Builder status(String status) {
            this.status = status;
            return this;
        }

        public BorrowPeriodItem.Builder creationDateAndTime(LocalDateTime creationDateAndTime) {
            this.creationDateAndTime = creationDateAndTime;
            return this;
        }

        public BorrowPeriodItem.Builder startDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public BorrowPeriodItem.Builder endDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public BorrowPeriodItem build() {
            return new BorrowPeriodItem(this);
        }

    }

}
