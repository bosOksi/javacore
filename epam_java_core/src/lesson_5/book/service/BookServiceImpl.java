package lesson_5.book.service;

import lesson_5.author.repo.AuthorRepo;
import lesson_5.book.Book;
import lesson_5.book.repo.BookRepo;

public class BookServiceImpl implements BookService {
    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;

    public BookServiceImpl(AuthorRepo authorRepo, BookRepo bookRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }

    @Override
    public Long add(Book book) {
        return bookRepo.add(book);
    }

    @Override
    public void print() {
        bookRepo.print();
    }

    @Override
    public int count() {
        return bookRepo.count();
    }

    //public void getBooksSortedByName() {authorRepo.getBooksSortedByName();}

    @Override
    public void delete(Book book) {
        bookRepo.delete(book);
    }
}
