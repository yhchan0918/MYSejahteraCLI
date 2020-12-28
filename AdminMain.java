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

        ArrayList<Customer> customerList = Utils.readListFromFile(Record.customerFilename);

        displayFlagList(customerList); // display all customers

        while (true) {
            System.out.println("Please type in the No of Customer that you want to flag");
            int choice = Utils.getUserChoice(1, customerList.size());

            if (customerList.get(choice - 1).getStatus().equals("Case")) {
                System.out.println("Error, the current Customer of choice is already flagged as \"Case\"");
                continue;
            } else {
                flag(choice - 1);
                break;
            }
        }
    }

    private static void displayFlagList(ArrayList<Customer> customerList) throws Exception {
        ArrayList<HashMap<String, String>> hashMapCustomerList = new ArrayList<HashMap<String, String>>();
        String[] col = { "No", "Name", "Status" };

        for (int i = 0; i < customerList.size(); i++) {
            int index = i + 1;
            HashMap<String, String> map = new HashMap<>();
            map.put("No", Integer.toString(index));
            map.put("Name", customerList.get(i).getName());
            map.put("Status", customerList.get(i).getStatus());
            hashMapCustomerList.add(map);
        }
        Table.display(col, hashMapCustomerList);
    }

    private static void flag(int choice) throws Exception {
        System.out.println("wassup shabi im flagging");
    }
}
