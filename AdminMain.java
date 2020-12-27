import java.util.List;
import java.util.Arrays;

public class AdminMain {
    public static void main(String[] args) throws Exception {

        adminMainMenu();
    }

    public static void adminMainMenu() throws Exception {
        Utils.displayHeader("Welcome back admin");
        System.out.println("Please choose an action");
        System.out.println("1. View Data");
        System.out.println("2. Flag");
        System.out.println("3. Exit");

        List<Integer> options = Arrays.asList(1, 2, 3);
        int choice = Utils.getUserChoice(options);
        switch (choice) {
            case 1:
                view();
                break;
            case 2:
                flag();
                break;
            case 3:
                break;
        }
    }

    public static void view() throws Exception {
        Utils.displayHeader("View Data Menu");
        System.out.println("Please choose an option");
        System.out.println("1. Customers Details");
        System.out.println("2. Shops Details");
        System.out.println("3. Master Visit History");
        System.out.println("4. Back");

        List<Integer> options = Arrays.asList(1, 2, 3, 4);
        int choice = Utils.getUserChoice(options);
        switch (choice) {
            case 1:
                AdminView.displayCustomer();
                break;
            case 2:
                AdminView.displayShop();
                break;
            case 3:
                AdminView.displayMasterVisit();
                break;
            case 4:
                adminMainMenu();
                break;
        }
    }

    private static void flag() {

    }
}
