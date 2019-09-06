package lesson_5.book.service;

import lesson_5.book.domain.Book;
import lesson_5.common.service.BaseService;

import java.util.List;

public interface BookService extends BaseService<Book,Long> {
    Book[] findBooksByAuthorAsArray(long authorId);
    List<Book> findBooksByAuthorAsCollection(long authorId);
}
