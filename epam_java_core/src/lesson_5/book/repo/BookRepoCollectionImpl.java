package lesson_5.book.repo;

import lesson_5.book.Book;

public class BookRepoCollectionImpl implements BookRepo{
    @Override

    public Long add(Book book) {
        return null;
    }

    @Override
    public void print() {

    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void delete(Book book) {

    }

    @Override
    public Book[] findBooksByAuthor(Long id) {
        return new Book[0];
    }
}
