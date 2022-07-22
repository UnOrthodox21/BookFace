package com.rihards.bookface.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "books")
public class BookEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "publishing_year", nullable = false)
    private int publishingYear;

    @Column(name = "pages", nullable = false)
    private int pages;

    @OneToMany(mappedBy="book", cascade = CascadeType.MERGE)
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
        return id == that.id && publishingYear == that.publishingYear && pages == that.pages && Objects.equals(author, that.author) && Objects.equals(title, that.title) && Objects.equals(borrowPeriods, that.borrowPeriods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, title, publishingYear, pages, borrowPeriods);
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", publishingYear=" + publishingYear +
                ", pages=" + pages +
                ", borrowPeriods=" + borrowPeriods +
                '}';
    }
}
