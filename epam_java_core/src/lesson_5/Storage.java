package lesson_5;

import lesson_5.author.domain.Author;
import lesson_5.book.Book;

public final class Storage {

    public static final int CAPACITY = 10;
    public static Book[] books = new Book[CAPACITY];
    public static Author[] authors = new Author[CAPACITY];
    public static int bookIndex = 0;
    public static int authorIndex = 0;

    private Storage() {
    }

    public static void increaseBookIndex() {
        bookIndex++;
    }

    public static void increaseAuthorIndex() {
        authorIndex++;
    }

    public static void increaseAuthorsStorage() {
        Author[] authors = new Author[authorIndex + CAPACITY];
        System.arraycopy(Storage.authors, authorIndex, authors, authorIndex, CAPACITY);
    }

    public static void increaseBooksStorage() {
        Book[] books = new Book[bookIndex + CAPACITY];
        System.arraycopy(Storage.books, bookIndex, books, bookIndex, CAPACITY);
        Storage.books = books;
    }


}
