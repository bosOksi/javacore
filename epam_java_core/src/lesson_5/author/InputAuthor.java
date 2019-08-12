package lesson_5.author;

public class InputAuthor {
    private String lastName;
    private String name;

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYearOfBorn(int yearOfBorn) {
        this.yearOfBorn = yearOfBorn;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public int getYearOfBorn() {
        return yearOfBorn;
    }

    private int yearOfBorn;

}
