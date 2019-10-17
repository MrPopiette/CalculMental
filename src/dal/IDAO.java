package dal;

import java.util.List;

public interface IDAO<E> {

     void create(E object);
    List<E> findAll();
    E findById();
}
