package lesson_5;

import lesson_5.author.*;
import lesson_5.author.domain.Author;
import lesson_5.author.repo.AuthorRepo;
import lesson_5.author.repo.AuthorRepoArrayImpl;
import lesson_5.author.repo.AuthorRepoCollectionImpl;
import lesson_5.author.service.AuthorService;
import lesson_5.author.service.AuthorServiceImpl;
import lesson_5.book.*;
import lesson_5.book.domain.Book;
import lesson_5.book.domain.PrintedBook;
import lesson_5.book.domain.HandWrittenBook;
import lesson_5.book.repo.BookRepo;
import lesson_5.book.repo.BookRepoArrayImpl;
import lesson_5.book.repo.BookRepoCollectionImpl;
import lesson_5.book.service.BookService;
import lesson_5.book.service.BookServiceImpl;
import static lesson_5.common.utils.CollectionUtils.mutableCollectionOf;

public class LibraryDemo {

    public static void main(String[] args) {

        String storageType = "collection";
        BookRepo bookRepo = null;
        AuthorRepo authorRepo = null;

        if (storageType.equals("arrays")){
            bookRepo = new BookRepoArrayImpl();
            authorRepo = new AuthorRepoArrayImpl();
        }else if (storageType.equals("collection")){
            bookRepo = new BookRepoCollectionImpl();
            authorRepo = new AuthorRepoCollectionImpl();
        }

        AuthorService authorService = new AuthorServiceImpl(authorRepo,bookRepo);
        BookService bookService = new BookServiceImpl(bookRepo);
        initData(bookService, authorService);

        bookService.print();
        authorService.print();
    }

    private static void initData(BookService bookService, AuthorService authorService) {
        InputBook inputBook1 = new InputBook();
        inputBook1.setName("Evgeny Onegin");
        inputBook1.setPublishYear(1990);
        Book book1 = valueOfForHandWrittenBook(inputBook1);


        InputBook inputBook2 = new InputBook();
        inputBook2.setName("Ruslan i Ludmila");
        inputBook2.setPublishYear(1995);
        Book book2 = valueOfForPrintedBook(inputBook2);

        InputAuthor inputAuthor = new InputAuthor();
        inputAuthor.setLastName("Pushkin");
        inputAuthor.setYearOfBorn(1100);
        Author author = valueOfForHandWrittenBook(inputAuthor);

        author.setBooks(mutableCollectionOf(book1,book2));
        book1.setAuthors(mutableCollectionOf(author,author));
        book2.setAuthors(mutableCollectionOf(author));

        bookService.add(book1);
        bookService.add(book2);

        authorService.add(author);

    }

    public static Book valueOfForHandWrittenBook(InputBook inputBook) {
        HandWrittenBook book = new HandWrittenBook();
        book.setName(inputBook.getName());
        book.setPublishYear(inputBook.getPublishYear());
        book.setPaint(inputBook.getPaint());
        return book;
    }

    public static Book valueOfForPrintedBook(InputBook inputBook) {
        PrintedBook book = new PrintedBook();
        book.setName(inputBook.getName());
        book.setPublishYear(inputBook.getPublishYear());
        book.setFontFamily(inputBook.getFontFamily());
        return book;
    }

    public static Author valueOfForHandWrittenBook(InputAuthor inputAuthor) {
        Author author = new Author(null);
        author.setLastName(inputAuthor.getLastName());
        author.setYearOfBorn(inputAuthor.getYearOfBorn());
        return author;
    }
}
