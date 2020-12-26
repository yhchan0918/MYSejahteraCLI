import java.util.ArrayList;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

public class Utils {
  public static <E extends Record> void saveToFile(ArrayList<E> list, String fileName) throws Exception {
    try {
      FileOutputStream fos = new FileOutputStream(fileName);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(list);
      oos.close();
      fos.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

  }

  public static <T extends Record> ArrayList<T> readListFromFile(String filename) throws Exception {
    ArrayList<T> list = new ArrayList<>();
    try {
      FileInputStream fis = new FileInputStream(filename);
      ObjectInputStream ois = new ObjectInputStream(fis);

      list = (ArrayList) ois.readObject();

      ois.close();
      fis.close();

    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    } catch (IOException ioe) {
      System.out.println("IOException is caught");

    } catch (ClassNotFoundException c) {
      System.out.println("Class not found");

    }

    return list;
  }

  public static int getUserChoice(List<Integer> list) {

    while (true) {
      try {
        Scanner keyboard = new Scanner(System.in);
        int num = keyboard.nextInt();
        if (list.contains(num)) {
          System.out.println();
          return num;
        } else {
          System.out.println("Please Enter Integer within " + list.get(0) + " - " + list.get(list.size() - 1));
          continue;
        }
      } catch (InputMismatchException e) {
        System.out.println("Only Integer is allowed. Please Try Again");
      }
    }

  }

  public static String repeat(int count, String with) {
    return new String(new char[count]).replace("\0", with);
  }

  public static void displayHeader(String title) {
    String header = "| " + title + " |%n";
    String line = "+" + repeat(header.length() - 4, "-") + "+%n";
    System.out.format(line);
    System.out.format(header);
    System.out.format(line);
  }

}
