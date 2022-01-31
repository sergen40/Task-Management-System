package mainapplication.controller;

import java.sql.Date;
import java.util.ArrayList;
import mainapplication.dao.ToDoListDao;
import mainapplication.model.ToDoList;

/**
 *
 * @author SERGEN
 */
public class ToDoListController {

    private ToDoListDao todolistDao;

    public ToDoListController(ToDoListDao todolistDao) {
        this.todolistDao = todolistDao;
    }

    public void create(ToDoList todolist) {
        todolistDao.create(todolist);
    }

    public void update(ToDoList todolist) {
        todolistDao.update(todolist);
    }

    public void delete(ToDoList todolist) {
        todolistDao.delete(todolist);
    }

    public ArrayList<ToDoList> getList() {
        return todolistDao.getList();
    }

    public ToDoList get(int id) {
        return todolistDao.get(id);
    }
    
     public void createToDoListByUser (String title,Date created, String content ){
         todolistDao.createToDoListByUser(title, created, content);
     }

}
