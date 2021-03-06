package peaksoft.dao;

import peaksoft.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static peaksoft.util.Util.connection;

public class UserDaoJdbcImpl implements UserDao {
    public UserDaoJdbcImpl() {
    }
    public void createUsersTable() {
        try (Connection conn = connection();
             Statement statement = conn.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT exists users(id serial primary key , name varchar, lastname varchar,age int)");
            System.out.println("Creat User Table successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void dropUsersTable() {
        try (Connection conn = connection();
             Statement statement = conn.createStatement()) {
            String SQL = "DROP TABLE IF  exists users";
            statement.executeUpdate(SQL);

            System.out.println("Drop Table successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void saveUser(String name, String lastName, byte age) {
        String SQL =( "INSERT  INTO users(name ,lastName ,age) VALUES (?,?,?)");

        try (Connection conn = connection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void removeUserById(long id) {
        String SQL = "DELETE FROM users where id = (?)";

        try (Connection conn = connection()) {
            PreparedStatement statement = conn.prepareStatement(SQL);
            statement.setLong(1,id);
            statement.executeUpdate();
            System.out.println("remove User By Id successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        String SQL = "SELECT * FROM users ";
        try (Connection conn = connection();
             Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge(resultSet.getByte(4));
                list.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    public void cleanUsersTable() {
        try (Connection conn = connection();
             Statement statement = conn.createStatement()) {
            String SQL = "delete from users ";
            statement.executeUpdate(SQL);
            System.out.println("Clean User table successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}