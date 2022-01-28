package peaksoft.dao;

import org.hibernate.Session;
import peaksoft.model.User;
import peaksoft.util.Util;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {
    }
    @Override
    public void createUsersTable() {
        try {
            Session session = Util.getSession().openSession();
            session.beginTransaction();
            session.getTransaction().commit();
            session.close();
            System.out.println("creat table successfully");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void saveUser(String name, String lastName, byte age) {

        try {
            User user = new User(name, lastName, age);
            Session session = Util.getSession().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void dropUsersTable() {
        try {
            Session session = Util.getSession().openSession();
            session.beginTransaction();

            session.createSQLQuery("drop table users").executeUpdate();

            session.getTransaction().commit();
            session.close();
            System.out.println("Drop User table successfully");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void removeUserById(long id) {
        try {
            Session session = Util.getSession().openSession();
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
            session.close();
            System.out.println("remove User By Id successfully" + user);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
            Session session = Util.getSession().openSession();
            session.beginTransaction();
             List<User> userList = session.createQuery("from User").list();
            session.getTransaction().commit();
            session.close();
            System.out.println("Finded : " + userList.size() + "users");

            return userList;
        }catch (Exception r ){
            System.out.println(r.getMessage());
        }
        return null;

    }
    @Override
    public void cleanUsersTable() {
        try {
            Session session = Util.getSession().openSession();
            session.beginTransaction();
            session.createQuery("delete  User").executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("Clean Users Table successfully");
        }catch (Exception e ){
            System.out.println(e.getMessage());
        }
    }
}