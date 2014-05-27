package com.students.dao;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Elena on 5/27/2014.
 */
@Transactional(Transactional.TxType.REQUIRED)
public interface Dao<T> {

    void save(T object);

    void update(T object);

    void delete(T object);

    T get(Integer id);

    List<T> getAll();
}
