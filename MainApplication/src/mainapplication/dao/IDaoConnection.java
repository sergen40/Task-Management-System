package mainapplication.dao;

import java.sql.Connection;
import java.util.ArrayList;
import mainapplication.util.DatabaseConnection;

/**
 *
 * @author SERGEN
 */

public interface IDaoConnection<T> {

    
    public void create(T t);
    public void update(T t);
    public void delete(T t);
    public ArrayList<T> getList();
    public T get(int id);


    
    default Connection getInterfaceConnection(){
       return DatabaseConnection.getInstance().getConnection();
    }
}
