import java.util.Scanner;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;

public class CustomerMain {
  public static void main(String[] args) throws IOException {
    System.out.println(new Visit("YHCHAN", "tesco").toTime());
    System.out.println(new Visit("YHCHAN", "tesco").toDate());
    System.out.println("Welcome to MYSejahtera");
    System.out.println("Please Type the No of your desired action and press ENTER to proceed");
    System.out.println("1. Sign In");
    System.out.println("2. Register");
    System.out.println("3. View All Shops Status");
    List<Integer> options = Arrays.asList(1, 2, 3);
    int choice = Utils.getUserChoice(options);
    switch (choice) {
      case 1:
        signIn();
        break;
      case 2:
        register();
        break;
    }
  }

  private static void register() {
    System.out.println("Register");
  }

  private static void signIn() {
    System.out.println("SignIn");
  }
}