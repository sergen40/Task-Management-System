/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainapplication.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mainapplication.model.ToDoList;

/**
 *
 * @author Rita
 */
public class ToDoListDao implements IDaoConnection<ToDoList> {

    @Override
    public void create(ToDoList todolist) {
        try ( Connection connection = getInterfaceConnection()) {
            String sql = "insert into [dbo].[ToDoList] ( taskId, editId, title, createdAt, updatedAt,[content]) values(?,?,?,?,?,?); ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(2, todolist.getTaskId());
            preparedStatement.setInt(3, todolist.getEditId());
            preparedStatement.setString(4, todolist.getTitle());
            preparedStatement.setDate(5, (Date) todolist.getCreatedAt());
            preparedStatement.setDate(6, (Date) todolist.getUpdatedAt());
            preparedStatement.setString(7, todolist.getContent());

            int rowEfected = preparedStatement.executeUpdate();
            if (rowEfected > 0) {
                System.out.println(ToDoList.class + " ekleme başarılı");
            } else {
                System.out.println(ToDoList.class + " ekleme başarısız");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    
    public void createToDoListByUser (String title,Date created, String content ){
        
        try ( Connection connection = getInterfaceConnection()) {
            String sql = "insert into [dbo].[ToDoList] (title, createdAt,[content]) values(?,?,?); ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, title);
            preparedStatement.setDate(2, created);
            preparedStatement.setString(3, content);

            int rowEfected = preparedStatement.executeUpdate();
            if (rowEfected > 0) {
                System.out.println(ToDoList.class + " ekleme başarılı");
            } else {
                System.out.println(ToDoList.class + " ekleme başarısız");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        
    }

    @Override
    public void update(ToDoList todolist) {
        try ( Connection connectionUpdate = getInterfaceConnection()) {
            String sqlUpdate = "update [dbo].[ToDoList] set   taskId=?, editId=?, title=?, createdAt=?, updatedAt=?,[content]=?  where  id=? ";
            PreparedStatement preparedStatementUpdate = connectionUpdate.prepareStatement(sqlUpdate);

            preparedStatementUpdate.setInt(2, todolist.getTaskId());
            preparedStatementUpdate.setInt(3, todolist.getEditId());
            preparedStatementUpdate.setString(4, todolist.getTitle());
            preparedStatementUpdate.setDate(5, (Date) todolist.getCreatedAt());
            preparedStatementUpdate.setDate(6, (Date) todolist.getUpdatedAt());
            preparedStatementUpdate.setString(7, todolist.getContent());

            int rowEfected = preparedStatementUpdate.executeUpdate();
            if (rowEfected > 0) {
                System.out.println(ToDoList.class + " güncelleme başarılı");
            } else {
                System.out.println(ToDoList.class + " güncelle başarısız");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void delete(ToDoList todolist) {
        try ( Connection connectionDelete = getInterfaceConnection()) {
            String sqlDelete = "delete from  [dbo].[ToDoList]  where  id=?";
            PreparedStatement preparedStatementDelete = connectionDelete.prepareStatement(sqlDelete);
            preparedStatementDelete.setInt(1, todolist.getId());
            int rowEfected = preparedStatementDelete.executeUpdate();
            if (rowEfected > 0) {
                System.out.println(ToDoList.class + " silme başarılı");
            } else {
                System.out.println(ToDoList.class + " silme başarısız");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public ArrayList<ToDoList> getList() {
        ArrayList<ToDoList> todolistList = new ArrayList<>();
        try ( Connection connection = getInterfaceConnection()) {
            String sql = "select * from [dbo].[ToDoList]";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ToDoList todolist = new ToDoList();
                todolist.setId(resultSet.getInt("id"));
                todolist.setTaskId(resultSet.getInt("taskId"));
                todolist.setEditId(resultSet.getInt("editId"));
                todolist.setTitle(resultSet.getString("title"));
                todolist.setCreatedAt(resultSet.getDate("createdAt"));
                todolist.setUpdatedAt(resultSet.getDate("updatedAt"));
                todolist.setContent(resultSet.getString("content"));

                todolistList.add(todolist);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " Task Listeleme işlemi sırasında hata meydana geldi  ");
            e.printStackTrace();
        }
        return todolistList;
    }

    @Override
    public ToDoList get(int id) {
        try ( Connection connection = getInterfaceConnection()) {
            String sql = "select * from [dbo].[ToDoList] where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                ToDoList todolist = new ToDoList();

                todolist.setId(resultSet.getInt("id"));
                todolist.setTaskId(resultSet.getInt("taskId"));
                todolist.setEditId(resultSet.getInt("editId"));
                todolist.setTitle(resultSet.getString("title"));
                todolist.setCreatedAt(resultSet.getDate("createdAt"));
                todolist.setUpdatedAt(resultSet.getDate("updatedAt"));
                todolist.setContent(resultSet.getString("content"));

                return todolist;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " todolist getirme işlemi sırasında hata meydana geldi  ");
            e.printStackTrace();
        }
        return null;
    }

}
