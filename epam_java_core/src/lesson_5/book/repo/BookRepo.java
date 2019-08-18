package lesson_5.book.repo;

import lesson_5.book.Book;

public interface BookRepo {
    Long add(Book book);
    void print();
    int count();
    //void getBooksSortedByName();
    void delete(Book book);
    Book[] findBooksByAuthor(Long id);
}
