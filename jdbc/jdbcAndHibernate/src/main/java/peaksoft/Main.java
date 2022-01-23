package peaksoft;

import peaksoft.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserServiceImpl service = new UserServiceImpl();
        service.createUsersTable();
        service.saveUser("Kutubek","Gaparov", (byte) 17);
        service.saveUser("Zhanarbek","Abdurasulov", (byte) 18);
        service.saveUser("Omurbek","Egemberdiev", (byte) 40);
        service.saveUser("Azamat","Muratov", (byte) 30);
        service.saveUser("Nurlan","Atayatov", (byte) 24);
        service.saveUser("Bektur","Tashmatov", (byte) 19);

        //service.removeUserById(1);
        System.out.println(service.getAllUsers());
       // service.cleanUsersTable();
        //service.dropUsersTable();

    }
}
