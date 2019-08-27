package lesson_5.book.repo;

import lesson_5.author.domain.Author;
import lesson_5.book.Book;
import lesson_5.storage.ArrayStorage;

import java.util.ArrayList;
import java.util.List;


public class BookRepoArrayImpl implements BookRepo {

    @Override
    public Long add(Book book) {
        ArrayStorage.addBook(book);
        return book.getId();
    }

    @Override
    public int count() {
        return ArrayStorage.getTotalBooks();
    }

    @Override
    public void print() {
        for (Book book : ArrayStorage.getAllBooks()) {
            if (book != null) {
                System.out.println(book.toString());
            }
        }
    }

    @Override
    public void delete(Book book) {
        ArrayStorage.removeBook(book);
    }

    @Override
    public Book[] findBooksByAuthorAsArray(long authorId) {
        return findBooksByAuthorAsCollection(authorId).toArray(new Book[0]);
    }

    @Override
    public List<Book> findBooksByAuthorAsCollection(long authorId) {
        List<Book> found = new ArrayList<>();
        for (Book book : ArrayStorage.getAllBooks()) {
            for (Author a : book.getAuthors()) {
                if (Long.valueOf(authorId).equals(a.getId())) {
                    found.add(book);
                    break;
                }
            }
        }
        return found;
    }
    /*@Override
    public Book[] getBooksAsArraySortedByName() {
        return getBooksAsCollectionSortedByName().toArray(new Book[0]);
    }*/

    /*@Override
    public Book<> getBooksAsCollectionSortedByName() {
    }*/
}
