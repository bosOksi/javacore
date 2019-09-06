package lesson_5.book.repo;

import lesson_5.author.domain.Author;
import lesson_5.book.domain.Book;
import lesson_5.storage.CollectionStorage;
import java.util.ArrayList;
import java.util.List;


public class BookRepoCollectionImpl implements BookRepo{
    @Override
    public int count() {
        return CollectionStorage.getTotalBooks();
    }

    @Override
    public void print() {
        for (Book book : CollectionStorage.getAllBooks()) {
            if (book != null) {
                System.out.println(book.toString());
            }
        }
    }

    @Override
    public void delete(Book book) {
        CollectionStorage.removeBook(book);
    }

    @Override
    public Long add(Book book) {
        CollectionStorage.addBook(book);
        return book.getId();
    }

    @Override
    public Book getById(Long id) {
        for (Book book : CollectionStorage.getAllBooks()) {
            if (book != null && id.equals(book.getId())) {
                return book;
            }
        }
        return null;
    }
    @Override
    public Book[] findBooksByAuthorAsArray(long authorId) {
        return findBooksByAuthorAsCollection(authorId).toArray(new Book[0]);
    }

    @Override
    public List<Book> findBooksByAuthorAsCollection(long authorId) {
        List<Book> found = new ArrayList<>();
        for (Book b : CollectionStorage.getAllBooks()) {
            for (Author a : b.getAuthors()) {
                if (a != null && authorId == a.getId()) {
                    found.add(b);
                    break;
                }
            }
        }
        return found;
    }

    //public List<Book> SortedByNameAsCollection() {}
    //public Book[] SortedByNameAsArray() {}
}
