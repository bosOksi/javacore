package lesson_5.author.repo;

import lesson_5.author.domain.Author;
import static lesson_5.Storage.increaseAuthorIndex;
import static lesson_5.Storage.increaseAuthorsStorage;


public class AuthorRepoArrayImpl implements AuthorRepo {
    public static final int CAPACITY = 10;
    public static Author[] authors = new Author[CAPACITY];
    public static int authorIndex = 0;
    public static Long authorId = 1L;

    @Override
    public Long add(Author author) {
        author.setId(authorId);
        if (authorIndex % (CAPACITY) == 0 && authorIndex != 0) {
            increaseAuthorsStorage();
        } else {
            authors[authorIndex] = author;
        }
        increaseAuthorIndex();
        authorId++;
        return author.getId();
    }

    @Override
    public int count() {
        int count = 0;
        for (Author author: authors) {
            if (author != null) {
                count++;
            }
        }
        return count;
    }

    @Override
    public void print() {
        for (Author author: authors) {
            if (author != null) {
                System.out.println(author.toString());
            }
        }
    }

    /*@Override
    public void getBooksSortedByName() {
        /*for (int i = 0; i< books.length;i++) {
            for (int j=1; j < books[i].name.length(); j++) {
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
    public void delete(Author author) {
        for (int i = 0; i < authors.length; i++) {
            if (author.getId().equals(authors[i].getId())) {
                authors[i] = null;
                authorIndex--;
                break;
            }
        }
        Author[] newAuthors = new Author[authors.length];
        int index = 0;
        for (Author a: authors) {
            if (a != null) {
                newAuthors[index] = a;
                index++;
            }
        }
        authors = newAuthors;
    }
}
