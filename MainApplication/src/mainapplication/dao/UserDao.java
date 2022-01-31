/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mainapplication.model.User;

/**
 *
 * @author SERGEN
 */
public class UserDao implements IDaoConnection<User> {

    @Override
    public void create(User user) {
        try ( Connection connection = getInterfaceConnection()) {
            String sql = "insert into [dbo].[User] (roleId,firstName,lastName,username,passwordHash) values(?,?,?,?,?); ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user.getroleId());
            preparedStatement.setString(2, user.getfirstName());
            preparedStatement.setString(3, user.getlastName());
            preparedStatement.setString(4, user.getusername());
            preparedStatement.setInt(5, user.getpassword());
            int rowEfected = preparedStatement.executeUpdate();
            if (rowEfected > 0) {
                System.out.println(User.class + " ekleme başarılı");
            } else {
                System.out.println(User.class + " ekleme başarısız");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        try ( Connection connectionUpdate = getInterfaceConnection()) {
            String sqlUpdate = "update [dbo].[User] set  roleId=?,firstName=?,lastName=?,username=?,password=?  where  id=?";
            PreparedStatement preparedStatementUpdate = connectionUpdate.prepareStatement(sqlUpdate);
            preparedStatementUpdate.setInt(1, user.getroleId());
            preparedStatementUpdate.setString(2, user.getfirstName());
            preparedStatementUpdate.setString(3, user.getlastName());
            preparedStatementUpdate.setString(4, user.getusername());
            preparedStatementUpdate.setInt(5, user.getpassword());
            preparedStatementUpdate.setInt(6, user.getid());
            int rowEfected = preparedStatementUpdate.executeUpdate();
            if (rowEfected > 0) {
                System.out.println(User.class + " güncelleme başarılı");
            } else {
                System.out.println(User.class + " güncelle başarısız");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void delete(User user) {
        try ( Connection connectionDelete = getInterfaceConnection()) {
            String sqlDelete = "delete from  [dbo].[User]  where  id=?";
            PreparedStatement preparedStatementDelete = connectionDelete.prepareStatement(sqlDelete);
            preparedStatementDelete.setInt(1, user.getid());
            int rowEfected = preparedStatementDelete.executeUpdate();
            if (rowEfected > 0) {
                System.out.println(User.class + " silme başarılı");
            } else {
                System.out.println(User.class + " silme başarısız");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public ArrayList<User> getList() {
        ArrayList<User> userList = new ArrayList<>();
        try ( Connection connection = getInterfaceConnection()) {
            String sql = "select * from [dbo].[User]";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();

                user.setId(resultSet.getInt("id"));
                user.setPassword(resultSet.getInt("password"));
                user.setRoleId(resultSet.getInt("roleId"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));
                user.setUsername(resultSet.getString("username"));

                userList.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " User Listeleme işlemi sırasında hata meydana geldi  ");
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User get(int id) {

        try ( Connection connection = getInterfaceConnection()) {
            String sql = "select * from [dbo].[User] where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User();

                user.setId(resultSet.getInt("id"));
                user.setPassword(resultSet.getInt("password"));
                user.setRoleId(resultSet.getInt("roleId"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));

                return user;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " User getirme işlemi sırasında hata meydana geldi  ");
            e.printStackTrace();
        }
        return null;
    }
    
    public User getUserWithPasswordAndUsername(int password, String username){
        
        try ( Connection connection = getInterfaceConnection()) {
            String sql = "select * from [dbo].[User] where password=? and  username=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, password);
            preparedStatement.setString(2, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User();

                user.setId(resultSet.getInt("id"));
                user.setPassword(resultSet.getInt("password"));
                user.setRoleId(resultSet.getInt("roleId"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));
                user.setLastName(resultSet.getString("lastName"));
                user.setUsername(resultSet.getString("username"));

                return user;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " User getirme işlemi sırasında hata meydana geldi  ");
            e.printStackTrace();
        }
        return null;
        
    }
}
