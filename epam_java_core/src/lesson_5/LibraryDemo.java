package lesson_5;

import lesson_5.author.*;
import lesson_5.author.domain.Author;
import lesson_5.author.repo.AuthorRepo;
import lesson_5.author.repo.AuthorRepoArrayImpl;
import lesson_5.author.repo.AuthorRepoCollectionImpl;
import lesson_5.author.service.AuthorService;
import lesson_5.author.service.AuthorServiceImpl;
import lesson_5.book.*;
import lesson_5.book.domain.PrintedBook;
import lesson_5.book.domain.WrittenBook;
import lesson_5.book.repo.BookRepo;
import lesson_5.book.repo.BookRepoArrayImpl;
import lesson_5.book.repo.BookRepoCollectionImpl;

public class LibraryDemo {
    /**
     *  When delete Author
     *
     *  Look for books where author present, and remove him from book
     *
     *  if (book.getAuthorCount == 0){
     *      dropBook()
     *  }
     *
     *
     * ----------
     * When delete book
     * Delete book from storage
     */
    public static void main(String[] args) {
        //String storageType = "arrays";
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
        initData(bookRepo, authorService);

        bookRepo.print();
        authorRepo.print();
    }

    private static void initData(BookRepo bookRepo, AuthorService authorService) {
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
        Author author = valueOf(inputAuthor);

        author.setBooks(new Book[]{book1, book2});
        book1.setAuthors(new Author[]{author});
        book2.setAuthors(new Author[]{author});

        bookRepo.add(book1);
        bookRepo.add(book2);

        authorService.add(author);

    }

    public static Book valueOfForHandWrittenBook(InputBook inputBook) {
        WrittenBook book = new WrittenBook();
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

    public static Author valueOf(InputAuthor inputAuthor) {
        Author author = new Author(null);
        author.setLastName(inputAuthor.getLastName());
        author.setYearOfBorn(inputAuthor.getYearOfBorn());
        return author;
    }
}
