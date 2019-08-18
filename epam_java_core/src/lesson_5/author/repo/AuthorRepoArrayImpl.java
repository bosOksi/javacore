package lesson_5.author.repo;

import lesson_5.author.domain.Author;

import static lesson_5.Storage.*;


public class AuthorRepoArrayImpl implements AuthorRepo {

    @Override
    public Long add(Author author) {
        addAuthor(author);
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
        removeAuthor(author);
    }
}
