package application.repository;

import java.util.List;

public interface CRUDCustomRepository<T> {

    //CREATE
    T save(T entity);

    //READ
    List<T> findAll();

    //READ ONE
    T findById(Integer id);

    //UPDATE
    T update(T entity);

    //DELETE
    void delete(Integer id);

}
