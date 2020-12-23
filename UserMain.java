import java.util.Scanner;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;

public class UserMain {
  private Customer currentCustomer;
  private Shop currentShop;

  public static void main(String[] args) throws IOException {
    displayMainMenu();

  }

  private static void displayMainMenu() {
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

  private static void signIn(String role) {
    String title = "Sign In as " + role + " role";
    Utils.displayHeader(title);
    if (role.equals("Customer")) {
      System.out.println(role);

    } else {
      System.out.println(role);
    }

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