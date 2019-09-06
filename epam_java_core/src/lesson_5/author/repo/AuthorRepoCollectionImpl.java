package lesson_5.author.repo;

import lesson_5.author.domain.Author;
import lesson_5.storage.CollectionStorage;
import static lesson_5.storage.CollectionStorage.getAllAuthors;

public class AuthorRepoCollectionImpl implements AuthorRepo {

    @Override
    public Long add(Author author) {
        CollectionStorage.addAuthor(author);
        return author.getId();
    }

    @Override
    public int count() {
        return CollectionStorage.getTotalAuthorsAmount();
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

    @Override
    public Author getById(Long id) {
        for (Author author : CollectionStorage.getAllAuthors()) {
            if (author != null && id.equals(author.getId())) {
                return author;
            }
        }
        return null;
    }

    //public List<Author> SortedByNameAsCollection() {}
    //public Author[] SortedByNameAsArray() {}
}
