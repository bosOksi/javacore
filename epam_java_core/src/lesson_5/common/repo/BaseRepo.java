package lesson_5.common.repo;

import java.util.List;

public interface BaseRepo<T, ID> {
    void print();
    int count();
    void delete(T t);
    ID add(T t);
    T getById(ID id);
    //List<T> SortedByNameAsCollection();
    //T[] SortedByNameAsArray();
}
