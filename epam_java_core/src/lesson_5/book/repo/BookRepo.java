package lesson_5.book.repo;

import lesson_5.book.domain.Book;
import lesson_5.common.repo.BaseRepo;

import java.util.List;

public interface BookRepo extends BaseRepo<Book,Long> {
    Book[] findBooksByAuthorAsArray(long authorId);
    List<Book> findBooksByAuthorAsCollection(long authorId);
}
