package lesson_5.book.repo;

import lesson_5.book.Book;

import java.util.List;

public interface BookRepo {
    Long add(Book book);
    void print();
    int count();
    void delete(Book book);
    Book[] findBooksByAuthorAsArray(long authorId);
    List<Book> findBooksByAuthorAsCollection(long authorId);
    //Book[] getBooksAsArraySortedByName();
    //Book<> getBooksAsArraySortedByName();
}
