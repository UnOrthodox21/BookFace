package com.rihards.bookface.items;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.time.LocalDateTime;
import java.util.Objects;

@JsonDeserialize(builder = CustomerItem.Builder.class)
public class CustomerItem {

    private final long id;
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String address;
    private final String phone;
    private final String email;
    private final LocalDateTime dateAndTimeOfRegistration;

    public CustomerItem(CustomerItem.Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.address = builder.address;
        this.phone = builder.phone;
        this.email = builder.email;
        this.dateAndTimeOfRegistration = builder.dateAndTimeOfRegistration;
    }

    public long getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerItem that = (CustomerItem) o;
        return age == that.age && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(address, that.address) && Objects.equals(phone, that.phone) && Objects.equals(email, that.email) && Objects.equals(dateAndTimeOfRegistration, that.dateAndTimeOfRegistration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, age, address, phone, email, dateAndTimeOfRegistration);
    }

    @Override
    public String toString() {
        return "CustomerItem{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", dateAndTimeOfRegistration=" + dateAndTimeOfRegistration +
                '}';
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {
        private long id;
        private String firstName;
        private String lastName;
        private int age;
        private String address;
        private String phone;
        private String email;
        private LocalDateTime dateAndTimeOfRegistration;

        public CustomerItem.Builder id(long id) {
            this.id = id;
            return this;
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

        public CustomerItem build() {
            return new CustomerItem(this);
        }

    }

}
