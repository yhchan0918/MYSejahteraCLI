import java.util.List;
import java.util.Arrays;

public class AdminMain {
    public static void main(String[] args) throws Exception {

        menu();
    }

    public static void menu() throws Exception {
        Utils.displayHeader("Welcome back admin");
        System.out.println("Please choose an action");
        System.out.println("1. View Data");
        System.out.println("2. Flag");
        System.out.println("3. Exit");

        List<Integer> options = Arrays.asList(1, 2, 3);
        int choice = Utils.getUserChoice(options);
        switch (choice) {
            case 1:
                AdminView.menu();
                break;
            case 2:
                AdminFlag.menu();
                break;
            case 3:
                System.out.println("Exiting...");
                System.out.println("See you again, Admin");
                break;
        }
    }
}
// VisitGenerator
