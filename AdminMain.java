import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class AdminMain {
    public static void main(String[] args) throws Exception {

        adminMainMenu();
    }

    private static void adminMainMenu() throws Exception {
        Utils.displayHeader("Welcome back admin");
        System.out.println("Please choose an action");
        System.out.println("1. View Data");
        System.out.println("2. Flag");
        System.out.println("3. Generate random visits");
        System.out.println("4. Exit");

        List<Integer> options = Arrays.asList(1, 2, 3, 4);
        int choice = Utils.getUserChoice(options);
        switch (choice) {
            case 1:
                view();
                break;
            case 2:
                flag();
                break;
            case 3:
                generate();
                break;
            case 4:
                break;
        }
    }

    private static void view() throws Exception {
        Utils.displayHeader("View Data Menu");
        System.out.println("Please choose an option");
        System.out.println("1. Customers Details");
        System.out.println("2. Shops Details");
        System.out.println("3. Generate random visits");
        System.out.println("4. Back");

        List<Integer> options = Arrays.asList(1, 2, 3, 4);
        int choice = Utils.getUserChoice(options);
        switch (choice) {
            case 1:
                // customer view by admin
                break;
            case 2:
                // shop view by admin
                break;
            case 3:
                // master view
                break;
            case 4:
                adminMainMenu();
                break;
        }
    }

    private static void flag() {
        System.out.println("flag someone");
    }

    private static void generate() {
        System.out.println("generate 30 visits");
    }
}
