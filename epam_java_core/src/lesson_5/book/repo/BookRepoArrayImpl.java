package lesson_5.book.repo;

import lesson_5.author.domain.Author;
import lesson_5.book.Book;
import static lesson_5.Storage.increaseBookIndex;
import static lesson_5.Storage.increaseBooksStorage;


public class BookRepoArrayImpl implements BookRepo {
    public static Long bookId = 1L;
    public static final int CAPACITY = 10;
    public static Book[] books = new Book[CAPACITY];
    public static int bookIndex = 0;

    @Override
    public Long add(Book book) {
        book.setId(bookId);
        if (bookIndex % (CAPACITY) == 0 && bookIndex != 0) {
            increaseBooksStorage();
        } else {
            books[bookIndex] = book;
        }
        increaseBookIndex();
        bookId++;
        return book.getId();
    }

    @Override
    public int count() {
        int count = 0;
        for (Book book : books) {
            if (book != null) {
                count++;
            }
        }
        return count;
    }

    @Override
    public void print() {
        for (Book book : books) {
            if (book != null) {
                System.out.println(book.toString());
            }
        }
    }

    /*@Override
    public void getBooksSortedByName() {
        for (int i = 0; i< books.length;i++) {
            for (int j=1; j < Storage.books.length; j++) {
                Character letterOfBookName = (Character)books[i].name.charAt(j);
                Character letterOfBookNameInLowerCase = toLowerCase(letterOfBookName);
                Character[] lettersOfBookNameInLowerCase = new Character[books[i].name.length()];
                lettersOfBookNameInLowerCase.add();
                if (letterOfBookNameInLowerCase.charValue()< letterOfBookNameInLowerCase.charValue()[i - 1]);
            }
        }

        System.out.println("Books sorted by name");
    }*/


    @Override
    public void delete(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (book.getId().equals(books[i].getId())) {
                books[i] = null;
                bookIndex--;
                break;
            }
        }
        Book[] newBooks = new Book[books.length];
        int index = 0;
        for (Book b: books) {
            if (b != null) {
                newBooks[index] = b;
                index++;
            }
        }
        books = newBooks;
    }

    @Override
    public Book[] findBooksByAuthor(Long id) {

        Book[] books = new Book[100];
        int index = 0;
        for (Book book : books) {
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
