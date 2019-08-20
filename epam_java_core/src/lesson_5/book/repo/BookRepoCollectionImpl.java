package lesson_5.book.repo;

import lesson_5.author.domain.Author;
import lesson_5.book.Book;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class BookRepoCollectionImpl implements BookRepo{
    public static List<Book> booksList = new ArrayList<>();
    public static Long bookId = 1L;

    @Override
    public Long add(Book book) {
        book.setId(bookId);
        booksList.add(book);
        bookId++;
        return book.getId();
    }

    @Override
    public void print() {
        for (Book book : booksList) {
            if (book != null) {
                System.out.println(book.toString());
            }
        }
    }

    @Override
    public int count() {
        int count = 0;
        for (Book book: booksList) {
            if (book != null) {
                count++;
            }
        }
        return count;
    }

    @Override
    public void delete(Book book) {
        Iterator<Book> iter = booksList.iterator();
        while (iter.hasNext()) {
            Book i = iter.next();
            if (i.getId().equals(book.getId())) {
                iter.remove();
                break;
            }
        }
    }

    @Override
    public Book[] findBooksByAuthor(Long id) {
        Book[] books = new Book[100];
        int index = 0;
        for (Book book : booksList) {
            for (Author a : book.getAuthors()) {
                if (a.getId().equals(id)) {
                    books[index] = book;
                    index++;
                    break;
                }
            }
        }
        //if no books then null
        return books;
    }
}
