package lesson_5.storage;

public final class IdGenerator {
    public static long id = 1;

    private IdGenerator() {

    }

    public static Long generateId() {
        return ++id;
    }
}
