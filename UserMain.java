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
      String name = input.nextLine(); // read away unwanted newline.
      if (role.equals("Customer")) {
        if (validateCustomer(name)) {
          System.out.println("Successfully Login");
          break;
        } else {
          System.out.println("Invalid Credentials. Please Try Again");
          continue;
        }
      } else {
        System.out.println("shop");
      }
    }

  }

  private static boolean validateCustomer(String name) throws Exception {
    ArrayList<Customer> list = Utils.readListFromFile("customers");

    for (Customer customer : list) {
      if (customer.getName().equals(name)) {
        System.out.println("imcalled");
        return true;
      }

    }
    return false;

  }

  private static void displayCustomerMenu() {
    System.out.println("CustomerMenu");
  }

  private static void displayShopMenu() {
    System.out.println("ShopMenu");
  }

  private static void register() {
    System.out.println("Register");
  }
}