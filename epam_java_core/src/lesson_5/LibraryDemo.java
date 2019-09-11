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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static lesson_5.common.utils.CollectionUtils.mutableCollectionOf;

public class LibraryDemo {

    public static void main(String[] args) {
        //initData(InitType.FROM_MEMORY);
        initData(InitType.FROM_FILE);
    }

    public static void initData(InitType initType) {
        switch (initType) {
            case FROM_FILE:
                try {
                    List<String> strings = readFile("C:\\Users\\Oksana\\Desktop\\Library.txt");
                    int isBook = -1;
                    for (String line : strings) {
                        if (line.contains("Entity: Book")) {
                            isBook = 1;
                        } else if (line.contains("Entity: Author")) {
                            isBook = 0;
                        }
                        String bookName = null;
                        String publishYear = null;
                        String authorLastName = null;
                        String authorName = null;
                        String authorYearOfBorn = null;
                        if (isBook == 1) {
                            if (line.contains("name:")) {
                                String[] lineArray;
                                lineArray = line.split("\"");
                                bookName = lineArray[1];
                            }
                            if (line.contains("publishYear:")) {
                                String[] lineArray;
                                lineArray = line.split(":");
                                publishYear = lineArray[1];
                            }

                            InputBook inputBookFromFile = new InputBook();
                            if (publishYear != null && bookName != null) {
                                inputBookFromFile.setName(bookName);
                                inputBookFromFile.setPublishYear(Integer.parseInt(publishYear.trim()));
                            }
                            if (line.contains("HandWrittenBook")) {
                                Book bookFromFile = valueOfForHandWrittenBook(inputBookFromFile);
                            } else if (line.contains("PrintedBook")) {
                                Book bookFromFile = valueOfForPrintedBook(inputBookFromFile);
                            }
                        } else if (isBook == 0) {
                            if (line.contains("lastName:")) {
                                String[] lineArray;
                                lineArray = line.split("\"");
                                authorLastName = lineArray[1];
                            }
                            if (line.contains("name:")) {
                                String[] lineArray;
                                lineArray = line.split(":");
                                authorName = lineArray[1];
                            }
                            if (line.contains("yearOfBorn:")) {
                                String[] lineArray;
                                lineArray = line.split(":");
                                authorYearOfBorn = lineArray[1];
                            }
                            InputAuthor inputAuthorFromFile = new InputAuthor();
                            if (authorName != null && authorLastName != null && authorYearOfBorn != null) {
                                inputAuthorFromFile.setLastName(authorLastName);
                                inputAuthorFromFile.setName(authorName);
                                inputAuthorFromFile.setYearOfBorn(Integer.parseInt(authorYearOfBorn.trim()));
                            }

                            /*Author author = valueOfForHandWrittenBook(inputAuthor);

                            author.setBooks(mutableCollectionOf(book1, book2));
                            book1.setAuthors(mutableCollectionOf(author, author));
                            book2.setAuthors(mutableCollectionOf(author));

                            bookService.add(book1);
                            bookService.add(book2);

                            authorService.add(author);
                            */
                        }
                    }
                    String storageType = "collection";
                    BookRepo bookRepo = null;
                    AuthorRepo authorRepo = null;

                    if (storageType.equals("arrays")) {
                        bookRepo = new BookRepoArrayImpl();
                        authorRepo = new AuthorRepoArrayImpl();
                    } else if (storageType.equals("collection")) {
                        bookRepo = new BookRepoCollectionImpl();
                        authorRepo = new AuthorRepoCollectionImpl();
                    }

                    AuthorService authorService = new AuthorServiceImpl(authorRepo, bookRepo);
                    BookService bookService = new BookServiceImpl(bookRepo);
                    initData(bookService, authorService);

                    bookService.print();
                    authorService.print();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case FROM_MEMORY:
                String storageType = "collection";
                BookRepo bookRepo = null;
                AuthorRepo authorRepo = null;

                if (storageType.equals("arrays")) {
                    bookRepo = new BookRepoArrayImpl();
                    authorRepo = new AuthorRepoArrayImpl();
                } else if (storageType.equals("collection")) {
                    bookRepo = new BookRepoCollectionImpl();
                    authorRepo = new AuthorRepoCollectionImpl();
                }

                AuthorService authorService = new AuthorServiceImpl(authorRepo, bookRepo);
                BookService bookService = new BookServiceImpl(bookRepo);
                initData(bookService, authorService);

                bookService.print();
                authorService.print();
                break;
        }
    }

    private static List<String> readFile(String file) throws IOException {
        List<String> content = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                content.add(line);
            }
        }
        return content;
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

        author.setBooks(mutableCollectionOf(book1, book2));
        book1.setAuthors(mutableCollectionOf(author, author));
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
