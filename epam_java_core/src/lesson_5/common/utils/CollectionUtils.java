package lesson_5.common.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class CollectionUtils {
    private CollectionUtils() {
    }

    public static <T> List<T> mutableCollectionOf(T... items) {
        return new ArrayList<>(Arrays.asList(items));
    }
}
