package mainapplication.controller;

import java.sql.Date;
import java.util.ArrayList;
import mainapplication.dao.TaskDao;
import mainapplication.model.Task;

/**
 *
 * @author SERGEN
 */
public class TaskController {

    private TaskDao taskDao;

    public TaskController(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public void create(Task task) {
        taskDao.create(task);
    }

    public void update(Task task) {
        taskDao.update(task);
    }

    public void delete(Task task) {
        taskDao.delete(task);
    }

    public ArrayList<Task> getList() {
        return taskDao.getList();
    }

    public Task get(int id) {
        return taskDao.get(id);
    }

    public void createToTaskByUser(int userId, String title, String description, Date actualStartDate, Date actualEndDate, String content) {
        taskDao.createToTaskByUser(userId, title, description, actualStartDate, actualEndDate, content);

    }
}
