import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class AdminView {
  private final static String MASTER_VIEW_FILENAME = "MasterVisit";
  private final static String CUST_VIEW_FILENAME = "AdminCustView";
  private final static String SHOP_VIEW_FILENAME = "AdminShopView";

  public static void menu() throws Exception {
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
        displayCustomer();
        break;
      case 2:
        displayShop();
        break;
      case 3:
        displayMasterVisit();
        break;
      case 4:
        AdminMain.menu();
        break;
    }
  }

  private static void displayCustomer() throws Exception {
    Utils.displayHeader("List of Customers Details");

    // Convert ArrayList<> to hashMap AryList for displaying data
    ArrayList<HashMap<String, String>> hashMapCustomerList = new ArrayList<HashMap<String, String>>();
    ArrayList<Customer> customerList = Utils.readListFromFile(Record.CUSTOMER_FILENAME);
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

    Utils.displayExportCSVPrompt(col, hashMapCustomerList, CUST_VIEW_FILENAME);
    goBackMenu();
  }

  private static void displayShop() throws Exception {
    Utils.displayHeader("List of Shops Details");

    ArrayList<HashMap<String, String>> hashMapShopList = new ArrayList<HashMap<String, String>>();
    ArrayList<Shop> shopList = Utils.readListFromFile(Record.SHOP_FILENAME);
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

    Utils.displayExportCSVPrompt(col, hashMapShopList, SHOP_VIEW_FILENAME);
    goBackMenu();

  }

  private static void displayMasterVisit() throws Exception {
    Utils.displayHeader("Master Visit History");

    ArrayList<HashMap<String, String>> hashMapMasterVisit = new ArrayList<HashMap<String, String>>();
    ArrayList<Visit> masterList = Utils.readListFromFile(Record.VISIT_FILENAME);
    if (masterList.isEmpty()) {
      System.out.println("There is no Master Visit record yet");
    } else {
      String[] col = { "No", "Date", "Time", "Customer", "Customer Status", "Shop", "Shop Status" };

      for (int i = 0; i < masterList.size(); i++) {
        int index = i + 1;
        HashMap<String, String> map = new HashMap<>();
        map.put("No", Integer.toString(index));
        map.put("Date", masterList.get(i).getDate());
        map.put("Time", masterList.get(i).getTime());
        map.put("Customer", masterList.get(i).getCustomer());
        map.put("Customer Status", getCustStatus(masterList.get(i).getCustomer()));
        map.put("Shop", masterList.get(i).getShop());
        map.put("Shop Status", getShopStatus(masterList.get(i).getShop()));
        hashMapMasterVisit.add(map);
      }
      Table.display(col, hashMapMasterVisit);

      Utils.displayExportCSVPrompt(col, hashMapMasterVisit, MASTER_VIEW_FILENAME);
    }

    goBackMenu();

  }

  private static String getCustStatus(String name) throws Exception {
    ArrayList<Customer> custList = Utils.readListFromFile(Record.CUSTOMER_FILENAME);
    for (int i = 0; i < custList.size(); i++) {
      if (name.equals(custList.get(i).getName())) {
        return custList.get(i).getStatus();
      }
    }
    return "null"; // invalid
  }

  private static String getShopStatus(String name) throws Exception {
    ArrayList<Shop> shopList = Utils.readListFromFile(Record.SHOP_FILENAME);
    for (int i = 0; i < shopList.size(); i++) {
      if (name.equals(shopList.get(i).getName())) {
        return shopList.get(i).getStatus();
      }
    }
    return "null"; // invalid
  }

  private static void goBackMenu() throws Exception {
    System.out.println("--------------------------------------------------------------------");
    System.out.println("Please choose an option");
    System.out.println("1. Go Back to View Data Menu");
    System.out.println("2. Go to Main Menu");

    List<Integer> options = Arrays.asList(1, 2);
    int choice = Utils.getUserChoice(options);
    switch (choice) {
      case 1:
        menu();
        break;
      case 2:
        AdminMain.menu();
        break;
    }
  }
}