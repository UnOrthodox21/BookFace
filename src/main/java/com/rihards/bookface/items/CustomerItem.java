package com.rihards.bookface.items;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(builder = CustomerItem.Builder.class)
public class CustomerItem {

    private final String firstName;
    private final String lastName;
    private final int age;
    private final String address;
    private final String phone;
    private final String email;
    private final LocalDateTime dateAndTimeOfRegistration;
    private final List<BorrowPeriodItem> borrowPeriods;
    private final List<BookRequestItem> bookRequests;

    public CustomerItem(CustomerItem.Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.address = builder.address;
        this.phone = builder.phone;
        this.email = builder.email;
        this.dateAndTimeOfRegistration = builder.dateAndTimeOfRegistration;
        this.borrowPeriods = builder.borrowPeriods;
        this.bookRequests = builder.bookRequests;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getDateAndTimeOfRegistration() {
        return dateAndTimeOfRegistration;
    }

    public List<BorrowPeriodItem> getBorrowPeriods() {
        return borrowPeriods;
    }

    public List<BookRequestItem> getBookRequests() {
        return bookRequests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerItem that = (CustomerItem) o;
        return age == that.age && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(address, that.address) && Objects.equals(phone, that.phone) && Objects.equals(email, that.email) && Objects.equals(dateAndTimeOfRegistration, that.dateAndTimeOfRegistration) && Objects.equals(borrowPeriods, that.borrowPeriods) && Objects.equals(bookRequests, that.bookRequests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, address, phone, email, dateAndTimeOfRegistration, borrowPeriods, bookRequests);
    }

    @Override
    public String toString() {
        return "CustomerItem{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", dateAndTimeOfRegistration=" + dateAndTimeOfRegistration +
                ", borrowPeriods=" + borrowPeriods +
                ", bookRequests=" + bookRequests +
                '}';
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {
        private String firstName;
        private String lastName;
        private int age;
        private String address;
        private String phone;
        private String email;
        private LocalDateTime dateAndTimeOfRegistration;
        private List<BorrowPeriodItem> borrowPeriods;
        private List<BookRequestItem> bookRequests;

        public Builder() {
        }

        public CustomerItem.Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public CustomerItem.Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public CustomerItem.Builder age(int age) {
            this.age = age;
            return this;
        }

        public CustomerItem.Builder address(String address) {
            this.address = address;
            return this;
        }

        public CustomerItem.Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public CustomerItem.Builder email(String email) {
            this.email = email;
            return this;
        }

        public CustomerItem.Builder dateAndTimeOfRegistration(LocalDateTime dateAndTimeOfRegistration) {
            this.dateAndTimeOfRegistration = dateAndTimeOfRegistration;
            return this;
        }

        public CustomerItem.Builder borrowPeriods(List<BorrowPeriodItem> borrowPeriods) {
            this.borrowPeriods = borrowPeriods;
            return this;
        }

        public CustomerItem.Builder bookRequests(List<BookRequestItem> bookRequests) {
            this.bookRequests = bookRequests;
            return this;
        }

        public CustomerItem build() {
            return new CustomerItem(this);
        }

    }

}
