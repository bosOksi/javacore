package lesson_5.book.service;

import lesson_5.author.repo.AuthorRepo;
import lesson_5.book.domain.Book;
import lesson_5.book.repo.BookRepo;

import java.util.List;

public class BookServiceImpl implements BookService {
    private final BookRepo bookRepo;

    public BookServiceImpl(BookRepo bookRepo) {
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

    @Override
    public void delete(Book book) {
        bookRepo.delete(book);
    }

    @Override
    public Book getById(Long id) {
        if (id != null) {
            return bookRepo.getById(id);
        } else {
            return null;
        }
    }

    @Override
    public Book[] findBooksByAuthorAsArray(long authorId) {
        return bookRepo.findBooksByAuthorAsArray(authorId);
    }

    @Override
    public List<Book> findBooksByAuthorAsCollection(long authorId) {
        return bookRepo.findBooksByAuthorAsCollection(authorId);
    }

    //public List<Book> SortedByNameAsCollection() {}
    //public Book[] SortedByNameAsArray() {}
}
