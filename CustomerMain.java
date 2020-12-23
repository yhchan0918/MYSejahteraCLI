import java.util.Scanner;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;
import java.util.InputMismatchException;

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
    int choice = getUserChoice(options);
    switch (choice) {
      case 1:
        SignIn();
        break;
      case 2:

        Register();
        break;

    }

  }

  public static int getUserChoice(List<Integer> list) {

    while (true) {
      try {
        Scanner keyboard = new Scanner(System.in);
        int num = keyboard.nextInt();
        if (list.contains(num)) {
          keyboard.close();
          return num;
        } else {
          System.out.println("Please Enter Integer within " + list.get(0) + " - " + list.get(list.size() - 1));
          continue;
        }
      } catch (InputMismatchException e) {
        System.out.println("Only Integer is allowed");
      }
    }
  }

  private static void Register() {
    System.out.println("Register");
  }

  private static void SignIn() {
    System.out.println("SignIn");
  }
}