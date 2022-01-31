package mainapplication.dao;

import mainapplication.model.Task;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Rita
 */
public class TaskDao implements IDaoConnection<Task> {

    @Override
    public void create(Task task) {
        try ( Connection connection = getInterfaceConnection()) {
            String sql = "insert into [dbo].[Task] ( userId, createdBy, updatedBy, title, description, status, createdAt, updatedAt, plannedStartDate, plannedEndDate, actualStartDate, actualEndDate, [content]) values(?,?,?,?,?,?,?,?,?,?,?,?,?); ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(2, task.getUserId());
            preparedStatement.setInt(3, task.getCreatedBy());
            preparedStatement.setInt(4, task.getUpdatedBy());
            preparedStatement.setString(5, task.getTitle());
            preparedStatement.setString(6, task.getDescription());
            preparedStatement.setInt(7, task.getStatus());
            preparedStatement.setDate(8, task.getCreatedAt());
            preparedStatement.setDate(9, task.getUpdatedAt());
            preparedStatement.setDate(10, task.getPlannedStartDate());
            preparedStatement.setDate(11, task.getPlannedEndDate());
            preparedStatement.setDate(12, task.getActualStartDate());
            preparedStatement.setDate(13, task.getActualEndDate());
            preparedStatement.setString(14, task.getContent());

            int rowEfected = preparedStatement.executeUpdate();
            if (rowEfected > 0) {
                System.out.println(Task.class + " ekleme başarılı");
            } else {
                System.out.println(Task.class + " ekleme başarısız");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    
    public void createToTaskByUser (int userId, String title,String description, Date actualStartDate, Date actualEndDate,  String content ){
        
        try ( Connection connection = getInterfaceConnection()) {
            String sql = "insert into [dbo].[Task] (userId, title, description, actualStartDate, actualEndDate, [content]) values(?,?,?,?,?,?); ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, title);
            preparedStatement.setString(3, description);
            preparedStatement.setDate(4, actualStartDate);
            preparedStatement.setDate(5, actualEndDate);
            preparedStatement.setString(6, content);

            int rowEfected = preparedStatement.executeUpdate();
            if (rowEfected > 0) {
                System.out.println(Task.class + " ekleme başarılı");
            } else {
                System.out.println(Task.class + " ekleme başarısız");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        
    }

    @Override
    public void update(Task task) {
        try ( Connection connectionUpdate = getInterfaceConnection()) {
            String sqlUpdate = "update [dbo].[Task] set  userId=?, createdBy=?, updatedBy=?, title=?, description=?, status=?, createdAt=?, updatedAt=?, plannedStartDate=?, plannedEndDate=?, actualStartDate=?, actualEndDate=?, [content]=?  where  id=? ";
            PreparedStatement preparedStatementUpdate = connectionUpdate.prepareStatement(sqlUpdate);
            //      preparedStatementUpdate.setInt(1, task.getUserId());
            preparedStatementUpdate.setInt(2, task.getCreatedBy());
            preparedStatementUpdate.setInt(3, task.getUpdatedBy());
            preparedStatementUpdate.setString(4, task.getTitle());
            preparedStatementUpdate.setString(5, task.getDescription());
            preparedStatementUpdate.setInt(6, task.getStatus());
            preparedStatementUpdate.setDate(7, task.getCreatedAt());
            preparedStatementUpdate.setDate(8, task.getUpdatedAt());
            preparedStatementUpdate.setDate(9, task.getPlannedStartDate());
            preparedStatementUpdate.setDate(10, task.getPlannedEndDate());
            preparedStatementUpdate.setDate(11, task.getActualStartDate());
            preparedStatementUpdate.setDate(12, task.getActualEndDate());
            preparedStatementUpdate.setString(13, task.getContent());

            int rowEfected = preparedStatementUpdate.executeUpdate();
            if (rowEfected > 0) {
                System.out.println(Task.class + " güncelleme başarılı");
            } else {
                System.out.println(Task.class + " güncelle başarısız");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void delete(Task task) {
        try ( Connection connectionDelete = getInterfaceConnection()) {
            String sqlDelete = "delete from  [dbo].[Task]  where  id=?";
            PreparedStatement preparedStatementDelete = connectionDelete.prepareStatement(sqlDelete);
            preparedStatementDelete.setInt(1, task.getId());
            int rowEfected = preparedStatementDelete.executeUpdate();
            if (rowEfected > 0) {
                System.out.println(Task.class + " silme başarılı");
            } else {
                System.out.println(Task.class + " silme başarısız");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public ArrayList<Task> getList() {
        ArrayList<Task> taskList = new ArrayList<>();
        try ( Connection connection = getInterfaceConnection()) {
            String sql = "select * from [dbo].[Task]";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setUserId(resultSet.getInt("userId"));
                task.setCreatedBy(resultSet.getInt("createdBy"));
                task.setUpdatedBy(resultSet.getInt("updatedBy"));
                task.setTitle(resultSet.getString("title"));
                task.setDescription(resultSet.getString("description"));
                task.setStatus(resultSet.getInt("status"));
                task.setCreatedAt(resultSet.getDate("createdAt"));
                task.setUpdatedAt(resultSet.getDate("updatedAt"));
                task.setPlannedStartDate(resultSet.getDate("plannedStartDate"));
                task.setPlannedEndDate(resultSet.getDate("plannedEndDate"));
                task.setActualStartDate(resultSet.getDate("actualStartDate"));
                task.setActualEndDate(resultSet.getDate("actualEndDate"));
                task.setContent(resultSet.getString("content"));

                taskList.add(task);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " Task Listeleme işlemi sırasında hata meydana geldi  ");
            e.printStackTrace();
        }
        return taskList;
    }

    @Override
    public Task get(int id) {
        try ( Connection connection = getInterfaceConnection()) {
            String sql = "select * from [dbo].[Task] where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Task task = new Task();

                task.setId(resultSet.getInt("id"));
                task.setUserId(resultSet.getInt("userId"));
                task.setCreatedBy(resultSet.getInt("createdBy"));
                task.setUpdatedBy(resultSet.getInt("updatedBy"));
                task.setTitle(resultSet.getString("title"));
                task.setDescription(resultSet.getString("description"));
                task.setStatus(resultSet.getInt("status"));
                task.setCreatedAt(resultSet.getDate("createdAt"));
                task.setUpdatedAt(resultSet.getDate("updatedAt"));
                task.setPlannedStartDate(resultSet.getDate("plannedStartDate"));
                task.setPlannedEndDate(resultSet.getDate("plannedEndDate"));
                task.setActualStartDate(resultSet.getDate("actualStartDate"));
                task.setActualEndDate(resultSet.getDate("actualEndDate"));
                task.setContent(resultSet.getString("content"));

                return task;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " Task getirme işlemi sırasında hata meydana geldi  ");
            e.printStackTrace();
        }
        return null;
    }

}
