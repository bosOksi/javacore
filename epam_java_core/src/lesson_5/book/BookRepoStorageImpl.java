package lesson_5.book;

import lesson_5.Storage;

import java.util.Comparator;

import static java.lang.Character.toLowerCase;
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

    @Override
    public int getCountOfBooks() {
        int count = books.length;
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                count -= 1;
            }
        }
        return count;
    }

    @Override
    public void searchBook(Book book) {
        for (int i = 0; i < books.length; i++) {
            boolean isInStorage = false;
            if (book.equals(books[i])) {
                System.out.println("The book " + book + " is in storage");
                isInStorage = true;
            } else {
                if (isInStorage) {
                    System.out.println("The book " + book + " is not found in storage");
                }
            }
        }
    }

    @Override
    public void getBooksSortedByName() {
        /*for (int i = 0; i< books.length;i++) {
            for (int j=1; j < books[i].name.length(); j++) {
                Character letterOfBookName = (Character)books[i].name.charAt(j);
                Character letterOfBookNameInLowerCase = toLowerCase(letterOfBookName);
                Character[] lettersOfBookNameInLowerCase = new Character[books[i].name.length()];
                lettersOfBookNameInLowerCase.add();
                if (letterOfBookNameInLowerCase.charValue()< letterOfBookNameInLowerCase.charValue()[i - 1]);
            }
        }*/

        System.out.println("Books sorted by name");
    }


    @Override
    public void removeBook(Book book) {
        int j=0;
        for (int i = 0; i < books.length; i++) {
            if (book.equals(books[i])) {
                books[i] = null;
                System.out.println("The book " + book + " removed from storage");
                j += 1;
            }
        }
        if (j==0) {
            System.out.println("The book " + book + " is not found in storage");
        }
    }
}
