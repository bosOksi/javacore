package lesson_5.author;

public interface AuthorRepo {
    void saveAuthor(Author author);
    void searchAuthor(Author author);
    int getCountOfAuthor();
    void getAuthorSortedByLastName();
    void removeAuthor(Author author);
}
