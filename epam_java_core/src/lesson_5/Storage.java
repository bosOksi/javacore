package lesson_5;

import lesson_5.author.domain.Author;
import lesson_5.book.Book;

public final class Storage {

    public static final int CAPACITY = 10;

    public static Book[] books = new Book[CAPACITY];
    public static List<> = new
    public static Long bookId = 1L;
    public static Long authorId = 1L;
    public static int bookIndex = 0;
    public static int authorIndex = 0;

    private Storage() {
    }



    public static Author[] authors = new Author[CAPACITY];

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

    public static void addBook(Book book) {
        book.setId(bookId);
        if (bookIndex % (CAPACITY) == 0 && bookIndex != 0) {
            increaseBooksStorage();
        } else {
            books[bookIndex] = book;
        }
        increaseBookIndex();
        bookId++;
    }

    public static void addAuthor(Author author) {
        author.setId(authorId);
        if (authorIndex % (CAPACITY) == 0 && authorIndex != 0) {
            increaseAuthorsStorage();
        } else {
            authors[authorIndex] = author;
        }
        increaseAuthorIndex();
        authorId++;
    }

    public static void removeBook(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (book.getId().equals(books[i].getId())) {
                books[i] = null;
                bookIndex--;
                break;
            }
        }
        Book[] newBooks = new Book[books.length];
        int index = 0;
        for (Book b: books) {
            if (b != null) {
                newBooks[index] = b;
                index++;
            }
        }
        books = newBooks;
    }

    public static void removeAuthor(Author author) {
        for (int i = 0; i < authors.length; i++) {
            if (author.getId().equals(authors[i].getId())) {
                authors[i] = null;
                authorIndex--;
                break;
            }
        }
        Author[] newAuthors = new Author[authors.length];
        int index = 0;
        for (Author a: authors) {
            if (a != null) {
                newAuthors[index] = a;
                index++;
            }
        }
        authors = newAuthors;
    }
}
