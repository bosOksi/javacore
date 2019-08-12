package lesson_5.book;

import lesson_5.Storage;

import static lesson_5.Storage.*;
import static lesson_5.Storage.books;

public class BookRepoStorageImpl implements BookRepo {

    @Override
    public void saveBook(Book book) {
        book.setId(System.currentTimeMillis());
        if (bookIndex % (CAPACITY) == 0 && bookIndex != 0) {
            increaseBooksStorage();
        } else {
            books[bookIndex] = book;
        }
        increaseBookIndex();
    }


    //почитать про метод сравнени строк equals
    @Override
    public void searchBook(Book book) {
        for (int i = 0; i< books.length; i++) {
            if (book.equals(books[i])) {
                System.out.println("The book " + book + " is in storage");
            } else {
                System.out.println("The book " + book + " is not found in storage");
            }
        }
    }

    @Override
    public int getCountOfBooks() {
        return books.length;
    }

    @Override
    public void getBooksSortedByName() {

    }

    @Override
    public void removeBook(Book book) {

    }
}
