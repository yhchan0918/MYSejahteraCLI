import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
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
                customerView();
                break;
            case 2:
                shopView();
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

        // 1. after flagging a customer as case, need to all checking
        // 2. after adding a new visit manually (UserMain)
    }

    private static void generate() {
        System.out.println("generate 30 visits");
    }

    private static void customerView() throws Exception {
        Utils.displayHeader("List of Customers Details");

        // Convert ArrayList<> to hashMap AryList for displaying data
        ArrayList<HashMap<String, String>> hashMapCustomerList = new ArrayList<HashMap<String, String>>();
        ArrayList<Customer> customerList = Utils.readListFromFile("customers");
        String[] col = { "No", "Name", "Phone", "Status" };

        for (int i = 0; i < customerList.size(); i++) {
            int index = i + 1;
            HashMap<String, String> map = new HashMap<>();
            map.put("No", Integer.toString(index));
            map.put("Name", customerList.get(i).getName());
            map.put("Phone", customerList.get(i).getPhone());
            map.put("Status", customerList.get(i).getStatus());
            hashMapCustomerList.add(map);
        }
        Table.display(col, hashMapCustomerList);

        // goBack 2.0 with csv output
    }

    private static void shopView() throws Exception {
        // same thinggy
    }

    // closeContactTracing in Utils.java
}
