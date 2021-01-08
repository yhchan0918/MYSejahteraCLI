import java.util.List;
import java.util.Arrays;

public class AdminMain {
  public static void main(String[] args) throws Exception {
    menu();
  }

  public static void menu() throws Exception {
    Utils.displayHeader("Welcome Back Admin");
    System.out.println("Please choose an action");
    System.out.println("1. View Data");
    System.out.println("2. Flag");
    System.out.println("3. Generate 30 Visits");
    System.out.println("4. Exit");

    List<Integer> options = Arrays.asList(1, 2, 3, 4);
    int choice = Utils.getUserChoice(options);
    switch (choice) {
      case 1:
        AdminView.menu();
        break;
      case 2:
        AdminFlag.menu();
        break;
      case 3:
        AdminGenerate.menu();
        break;
      case 4:
        System.out.println("Exiting...");
        System.out.println("See you again, Admin");
        break;
    }
  }
}
