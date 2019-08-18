package lesson_5.book.service;

import lesson_5.book.Book;

public interface BookService {
    Long add(Book book);
    void print();
    int count();
    //void getBooksSortedByName();
    void delete(Book book);
}
