package lesson_5.book.domain;

import lesson_5.book.Book;

public class WrittenBook extends Book {
    private String paint;

    public String getPaint() {
        return paint;
    }

    public void setPaint(String paint) {
        this.paint = paint;
    }
}
