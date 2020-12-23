import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class AdminMain {
    public static void main(String[] args) {
        System.out.println("Welcome back admin");
        System.out.println("Please choose an action");
        System.out.println("1. View");
        System.out.println("2. Flag");
        System.out.println("3. Generate random visits");
        System.out.println("4. Exit");
        List<Integer> options = Arrays.asList(1, 2, 3, 4);
        int choice = Utils.getUserChoice(options);
        switch (choice) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:
                break;

        }

    }
}
