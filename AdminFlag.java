import java.util.HashMap;
import java.util.ArrayList;

public class AdminFlag {
    public static void menu() throws Exception {
        Utils.displayHeader("Flag Menu");

        ArrayList<Customer> customerList = Utils.readListFromFile(Record.CUSTOMER_FILENAME);

        displayFlagList(customerList); // display all customers

        while (true) {
            System.out.println(
                    "Please type in the No of Customer that you want to flag or Press 0 to Go Back to Main Menu");
            int choice = Utils.getUserChoice(0, customerList.size());

            if (choice == 0) {
                AdminMain.menu();
                break;
            } else {
                if (customerList.get(choice - 1).getStatus().equals("Case")) {
                    System.out.println("Error, the current Customer of choice is already flagged as \"Case\"");
                    continue;
                } else {
                    flagCustomer(customerList, choice - 1);
                    break;
                }
            }
        }
        backMenu();
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

    private static void flagCustomer(ArrayList<Customer> customerList, int choice) throws Exception {
        customerList.get(choice).setStatus("Case");

        Utils.displayHeader("Flag Menu");
        displayFlagList(customerList);
        Utils.saveToFile(customerList, Record.CUSTOMER_FILENAME);

        System.out.println("\nSuccessfully Flagged " + customerList.get(choice).getName() + " as \"Case\"");
    }

    private static void backMenu() throws Exception {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Press Enter to return to Main Menu");

        try {
            System.in.read();
        } catch (Exception e) {
            System.out.println("Please press Enter to return to Main Menu ");
        }

        AdminMain.menu();
    }
}