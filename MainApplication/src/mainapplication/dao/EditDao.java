package mainapplication.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mainapplication.model.Edit;
import mainapplication.model.User;

/**
 *
 * @author Rita
 */
public class EditDao implements IDaoConnection<Edit> {

    @Override
    public void create(Edit edit) {
        try ( Connection connection = getInterfaceConnection()) {
            String sql = "insert into [dbo].[Edit] ( userId, taskId, createdBy, updatedBy, title, description, status, createdAt, updatedAt, plannedStartDate, plannedEndDate, actualStartDate, actualEndDate, [content]) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(2, edit.getUserId());
            preparedStatement.setInt(3, edit.getTaskId());
            preparedStatement.setInt(4, edit.getCreatedBy());
            preparedStatement.setInt(5, edit.getUpdatedBy());
            preparedStatement.setString(6, edit.getTitle());
            preparedStatement.setString(7, edit.getDescription());
            preparedStatement.setInt(8, edit.getStatus());
            preparedStatement.setDate(9, (Date) edit.getCreatedAt());
            preparedStatement.setDate(10, (Date) edit.getUpdatedAt());
            preparedStatement.setDate(11, (Date) edit.getPlannedStartDate());
            preparedStatement.setDate(12, (Date) edit.getPlannedEndDate());
            preparedStatement.setDate(13, (Date) edit.getActualStartDate());
            preparedStatement.setDate(14, (Date) edit.getActualEndDate());
            preparedStatement.setString(15, edit.getContent());

            int rowEfected = preparedStatement.executeUpdate();
            if (rowEfected > 0) {
                System.out.println(Edit.class + " ekleme başarılı");
            } else {
                System.out.println(Edit.class + " ekleme başarısız");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void update(Edit edit) {
        try ( Connection connectionUpdate = getInterfaceConnection()) {
            String sqlUpdate = "update [dbo].[Edit] set  userId=?, taskId=?, createdBy=?, updatedBy=?, title=?, description=?, status=?, createdAt=?, updatedAt=?, plannedStartDate=?, plannedEndDate=?, actualStartDate=?, actualEndDate=?, [content]=?  where  id=?";
            PreparedStatement preparedStatementUpdate = connectionUpdate.prepareStatement(sqlUpdate);
            preparedStatementUpdate.setInt(2, edit.getUserId());
            preparedStatementUpdate.setInt(3, edit.getTaskId());
            preparedStatementUpdate.setInt(4, edit.getCreatedBy());
            preparedStatementUpdate.setInt(5, edit.getUpdatedBy());
            preparedStatementUpdate.setString(6, edit.getTitle());
            preparedStatementUpdate.setString(7, edit.getDescription());
            preparedStatementUpdate.setInt(8, edit.getStatus());
            preparedStatementUpdate.setDate(9, (Date) edit.getCreatedAt());
            preparedStatementUpdate.setDate(10, (Date) edit.getUpdatedAt());
            preparedStatementUpdate.setDate(11, (Date) edit.getPlannedStartDate());
            preparedStatementUpdate.setDate(12, (Date) edit.getPlannedEndDate());
            preparedStatementUpdate.setDate(13, (Date) edit.getActualStartDate());
            preparedStatementUpdate.setDate(14, (Date) edit.getActualEndDate());
            preparedStatementUpdate.setString(15, edit.getContent());
            int rowEfected = preparedStatementUpdate.executeUpdate();
            if (rowEfected > 0) {
                System.out.println(Edit.class + " güncelleme başarılı");
            } else {
                System.out.println(Edit.class + " güncelle başarısız");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }


    public void updateByUser(int taskId, String title, String description, Date actualStartDate, Date actualEndDate, String content) {

        try ( Connection connectionUpdate = getInterfaceConnection()) {
            String sqlUpdate = "update [dbo].[Edit] set taskId=?, title=?, description=?, actualStartDate=?, actualEndDate=?, [content]=?  where  taskId=?";
            PreparedStatement preparedStatementUpdate = connectionUpdate.prepareStatement(sqlUpdate);
         
            preparedStatementUpdate.setInt(1, taskId);
            preparedStatementUpdate.setString(2, title);
            preparedStatementUpdate.setString(3, description);
            preparedStatementUpdate.setDate(4, (Date) actualStartDate);
            preparedStatementUpdate.setDate(5, (Date) actualEndDate);
            preparedStatementUpdate.setString(6, content);
            preparedStatementUpdate.setInt(7, taskId);

            int rowEfected = preparedStatementUpdate.executeUpdate();
            if (rowEfected > 0) {
                System.out.println(Edit.class + " güncelleme başarılı");
            } else {
                System.out.println(Edit.class + " güncelle başarısız");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }
//    
    
//    public void updateByUser(String title, String description, Date actualStartDate, Date actualEndDate, String content) {
//
//        try ( Connection connectionUpdate = getInterfaceConnection()) {
//            String sqlUpdate = "update [dbo].[Edit] set title=?, description=?, actualStartDate=?, actualEndDate=?, [content]=?  where  taskId=?";
//            PreparedStatement preparedStatementUpdate = connectionUpdate.prepareStatement(sqlUpdate);
//          //  preparedStatementUpdate.setInt(1, taskId);
//            preparedStatementUpdate.setString(1, title);
//            preparedStatementUpdate.setString(2, description);
//            preparedStatementUpdate.setDate(3, (Date) actualStartDate);
//            preparedStatementUpdate.setDate(4, (Date) actualEndDate);
//            preparedStatementUpdate.setString(5, content);
//
//            int rowEfected = preparedStatementUpdate.executeUpdate();
//            if (rowEfected > 0) {
//                System.out.println(Edit.class + " güncelleme başarılı");
//            } else {
//                System.out.println(Edit.class + " güncelle başarısız");
//            }
//        } catch (SQLException sqlException) {
//            sqlException.printStackTrace();
//        }
//
//    }
//    
    public Edit checktaskId(int taskId){
         try ( Connection connection = getInterfaceConnection()) {
            String sql = "select * from [dbo].[Edit] where taskId=? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, taskId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Edit edit = new Edit();

                edit.setTaskId(resultSet.getInt("taskId"));
                return edit;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " taskId getirme işlemi sırasında hata meydana geldi  ");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Edit edit) {
        try ( Connection connectionDelete = getInterfaceConnection()) {
            String sqlDelete = "delete from  [dbo].[Edit]  where  id=?";
            PreparedStatement preparedStatementDelete = connectionDelete.prepareStatement(sqlDelete);
            preparedStatementDelete.setInt(1, edit.getId());
            int rowEfected = preparedStatementDelete.executeUpdate();
            if (rowEfected > 0) {
                System.out.println(Edit.class + " silme başarılı");
            } else {
                System.out.println(Edit.class + " silme başarısız");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public ArrayList<Edit> getList() {
        ArrayList<Edit> editList = new ArrayList<>();
        try ( Connection connection = getInterfaceConnection()) {
            String sql = "select * from [dbo].[Edit]";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Edit edit = new Edit();
                edit.setId(resultSet.getInt("id"));
                edit.setUserId(resultSet.getInt("userId"));
                edit.setTaskId(resultSet.getInt("taskId"));
                edit.setCreatedBy(resultSet.getInt("createdBy"));
                edit.setUpdatedBy(resultSet.getInt("updatedBy"));
                edit.setTitle(resultSet.getString("title"));
                edit.setDescription(resultSet.getString("description"));
                edit.setStatus(resultSet.getInt("status"));
                edit.setCreatedAt(resultSet.getDate("createdAt"));
                edit.setUpdatedAt(resultSet.getDate("updatedAt"));
                edit.setPlannedStartDate(resultSet.getDate("plannedStartDate"));
                edit.setPlannedEndDate(resultSet.getDate("plannedEndDate"));
                edit.setActualStartDate(resultSet.getDate("actualStartDate"));
                edit.setActualEndDate(resultSet.getDate("actualEndDate"));
                edit.setContent(resultSet.getString("content"));

                editList.add(edit);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " Edit  işlemi sırasında hata meydana geldi  ");
            e.printStackTrace();
        }
        return editList;
    }

    @Override
    public Edit get(int id) {
        try ( Connection connection = getInterfaceConnection()) {
            String sql = "select * from [dbo].[Edit] where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Edit edit = new Edit();

                edit.setId(resultSet.getInt("id"));
                edit.setUserId(resultSet.getInt("userId"));
                edit.setTaskId(resultSet.getInt("taskId"));
                edit.setCreatedBy(resultSet.getInt("createdBy"));
                edit.setUpdatedBy(resultSet.getInt("updatedBy"));
                edit.setTitle(resultSet.getString("title"));
                edit.setDescription(resultSet.getString("description"));
                edit.setStatus(resultSet.getInt("status"));
                edit.setCreatedAt(resultSet.getDate("createdAt"));
                edit.setUpdatedAt(resultSet.getDate("updatedAt"));
                edit.setPlannedStartDate(resultSet.getDate("plannedStartDate"));
                edit.setPlannedEndDate(resultSet.getDate("plannedEndDate"));
                edit.setActualStartDate(resultSet.getDate("actualStartDate"));
                edit.setActualEndDate(resultSet.getDate("actualEndDate"));
                edit.setContent(resultSet.getString("content"));

                return edit;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " Edit  işlemi sırasında hata meydana geldi  ");
            e.printStackTrace();
        }
        return null;
    }


}
