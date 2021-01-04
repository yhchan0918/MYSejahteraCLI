import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

public class UserMenu {
  private static Customer currentCustomer;
  private static Shop currentShop;
  private static ArrayList<Shop> shopslist;

  public static void main() throws Exception {
    System.out.println("Loading......");
    shopslist = Utils.readListFromFile(Record.SHOP_FILENAME);

    displayMainMenu();
  }

  public static void displayMainMenu() throws Exception {
    Utils.displayHeader("Welcome to Contact Tracing System For COVID-19");
    System.out.println("| Main Menu |");
    System.out.println("Please Type the No of your desired action and press ENTER to proceed");
    System.out.println("1. Sign In as Customer role");
    System.out.println("2. Sign In as Shop role");
    System.out.println("3. Register as New Customer");
    System.out.println("4. Exit Program");
    int choice = Utils.getUserChoice(1, 4);
    switch (choice) {
      case 1:
        signIn("Customer");
        break;
      case 2:
        signIn("Shop");
        break;
      case 3:
        register();
        break;
      case 4:
        System.out.println("Exit...");
        System.exit(0);
        break;
    }
  }

  private static void register() throws Exception {
    ArrayList<Customer> customerslist = Utils.readListFromFile(Record.CUSTOMER_FILENAME);
    Utils.displayHeader("Register As New Customer");
    Scanner input = new Scanner(System.in);
    System.out.println("Enter new customer name");
    String name = input.nextLine();
    System.out.println("Enter new customer phone number");
    String phone = input.nextLine();
    Customer newCustomer = new Customer(name, phone);
    customerslist.add(newCustomer);
    Utils.saveToFile(customerslist, Record.CUSTOMER_FILENAME);
    currentCustomer = newCustomer;
    System.out.println("Successfully Register!!" + "\n");
    displayCustomerMenu();
  }

  private static void signIn(String role) throws Exception {
    String title = "Sign In as " + role + " role";
    Utils.displayHeader(title);
    Scanner input = new Scanner(System.in);
    String prompt = role.equals("Customer") ? "Enter Your Name" : "Enter Your Shop Name";
    String name;
    while (true) {
      System.out.println(prompt + " (Note: Case Sensitive)");
      name = input.nextLine();

      if (validateUser(role, name)) {
        System.out.println("Successfully Login!!" + "\n");
        if (role.equals("Customer")) {
          displayCustomerMenu();
        } else {
          displayShopMenu();
        }
        break;
      } else {
        System.out.println("Invalid Credentials. Please Try Again");
        continue;
      }
    }
  }

  private static boolean validateUser(String role, String name) throws Exception {
    ArrayList<Customer> customerslist = Utils.readListFromFile(Record.CUSTOMER_FILENAME);
    if (role.equals("Customer")) {
      for (Customer customer : customerslist) {
        if (customer.getName().equals(name)) {
          currentCustomer = customer;
          return true;
        }
      }
      return false;
    } else {
      for (Shop shop : shopslist) {
        if (shop.getName().equals(name)) {
          currentShop = shop;
          return true;
        }
      }
      return false;
    }
  }

  private static void displayCustomerMenu() throws Exception {
    Utils.displayHeader("Customer Menu");
    System.out.println("Please Type the No of your desired action and press ENTER to proceed");
    System.out.println("1. Check In Shop");
    System.out.println("2. View the history of the shops you have visted");
    System.out.println("3. View Your Status");
    System.out.println("4. Logout");
    int choice = Utils.getUserChoice(1, 4);
    switch (choice) {
      case 1:
        checkIn();
        break;
      case 2:
        viewVisitsOfCustomer();
        break;
      case 3:
        viewCustomerStatus();
        break;
      case 4:
        displayMainMenu();
        break;
    }
  }

  private static void checkIn() throws Exception {
    ArrayList<Visit> visitslist = Utils.readListFromFile(Record.VISIT_FILENAME);
    int exitIndex = shopslist.size() + 1;
    Utils.displayHeader("Check In Shop");
    System.out.println(
        "Please Enter the No of the Shop you want to check in or Enter " + (exitIndex) + " to go back Customer Menu");
    for (int i = 0; i < shopslist.size(); i++) {
      int index = i + 1;

      System.out.println(index + ". " + shopslist.get(i).getName());
    }
    System.out.println(exitIndex + ". Go Back Customer Menu");
    int choice = Utils.getUserChoice(1, exitIndex);
    if (choice == (exitIndex)) {
      displayCustomerMenu();
    } else {
      Visit newVisit = new Visit(currentCustomer.getName(), shopslist.get(choice - 1).getName());
      visitslist.add(newVisit);
      Utils.saveToFile(visitslist, Record.VISIT_FILENAME);
<<<<<<< HEAD

      AdminFlag.closeContactTracing();

=======
      AdminFlag.closeContactTracing();
>>>>>>> afbf29eac6d10be74751ee097856c59b4f6dce54
      System.out.println(
          "Successfully Check In " + newVisit.getShop() + " On " + newVisit.getDate() + " At " + newVisit.getTime());
      displayGoBackMenu();
    }

  }

  private static void viewVisitsOfCustomer() throws Exception {
    Utils.displayHeader("View History of the shops you have visted");
    ArrayList<Visit> visitslist = Utils.readListFromFile(Record.VISIT_FILENAME);
    // Filter visitslist by currentCustomer name
    visitslist.removeIf(visit -> !(visit.getCustomer().equals(currentCustomer.getName())));

    // Check whether user have checked any shop
    if (visitslist.isEmpty()) {
      System.out.println("You have not checked in any shop yet");
    } else {
      // Convert ArrayList<Visit> to hashMap arraylist
      ArrayList<HashMap<String, String>> hashMapVisitsList = new ArrayList<HashMap<String, String>>();
      String[] colNamesList = { "No", "Date", "Time", "Shop" };
      for (int i = 0; i < visitslist.size(); i++) {
        int index = i + 1;
        HashMap<String, String> map = new HashMap<>();
        map.put("No", Integer.toString(index));
        map.put("Date", visitslist.get(i).getDate());
        map.put("Time", visitslist.get(i).getTime());
        map.put("Shop", visitslist.get(i).getShop());
        hashMapVisitsList.add(map);
      }
      // Print Table
      Table.display(colNamesList, hashMapVisitsList);
      // Display Export CSV Prompt
      Utils.displayExportCSVPrompt(colNamesList, hashMapVisitsList, currentCustomer.getName() + Record.VISIT_FILENAME);
    }

    displayGoBackMenu();
  }

  private static void viewCustomerStatus() throws Exception {
    AdminFlag.closeContactTracing();
    Utils.displayHeader("View Customer Status");
    System.out.println("Your Status: " + currentCustomer.getStatus());
    displayGoBackMenu();
  }

  private static void displayGoBackMenu() throws Exception {

    System.out.println("-------------------------------------------");
    System.out.println("Press Enter key to go back Customer Menu...");
    try {
      System.in.read();
      displayCustomerMenu();
    } catch (Exception e) {
    }
  }

  private static void displayShopMenu() {
    Utils.displayHeader("View Shop Status");
    System.out.println("Your Shop Status: " + currentShop.getStatus());
    System.out.println("---------------------------------------");
    System.out.println("Press Enter key to go back Main Menu...");
    try {
      System.in.read();
      displayMainMenu();
    } catch (Exception e) {
    }
  }
}
