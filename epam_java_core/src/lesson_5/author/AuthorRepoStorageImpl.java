package lesson_5.author;

import lesson_5.Storage;

import static lesson_5.Storage.authors;


public class AuthorRepoStorageImpl implements AuthorRepo {

    @Override
    public void saveAuthor(Author author) {
        author.setId(System.currentTimeMillis());
        if (Storage.authorIndex % (Storage.CAPACITY) == 0 && Storage.authorIndex != 0) {
            Storage.increaseAuthorsStorage();
        } else {
            authors[Storage.authorIndex] = author;
        }
        Storage.increaseAuthorIndex();
    }

    @Override
    public void searchAuthor(Author author) {
        for (int i = 0; i< authors.length; i++) {
            if (author.equals(authors[i])) {
                System.out.println("Author " + author + " is in storage");
            } else {
                System.out.println("Author " + author + " is not found in storage");
            }
        }
    }

    @Override
    public int getCountOfAuthor() {
        return authors.length;
    }

    @Override
    public void getAuthorSortedByLastName() {

    }

    @Override
    public void removeAuthor(Author author) {

    }
}
