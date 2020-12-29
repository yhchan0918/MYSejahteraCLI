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
                    flagCustomer(choice - 1);
                    break;
                }
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

    private static void flagCustomer(int choice) throws Exception {

    }
}
