package com.rihards.bookface.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "customers")
public class CustomerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "date_of_registration", nullable = false)
    @CreationTimestamp
    private LocalDateTime dateAndTimeOfRegistration;

    @OneToMany(mappedBy="customer", cascade = CascadeType.MERGE)
    private List<BorrowPeriodEntity> borrowPeriods;

    @OneToMany(mappedBy="customer", cascade = CascadeType.MERGE)
    private List<BookRequestEntity> bookRequests;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDateOfRegistration() {
        return dateAndTimeOfRegistration;
    }

    public void setDateAndTimeOfRegistration(LocalDateTime dateAndTimeOfRegistration) {
        this.dateAndTimeOfRegistration = dateAndTimeOfRegistration;
    }

    public List<BorrowPeriodEntity> getBorrowPeriods() {
        return borrowPeriods;
    }

    public void setBorrowPeriods(List<BorrowPeriodEntity> borrowPeriods) {
        this.borrowPeriods = borrowPeriods;
    }

    public List<BookRequestEntity> getBookRequests() {
        return bookRequests;
    }

    public void setBookRequests(List<BookRequestEntity> bookRequests) {
        this.bookRequests = bookRequests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return id == that.id && age == that.age && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(address, that.address) && Objects.equals(phone, that.phone) && Objects.equals(email, that.email) && Objects.equals(dateAndTimeOfRegistration, that.dateAndTimeOfRegistration) && Objects.equals(borrowPeriods, that.borrowPeriods) && Objects.equals(bookRequests, that.bookRequests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, age, address, phone, email, dateAndTimeOfRegistration, borrowPeriods, bookRequests);
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
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
}
