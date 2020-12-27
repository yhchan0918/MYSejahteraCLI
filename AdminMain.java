import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

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
                viewMenu();
                break;
            case 2:
                flagMenu();
                break;
            case 3:
                break;
        }
    }

    public static void viewMenu() throws Exception {
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

    private static void flagMenu() throws Exception {
        Utils.displayHeader("Flag Menu");
        System.out.println("Please type in the No of Customer that you want to flag");

        ArrayList<Customer> customerList = Utils.readListFromFile(Record.customerFilename);
        List<Integer> options = new ArrayList<Integer>();

        for (int i = 0; i < customerList.size(); i++) {
            int index = i + 1;
            options.add(index);
            System.out.println(index + ". " + customerList.get(i).getName());
        }
        int choice = Utils.getUserChoice(options);

    }
}
