package lesson_5.book;

import lesson_5.author.Author;

public abstract class Book {

    protected Long id;
    protected String name;
    protected int publishYear;
    protected int totalPages;
    protected Author[] authors;
    protected BookGenre bookGenre;

    public BookGenre getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(BookGenre bookGenre) {
        this.bookGenre = bookGenre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public Author[] getAuthors() {
        return authors;
    }

    @Override
    public String toString() {
        return "book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publishYear=" + publishYear +
                ", totalPages=" + totalPages +
                '}';
    }
}

