package lesson_5.common.repo;


public interface BaseRepo<T, ID> {
    void print();
    int count();
    void delete(T t);
    ID add(T t);
    T getById(ID id);
}
