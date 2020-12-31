import java.util.HashMap;
import java.util.ArrayList;
import java.time.LocalDateTime;

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

        ArrayList<Visit> caseVisitList = new ArrayList<Visit>(); // Declare a empty ArrayList to store cased data

        for (int i = 0; i < customerList.size(); i++) { // Find cased Customer
            if (customerList.get(i).getStatus().equals("Case")) {

                for (int j = 0; j < visitList.size(); j++) { // Find cased Customer's Visit
                    if (visitList.get(j).getCustomer().equals(customerList.get(i).getName())) {
                        caseVisitList.add(visitList.get(j));
                    }
                }
            }
        }

        for (int i = 0; i < caseVisitList.size(); i++) {
            for (int j = 0; j < shopList.size(); j++) { // Find shop of Visit and Flag
                if (shopList.get(j).getName().equals(caseVisitList.get(i).getShop())) {
                    shopList.get(j).setStatus("Case");
                }
            }

            for (int j = 0; j < visitList.size(); j++) { // Find time of Interval and Flag
                if (notCaseVisit(visitList.get(j), caseVisitList)
                        && inBetweenVisit(visitList.get(j).getCheckInTime(), caseVisitList.get(i).getCheckInTime())) {

                    for (int k = 0; k < customerList.size(); k++) {
                        if (customerList.get(j).getName().equals(visitList.get(j).getCustomer())) {
                            customerList.get(j).setStatus("Close");
                        }
                    }
                }
            }
        }
        Utils.saveToFile(customerList, Record.CUSTOMER_FILENAME);
        Utils.saveToFile(shopList, Record.SHOP_FILENAME);
        Utils.saveToFile(visitList, Record.VISIT_FILENAME);
    }

    private static boolean notCaseVisit(Visit visit, ArrayList<Visit> caseVisitList) {
        for (int i = 0; i < caseVisitList.size(); i++) {
            if (visit.equals(caseVisitList.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean inBetweenVisit(LocalDateTime visit, LocalDateTime caseVisit) {
        return !(visit.isAfter(caseVisit.plusHours(1)) && visit.isBefore(caseVisit.minusHours(1)));
    }
}
