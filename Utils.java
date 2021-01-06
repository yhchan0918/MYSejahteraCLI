import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

public class Utils {
  public static <E extends Record> void saveToFile(ArrayList<E> list, String filename) throws Exception {
    try {
      FileOutputStream fos = new FileOutputStream(filename + ".bin");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(list);
      oos.close();
      fos.close();
    } catch (FileNotFoundException e) {
      System.out.println("Record not found");
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

  }

  public static <T extends Record> ArrayList<T> readListFromFile(String filename) throws Exception {
    ArrayList<T> list = new ArrayList<>();
    try {
      FileInputStream fis = new FileInputStream(filename + ".bin");
      ObjectInputStream ois = new ObjectInputStream(fis);

      list = (ArrayList) ois.readObject();

      ois.close();
      fis.close();

    } catch (FileNotFoundException e) {
      System.out.println("Record not found");
    } catch (IOException ioe) {
      System.out.println("IOException is caught");

    } catch (ClassNotFoundException c) {
      System.out.println("Class not found");

    }

    return list;
  }

  public static void displayExportCSVPrompt(String[] colNamesList, ArrayList<HashMap<String, String>> data,
      String filename) throws Exception {
    System.out.println();
    System.out.println("Would you like to export to CSV file? If Yes, Enter 1, otherwise Enter 2");
    System.out.println("1. Yes");
    System.out.println("2. No");
    List<Integer> options = Arrays.asList(1, 2);
    int choice = getUserChoice(options);
    switch (choice) {
      case 1:
        exportToCSV(colNamesList, data, filename);
        break;
      case 2:
        break;
    }
  }

  public static <E extends Record> void exportToCSV(String[] colNamesList, ArrayList<HashMap<String, String>> data,
      String filename) throws Exception {
    String res = String.join(",", colNamesList);

    for (HashMap<String, String> d : data) {
      ArrayList<String> tmpList = new ArrayList<String>();
      for (String item : colNamesList)
        tmpList.add(d.get(item));
      res += "\n" + String.join(",", tmpList);
    }

    // Create file
    try {
      File f = new File(filename + ".csv");
      f.createNewFile();
    } catch (IOException e) {
      e.printStackTrace();
    }

    // Write file
    try {
      FileWriter f = new FileWriter(filename + ".csv");
      f.write(res);
      f.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

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

  // overloading
  public static int getUserChoice(int min, int max) {
    Scanner input = new Scanner(System.in);
    int num;
    while (true) {
      try {
        num = input.nextInt();
        if (num >= min && num <= max) {
          System.out.println();
          return num;
        }
        System.out.println("Please Enter Integer within " + min + " - " + max);
        continue;
      } catch (InputMismatchException e) {
        System.out.println("Only Integer is allowed. Please Try Again");
        input.nextLine();
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
