package com.rihards.bookface.mappers;

import com.rihards.bookface.entities.BookEntity;
import com.rihards.bookface.items.BookItem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class BookMapperTest {

    @Mock
    BookMapper bookMapper;

    @Test
    void testToBookItem() {

        // setup
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(6L);
        bookEntity.setAuthor("Test Author");
        bookEntity.setTitle("Test book");
        bookEntity.setPublishingYear(1952);
        bookEntity.setPages(320);

        // Perform
        BookItem bookItem = bookMapper.toBookItem(bookEntity);

        // Verify
        assertThat(bookItem.getId()).isEqualTo(bookEntity.getId());
        assertThat(bookItem.getAuthor()).isEqualTo(bookEntity.getAuthor());
        assertThat(bookItem.getTitle()).isEqualTo(bookEntity.getTitle());
        assertThat(bookItem.getPublishingYear()).isEqualTo(bookEntity.getPublishingYear());
        assertThat(bookItem.getPages()).isEqualTo(bookEntity.getPages());

    }

    @Test
    void testToBookEntity() {

        BookItem bookItem = new BookItem.Builder()
                .id(6L)
                .author("Test Author")
                .title("Test Title")
                .publishingYear(1950)
                .pages(126)
                .build();

        // Perform
        BookEntity bookEntity = bookMapper.toBookEntity(bookItem);

        // Verify
        assertThat(bookEntity.getId()).isEqualTo(bookItem.getId());
        assertThat(bookEntity.getAuthor()).isEqualTo(bookItem.getAuthor());
        assertThat(bookEntity.getTitle()).isEqualTo(bookItem.getTitle());
        assertThat(bookEntity.getPublishingYear()).isEqualTo(bookItem.getPublishingYear());
        assertThat(bookEntity.getPages()).isEqualTo(bookItem.getPages());
    }

}
