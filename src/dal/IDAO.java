package dal;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<E> {

     void create(E object);
    List<E> findAll() throws SQLException;
    E findById();
}
