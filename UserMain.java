import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

public class UserMain {
  private static Customer currentCustomer;
  private static Shop currentShop;
  private static ArrayList<Shop> shopslist;

  public static void main(String[] args) throws Exception {
    System.out.println("Loading......");
    shopslist = Utils.readListFromFile(Record.shopFilename);

    displayMainMenu();

  }

  private static void displayMainMenu() throws Exception {
    Utils.displayHeader("Welcome to Contact Tracing System For COVID-19");
    System.out.println("| Main Menu |");
    System.out.println("Please Type the No of your desired action and press ENTER to proceed");
    System.out.println("1. Sign In as Customer role");
    System.out.println("2. Sign In as Shop role");
    System.out.println("3. Register as New Customer");
    System.out.println("4. Exit Program");
    List<Integer> options = Arrays.asList(1, 2, 3, 4);
    int choice = Utils.getUserChoice(options);
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

  private static void signIn(String role) throws Exception {
    String title = "Sign In as " + role + " role";
    Utils.displayHeader(title);
    Scanner input = new Scanner(System.in);
    String prompt = role.equals("Customer") ? "Enter Your Name" : "Enter Your Shop Name";

    while (true) {
      System.out.println(prompt + " (Note: Case Sensitive)");
      String name = input.nextLine();

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

  private static void register() throws Exception {
    ArrayList<Customer> customerslist = Utils.readListFromFile(Record.customerFilename);
    Utils.displayHeader("Register As New Customer");
    Scanner input = new Scanner(System.in);
    System.out.println("Enter new customer name");
    String name = input.nextLine();
    System.out.println("Enter new customer phone number");
    String phone = input.nextLine();
    Customer newCustomer = new Customer(name, phone);
    customerslist.add(newCustomer);
    Utils.saveToFile(customerslist, Record.customerFilename);
    currentCustomer = newCustomer;
    System.out.println("Successfully Register!!" + "\n");
    displayCustomerMenu();
  }

  private static boolean validateUser(String role, String name) throws Exception {
    ArrayList<Customer> customerslist = Utils.readListFromFile(Record.customerFilename);
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
    List<Integer> options = Arrays.asList(1, 2, 3);
    int choice = Utils.getUserChoice(options);
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
    }
  }

  private static void checkIn() throws Exception {
    ArrayList<Visit> visitslist = Utils.readListFromFile(Record.visitFilename);
    Utils.displayHeader("Check In Shop");
    System.out.println("Please Type the No of the Shop you want to check in");
    List<Integer> options = new ArrayList<Integer>();
    for (int i = 0; i < shopslist.size(); i++) {
      int index = i + 1;
      options.add(index);
      System.out.println(index + ". " + shopslist.get(i).getName());
    }
    int choice = Utils.getUserChoice(options);
    visitslist.add(new Visit(currentCustomer.getName(), shopslist.get(choice - 1).getName()));
    Utils.saveToFile(visitslist, Record.visitFilename);
    System.out.println("Successfully Check In!!");
    displayGoBackMenu();
  }

  private static void viewVisitsOfCustomer() throws Exception {
    Utils.displayHeader("View History of the shops you have visted");
    ArrayList<Visit> visitslist = Utils.readListFromFile(Record.visitFilename);
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
      Utils.displayExportCSVPrompt(colNamesList, hashMapVisitsList, currentCustomer.getName() + Record.visitFilename);
    }

    displayGoBackMenu();
  }

  private static void viewCustomerStatus() throws Exception {
    Utils.displayHeader("View Customer Status");
    System.out.println("Your Status: " + currentCustomer.getStatus());
    displayGoBackMenu();
  }

  private static void displayGoBackMenu() throws Exception {

    System.out.println("--------------------------------------------------------------------");
    System.out.println("Please Type the No of your desired action and press ENTER to proceed");
    System.out.println("1. Go Back Customer Menu");
    System.out.println("2. Go To Main Menu");

    List<Integer> options = Arrays.asList(1, 2);
    int choice = Utils.getUserChoice(options);
    switch (choice) {
      case 1:
        displayCustomerMenu();
        break;
      case 2:
        displayMainMenu();
        break;
    }
  }

  private static void displayShopMenu() {
    Utils.displayHeader("View Shop Status");
    System.out.println("Your Shop Status: " + currentShop.getStatus());
    System.out.println("Press Enter key to go back Main Menu...");
    try {
      System.in.read();
      displayMainMenu();
    } catch (Exception e) {
    }
  }

}