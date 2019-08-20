package lesson_5.author.repo;

import lesson_5.author.domain.Author;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class AuthorRepoCollectionImpl implements AuthorRepo {

    public static List<Author> authorsList = new ArrayList<>();
    public static Long authorId = 1L;

    @Override
    public Long add(Author author) {
        author.setId(authorId);
        authorsList.add(author);
        authorId++;
        return author.getId();
    }

    @Override
    public void print() {
        for (Author author : authorsList) {
            if (author != null) {
                System.out.println(author.toString());
            }
        }

    }

    @Override
    public int count() {
        int count = 0;
        for (Author author: authorsList) {
            if (author != null) {
                count++;
            }
        }
        return count;
    }

    @Override
    public void delete(Author author) {
        Iterator<Author> iter = authorsList.iterator();
        while (iter.hasNext()) {
            Author i = iter.next();
            if (i.getId().equals(author.getId())) {
                iter.remove();
                break;
            }
        }

    }
}
