import java.util.HashMap;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class AdminFlag {

  public static void menu() throws Exception {
    Utils.displayHeader("Flag Menu");

    ArrayList<Customer> customerList = Utils.readListFromFile(Record.CUSTOMER_FILENAME);

    displayFlagList(customerList); // display all customers

    while (true) {
      System.out.println("Please type in the No of Customer that you want to flag or Press 0 to Go Back to Main Menu");
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
    Utils.saveToFile(customerList, Record.CUSTOMER_FILENAME);

    closeContactTracing();

    customerList = Utils.readListFromFile(Record.CUSTOMER_FILENAME);
    Utils.displayHeader("Flag Menu");
    displayFlagList(customerList);

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

    ArrayList<Visit> caseVisitList = new ArrayList<Visit>(); // Declare empty ArrayList to store cased data
    ArrayList<String> caseShopNameList = new ArrayList<String>();
    ArrayList<String> caseCustomerNameList = new ArrayList<String>();
    ArrayList<String> closeCustomerNameList = new ArrayList<String>();

    caseCustomerNameList = getCaseCustomerName(customerList); // Process
    caseVisitList = getCaseVisitList(visitList, caseCustomerNameList);
    caseShopNameList = getCaseShopName(caseVisitList);
    closeCustomerNameList = getCloseCustomerName(visitList, caseVisitList);

    shopList = flagCaseShop(shopList, caseShopNameList); // Flag
    customerList = flagCloseCustomer(customerList, closeCustomerNameList);

    Utils.saveToFile(customerList, Record.CUSTOMER_FILENAME);
    Utils.saveToFile(shopList, Record.SHOP_FILENAME);
    Utils.saveToFile(visitList, Record.VISIT_FILENAME);
  }

  private static ArrayList<String> getCaseCustomerName(ArrayList<Customer> custList) {
    ArrayList<String> caseCustNameList = new ArrayList<String>();

    for (int i = 0; i < custList.size(); i++) {
      if (custList.get(i).getStatus().equals("Case")) {
        caseCustNameList.add(custList.get(i).getName());
      }
    }

    return caseCustNameList;
  }

  private static ArrayList<Visit> getCaseVisitList(ArrayList<Visit> visitList, ArrayList<String> caseCustName) {
    ArrayList<Visit> caseVisitList = new ArrayList<Visit>();

    for (int i = 0; i < visitList.size(); i++) {
      for (int j = 0; j < caseCustName.size(); j++) {
        if (caseCustName.get(j).equals(visitList.get(i).getCustomer())) {
          caseVisitList.add(visitList.get(i));
        }
      }
    }
    return caseVisitList;
  }

  private static ArrayList<String> getCaseShopName(ArrayList<Visit> caseVisitList) {
    ArrayList<String> caseShopNameList = new ArrayList<String>();

    for (int i = 0; i < caseVisitList.size(); i++) {
      caseShopNameList.add(caseVisitList.get(i).getShop());
    }
    return caseShopNameList;
  }

  private static ArrayList<String> getCloseCustomerName(ArrayList<Visit> visitList, ArrayList<Visit> caseVisitList) {
    ArrayList<String> closeCustNameList = new ArrayList<String>();

    for (int i = 0; i < visitList.size(); i++) {
      for (int j = 0; j < caseVisitList.size(); j++) {
        if (notCaseVisit(visitList.get(i), caseVisitList.get(j))
            && sameShop(visitList.get(i).getShop(), caseVisitList.get(j).getShop())
            && timeInterval(visitList.get(i).getCheckInTime(), caseVisitList.get(j).getCheckInTime())) {
          closeCustNameList.add(visitList.get(i).getCustomer());
        }
      }
    }
    return closeCustNameList;
  }

  private static boolean notCaseVisit(Visit visit, Visit caseVisit) {
    return !(visit.equals(caseVisit));
  }

  private static boolean sameShop(String shop, String caseShop) {
    return (shop.equals(caseShop));
  }

  private static boolean timeInterval(LocalDateTime visitTime, LocalDateTime caseVisitTime) {
    if (visitTime.isAfter(caseVisitTime.plusHours(1)) || visitTime.isBefore(caseVisitTime.minusHours(1))) {
      return false;
    }
    return true;
  }

  private static ArrayList<Shop> flagCaseShop(ArrayList<Shop> shopList, ArrayList<String> caseShopName) {
    for (int i = 0; i < shopList.size(); i++) {
      for (int j = 0; j < caseShopName.size(); j++) {
        if (caseShopName.get(j).equals(shopList.get(i).getName())) {

          shopList.get(i).setStatus("Case");
        }
      }
    }
    return shopList;
  }

  private static ArrayList<Customer> flagCloseCustomer(ArrayList<Customer> custList, ArrayList<String> closeCustName) {
    for (int i = 0; i < custList.size(); i++) {
      for (int j = 0; j < closeCustName.size(); j++) {
        if (closeCustName.get(j).equals(custList.get(i).getName()) && custList.get(i).getStatus().equals("Normal")) {

          custList.get(i).setStatus("Close");
        }
      }
    }
    return custList;
  }

}
