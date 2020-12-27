import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class AdminView {
    private final static String masterVisitFilename = "MasterVisit";
    private final static String custViewFilename = "AdminCustView";
    private final static String shopViewFilename = "AdminShopView";

    public static void displayCustomer() throws Exception {
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

        Utils.displayExportCSVPrompt(col, hashMapCustomerList, custViewFilename);
        backMenu();
    }

    public static void displayShop() throws Exception {
        Utils.displayHeader("List of Shops Details");

        ArrayList<HashMap<String, String>> hashMapShopList = new ArrayList<HashMap<String, String>>();
        ArrayList<Shop> shopList = Utils.readListFromFile("shops");
        String[] col = { "No", "Name", "Phone", "Manager", "Status" };

        for (int i = 0; i < shopList.size(); i++) {
            int index = i + 1;
            HashMap<String, String> map = new HashMap<>();
            map.put("No", Integer.toString(index));
            map.put("Name", shopList.get(i).getName());
            map.put("Phone", shopList.get(i).getPhone());
            map.put("Manager", shopList.get(i).getManager());
            map.put("Status", shopList.get(i).getStatus());
            hashMapShopList.add(map);
        }
        Table.display(col, hashMapShopList);

        Utils.displayExportCSVPrompt(col, hashMapShopList, shopViewFilename);
        backMenu();

    }

    public static void displayMasterVisit() throws Exception {
        Utils.displayHeader("Master Visit History");

        ArrayList<HashMap<String, String>> hashMapMasterVisit = new ArrayList<HashMap<String, String>>();
        ArrayList<Visit> masterList = Utils.readListFromFile("visits");
        String[] col = { "No", "Date", "Time", "Customer", "Shop" };

        for (int i = 0; i < masterList.size(); i++) {
            int index = i + 1;
            HashMap<String, String> map = new HashMap<>();
            map.put("No", Integer.toString(index));
            map.put("Date", masterList.get(i).getDate());
            map.put("Time", masterList.get(i).getTime());
            map.put("Customer", masterList.get(i).getCustomer());
            map.put("Shop", masterList.get(i).getShop());
            hashMapMasterVisit.add(map);
        }
        Table.display(col, hashMapMasterVisit);

        Utils.displayExportCSVPrompt(col, hashMapMasterVisit, masterVisitFilename);
        backMenu();

    }

    private static void backMenu() throws Exception {

        System.out.println("--------------------------------------------------------------------");
        System.out.println("Please choose an option");
        System.out.println("1. Go Back to View Data Menu");
        System.out.println("2. Go to Main Menu");

        List<Integer> options = Arrays.asList(1, 2);
        int choice = Utils.getUserChoice(options);
        switch (choice) {
            case 1:
                AdminMain.view();
                break;
            case 2:
                AdminMain.adminMainMenu();
                break;
        }
    }
}