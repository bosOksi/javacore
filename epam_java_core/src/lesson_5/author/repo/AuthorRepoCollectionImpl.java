package lesson_5.author.repo;

import lesson_5.author.domain.Author;
import lesson_5.storage.CollectionStorage;

import java.util.Collection;
import java.util.Collections;

import static lesson_5.storage.CollectionStorage.getAllAuthors;

public class AuthorRepoCollectionImpl implements AuthorRepo {

    @Override
    public Long add(Author author) {
        CollectionStorage.addAuthor(author);
        return author.getId();
    }

    @Override
    public int count() {
        return CollectionStorage.getTotalAuthors();
    }

    @Override
    public void print() {
        for (Author author : getAllAuthors()) {
            if (author != null) {
                System.out.println(author.toString());
            }
        }
    }

    @Override
    public void delete(Author author) {
        CollectionStorage.removeAuthor(author);
    }

    /*@Override
    public Author[] getAuthorsAsArraySortedByLastName() {
        return getAuthorsAsCollectionSortedByLastName.toArray(new Author[0]);
    }*/

    /*@Override
    public Author<> getAuthorsAsCollectionSortedByLastName() {
    }*/


}
