package lesson_5.author.repo;

import lesson_5.author.domain.Author;
import lesson_5.storage.ArrayStorage;

public class AuthorRepoArrayImpl implements AuthorRepo {

    @Override
    public Long add(Author author) {
        ArrayStorage.addAuthor(author);
        return author.getId();
    }

    @Override
    public int count() {
        return ArrayStorage.getTotalAuthors();
    }

    @Override
    public void print() {
        for (Author author : ArrayStorage.getAllAuthors()) {
            if (author != null) {
                System.out.println(author.toString());
            }
        }
    }

    @Override
    public void delete(Author author) {
        ArrayStorage.removeAuthor(author);
    }

    @Override
    public Author getById(Long id) {
        for (Author author : ArrayStorage.getAllAuthors()) {
            if (author != null && id.equals(author.getId())) {
                return author;
            }
        }
        return null;
    }

    //public List<Author> SortedByNameAsCollection() {}
    //public Author[] SortedByNameAsArray() {]
}
