package lesson_5.book.domain;

public class PrintedBook extends Book {
    private String fontFamily;

    public String getFontFamily() {
        return fontFamily;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    @Override
    public String toString() {
        return "PrintedBook{" +
                "fontFamily='" + fontFamily + '\'' +
                '}';
    }
}
