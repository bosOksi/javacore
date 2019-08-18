package lesson_5.author.service;

import lesson_5.author.domain.Author;
import lesson_5.author.repo.AuthorRepo;
import lesson_5.book.Book;
import lesson_5.book.repo.BookRepo;

public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;

    public AuthorServiceImpl(AuthorRepo authorRepo, BookRepo bookRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }

    public Long add(Author author) {
        return authorRepo.add(author);
    }

    public void print() {
        authorRepo.print();
    }

    public int count() {
        return authorRepo.count();
    }

    //public void getAuthorsSortedByLastName() {authorRepo.getAuthorsSortedByLastName();}

    public void delete(Author author) {
        Book[] booksWithAuthor = bookRepo.findBooksByAuthor(author.getId());
        if (booksWithAuthor != null) {
            for (Book book : booksWithAuthor) {
                book.deleteAuthor(author);
                if (book.withoutAuthors()) {
                    bookRepo.delete(book);
                }
            }
        }
        authorRepo.delete(author);

    }
}
