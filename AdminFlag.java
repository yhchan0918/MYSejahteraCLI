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
        closeContactTracing();

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

    public static void closeContactTracing() throws Exception {
        ArrayList<Customer> customerList = Utils.readListFromFile(Record.CUSTOMER_FILENAME);
        ArrayList<Shop> shopList = Utils.readListFromFile(Record.SHOP_FILENAME);
        ArrayList<Visit> visitList = Utils.readListFromFile(Record.VISIT_FILENAME);

        // ArrayList<Visit> caseList = new ArrayList<Visit>(); // Declare a empty
        // ArrayList to store cased Visits

        for (int i = 0; i < customerList.size(); i++) { // Find cased Customer
            if (customerList.get(i).getStatus().equals("Case")) {

                for (int j = 0; j < visitList.size(); j++) { // Find cased Customer's Visit
                    if (visitList.get(j).getCustomer().equals(customerList.get(i).getName())) {
                        // caseList.add(visitList.get(j));

                        for (int k = 0; k < shopList.size(); k++) { // Find shop of Visit and Flag
                            if (shopList.get(k).getName().equals(visitList.get(j).getShop())) {
                                shopList.get(k).setStatus("Case");

                                for (int l = 0; l < visitList.size(); l++) { // Find time interval of other shop Visits
                                    // if (visitList.get(l).getTime() > visitList.get(j).getTime())
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    // compareTo
}
