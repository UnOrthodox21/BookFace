package com.rihards.bookface.items;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.Objects;

@JsonDeserialize(builder = BookItem.Builder.class)
public class BookItem {

    private final long id;
    private final String author;
    private final String title;
    private final int publishingYear;
    private final int pages;

    private BookItem(BookItem.Builder builder) {
        this.id = builder.id;
        this.author = builder.author;
        this.title = builder.title;
        this.publishingYear = builder.publishingYear;
        this.pages = builder.pages;
    }

    public long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookItem bookItem = (BookItem) o;
        return publishingYear == bookItem.publishingYear && publishingYear == bookItem.publishingYear && pages == bookItem.pages && Objects.equals(author, bookItem.author) && Objects.equals(title, bookItem.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, title, publishingYear, pages);
    }

    @Override
    public String toString() {
        return "BookItem{" +
                "id='" + id + '\'' +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", publishingYear=" + publishingYear +
                ", pages=" + pages +
                '}';
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {
        private long id;
        private String author;
        private String title;
        private int publishingYear;
        private int pages;

        public BookItem.Builder id(long id) {
            this.id = id;
            return this;
        }

        public BookItem.Builder author(String author) {
            this.author = author;
            return this;
        }

        public BookItem.Builder title(String title) {
            this.title = title;
            return this;
        }

        public BookItem.Builder publishingYear(int publishingYear) {
            this.publishingYear = publishingYear;
            return this;
        }

        public BookItem.Builder pages(int pages) {
            this.pages = pages;
            return this;
        }

        public BookItem build() {
            return new BookItem(this);
        }

    }

}
