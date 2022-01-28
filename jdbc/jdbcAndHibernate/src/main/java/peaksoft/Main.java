package peaksoft;

import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Scanner s = new Scanner(System.in);
    static Scanner s1 = new Scanner(System.in);

    public static void main(String[] args) {
        UserService service = new UserServiceImpl();
        while (true) {
            try {
                commands();
                int number = scanner.nextInt();

                if (number > 0 && number < 7) {

                    switch (number) {
                        case 1:
                            service.createUsersTable();
                            break;
                        case 2:
                            System.out.println("name");
                            String a = s1.nextLine();
                            System.out.println("lastName");
                            String b = s1.nextLine();
                            System.out.println("Age");
                            int c = s.nextByte();
                            service.saveUser(a, b, (byte) c);
                            break;
                        case 3:
                            int i = scanner.nextInt();
                            service.removeUserById(i);
                            break;
                        case 4:
                            System.out.println(service.getAllUsers());
                            break;
                        case 5:
                            service.cleanUsersTable();
                            break;
                        case 6:
                            service.dropUsersTable();
                            break;
                        default:
                            break;
                    }
                } else {
                    break;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void commands() {
        System.out.println("print 1 to creat users table");
        System.out.println("print 2 to save users table");
        System.out.println("print 3 to remove By Id");
        System.out.println("print 4 to get All users");
        System.out.println("print 5 to clean users table");
        System.out.println("print 6 to drop users table");


    }
}
