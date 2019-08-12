package lesson_5;


import lesson_5.author.Author;
import lesson_5.author.AuthorRepo;
import lesson_5.author.AuthorRepoStorageImpl;
import lesson_5.book.Book;
import lesson_5.book.BookRepo;
import lesson_5.book.BookRepoStorageImpl;

public class Library {

    public void saveBook(Book book) {
        BookRepo bookRepo = new BookRepoStorageImpl();
        bookRepo.saveBook(book);
    }

    public void addAuthor(Author author) {
        AuthorRepo authorRepo = new AuthorRepoStorageImpl();
        authorRepo.saveAuthor(author);
    }

    public void printBooks() {
        for (int i = 0; i < Storage.books.length; i++) {
            Book book = Storage.books[i];
            if (book != null) {
                System.out.println(getBookAsStr(book));
            }
        }
    }

    public void printAuthors() {
        for (int i = 0; i < Storage.authors.length; i++) {
            Author author = Storage.authors[i];
            if (author != null) {
                System.out.println(getAuthorAsStr(author));
            }
        }
    }

    private String getBookAsStr(Book book) {
        return book.toString();
    }

    private String getAuthorAsStr(Author author) {
        return author.toString();
    }
}

