package lesson_5.author.repo;

import lesson_5.author.domain.Author;

public interface AuthorRepo {
    Long add(Author author);
    void print();
    int count();
    void delete(Author author);
    //Author[] getAuthorsAsArraySortedByLastName();
    //Author<> getAuthorsAsArraySortedByLastName();
}
