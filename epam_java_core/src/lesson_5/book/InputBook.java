package lesson_5.book;

public class InputBook {
    private String name;
    private int publishYear;
    private int totalPages;
    private String fontFamily;
    private String paint;

    public String getFontFamily() {
        return fontFamily;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    public String getPaint() {
        return paint;
    }

    public void setPaint(String paint) {
        this.paint = paint;
    }

    enum Genre {
        ROMAN, FANTASY, DETECTIVE
    }

    private enum BookType {
        HANDWRITTEN, PRINTED
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public String getName() {
        return name;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public int getTotalPages() {
        return totalPages;
    }


}
