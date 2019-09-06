package lesson_5.author.domain;

import lesson_5.book.domain.Book;
import lesson_5.common.domain.BaseDomain;

import java.util.List;

public class Author extends BaseDomain<Long> {
    private String lastName;
    private String name;
    private int yearOfBorn;
    private List<Book> books;

    public Author(Long id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setYearOfBorn(int yearOfBorn) {
        this.yearOfBorn = yearOfBorn;
    }
    public int getYearOfBorn() {
        return yearOfBorn;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", yearOfBorn=" + yearOfBorn +
                '}';
    }
}
