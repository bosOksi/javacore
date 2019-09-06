package lesson_5.book.domain;

import lesson_5.author.domain.Author;
import lesson_5.common.domain.BaseDomain;

import java.util.List;

public abstract class Book extends BaseDomain<Long> {

    protected String name;
    protected int publishYear;
    protected int totalPages;
    protected List<Author> authors;
    protected BookGenre bookGenre;

    public BookGenre getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(BookGenre bookGenre) {
        this.bookGenre = bookGenre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void deleteAuthor(Author author) {
    }

    public boolean withoutAuthors() {
        return false;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publishYear=" + publishYear +
                ", totalPages=" + totalPages +
                '}';
    }

    /*public Book getById(Long id) {
        Book found=null;
        for (Book book : ArrayStorage.getAllBooks()) {
            if (book != null && book.getId() == id) {
                found=book;
                break;
            }
        }
        return found;
    }*/

}

