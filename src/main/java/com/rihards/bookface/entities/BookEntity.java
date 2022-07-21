package com.rihards.bookface.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "books")
public class BookEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "pages", nullable = false)
    private int pages;

    @OneToMany(mappedBy="book")
    private List<BorrowPeriodEntity> borrowPeriods;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<BorrowPeriodEntity> getBorrowPeriods() {
        return borrowPeriods;
    }

    public void setBorrowPeriods(List<BorrowPeriodEntity> borrowPeriods) {
        this.borrowPeriods = borrowPeriods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return id == that.id && year == that.year && pages == that.pages && Objects.equals(author, that.author) && Objects.equals(title, that.title) && Objects.equals(borrowPeriods, that.borrowPeriods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, title, year, pages, borrowPeriods);
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", pages=" + pages +
                ", borrowPeriods=" + borrowPeriods +
                '}';
    }
}
