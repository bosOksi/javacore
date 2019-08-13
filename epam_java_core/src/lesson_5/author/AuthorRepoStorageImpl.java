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
        for (int i = 0; i < authors.length; i++) {
            boolean isInStorage = false;
            if (author.equals(authors[i])) {
                System.out.println("Author " + author + " is in storage");
                isInStorage = true;
            } else {
                if (isInStorage) {
                    System.out.println("Author " + author + " is not found in storage");
                }
            }
        }
    }

    @Override
    public int getCountOfAuthor() {
        int count=authors.length;
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] == null) {
                count -= 1;
            }
        }
        return count;
    }

    @Override
    public void getAuthorSortedByLastName() {

    }

    @Override
    public void removeAuthor(Author author) {
        int j=0;
        for (int i = 0; i < authors.length; i++) {
            if (author.equals(authors[i])) {
                authors[i] = null;
                System.out.println("Author " + author + " removed from storage");
                j += 1;
            }
        }
        if (j==0) {
            System.out.println("Author " + author + " is not found in storage");
        }
    }
}
