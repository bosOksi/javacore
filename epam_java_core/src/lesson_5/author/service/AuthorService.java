package lesson_5.author.service;

import lesson_5.author.domain.Author;

public interface AuthorService {
    Long add(Author author);
    void print();
    int count();
    //void getAuthorsSortedByLastName();
    void delete(Author author);
}
