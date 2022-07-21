package com.rihards.bookface.items;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.List;
import java.util.Objects;

@JsonDeserialize(builder = BookItem.Builder.class)
public class BookItem {

    private final String author;
    private final String title;
    private final int year;
    private final int pages;
    private final List<BorrowPeriodItem> borrowPeriods;

    private BookItem(BookItem.Builder builder) {
        this.author = builder.author;
        this.title = builder.title;
        this.year = builder.year;
        this.pages = builder.year;
        this.borrowPeriods = builder.borrowPeriods;
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

    public List<BorrowPeriodItem> getBorrowPeriods() {
        return borrowPeriods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookItem bookItem = (BookItem) o;
        return year == bookItem.year && pages == bookItem.pages && Objects.equals(author, bookItem.author) && Objects.equals(title, bookItem.title) && Objects.equals(borrowPeriods, bookItem.borrowPeriods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, year, pages, borrowPeriods);
    }

    @Override
    public String toString() {
        return "BookItem{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", pages=" + pages +
                ", borrowPeriods=" + borrowPeriods +
                '}';
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {
        private String author;
        private String title;
        private int year;
        private int pages;
        private List<BorrowPeriodItem> borrowPeriods;

        public Builder() {
        }


        public BookItem.Builder author(String author) {
            this.author = author;
            return this;
        }

        public BookItem.Builder title(String title) {
            this.title = title;
            return this;
        }

        public BookItem.Builder year(int year) {
            this.year = year;
            return this;
        }

        public BookItem.Builder pages(int year) {
            this.pages = pages;
            return this;
        }

        public BookItem.Builder borrowPeriods(List<BorrowPeriodItem> borrowPeriods) {
            this.borrowPeriods = borrowPeriods;
            return this;
        }

        public BookItem build() {
            return new BookItem(this);
        }

    }

}
