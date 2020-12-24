import java.util.Scanner;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class UserMain {
  private static Customer currentCustomer;
  private static Shop currentShop;

  public static void main(String[] args) throws Exception {
    displayMainMenu();

  }

  private static void displayMainMenu() throws Exception {
    Utils.displayHeader("Welcome to Contact Tracing System For COVID-19");
    System.out.println("| Main Menu |");
    System.out.println("Please Type the No of your desired action and press ENTER to proceed");
    System.out.println("1. Sign In as Customer role");
    System.out.println("2. Sign In as Shop role");
    System.out.println("3. Register");

    List<Integer> options = Arrays.asList(1, 2, 3);
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
        System.out.println("Successfully Login");
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
    Utils.displayHeader("Register as new customer");
    ArrayList<Customer> customerslist = Utils.readListFromFile("customers");
    Scanner input = new Scanner(System.in);

    System.out.println("Enter New Customer Name");
    String name = input.nextLine();
    System.out.println("Enter New Customer Phone Number");
    String phone = input.nextLine();
    customerslist.add(new Customer(name, phone));
    Utils.saveToFile(customerslist, "customers");
    displayCustomerMenu();
  }

  private static boolean validateUser(String role, String name) throws Exception {
    if (role.equals("Customer")) {
      ArrayList<Customer> list = Utils.readListFromFile("customers");

      for (Customer customer : list) {
        if (customer.getName().equals(name)) {
          currentCustomer = customer;
          System.out.println(currentCustomer);
          return true;
        }
      }
      return false;
    } else {
      ArrayList<Shop> list = Utils.readListFromFile("shops");
      for (Shop shop : list) {
        if (shop.getName().equals(name)) {
          currentShop = shop;
          System.out.println(currentShop);
          return true;
        }
      }
      return false;
    }
  }

  private static void displayCustomerMenu() {
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

  private static void checkIn() {
    Utils.displayHeader("Check In Shop");
  }

  private static void viewVisitsOfCustomer() {
    Utils.displayHeader("View History of the shops you have visted");
  }

  private static void viewCustomerStatus() {
    Utils.displayHeader("View Customer Status");
  }

  private static void displayShopMenu() {
    Utils.displayHeader("View Shop Status");
    System.out.println("Your Shop Status: " + currentShop.getStatus());
  }

}