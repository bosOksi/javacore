package lesson_5.common.service;

public interface BaseService<T, ID> {
    void print();
    int count();
    void delete(T t);
    ID add(T t);
    T getById(ID id);
}
