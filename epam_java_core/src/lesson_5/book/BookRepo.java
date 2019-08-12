package lesson_5.book;

public interface BookRepo {
    void saveBook(Book book);
    void searchBook(Book book);
    int getCountOfBooks();
    void getBooksSortedByName();
    void removeBook(Book book);
}
