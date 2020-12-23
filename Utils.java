import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Utils {
  public static <E extends Record> void saveToFile(ArrayList<E> list, String fileName) throws Exception {

    try {
      FileOutputStream fos = new FileOutputStream(fileName);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(list);
      oos.close();
      fos.close();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  public static ArrayList<Customer> readCustomersFromFile() throws Exception {
    ArrayList<Customer> customersList = new ArrayList<>();
    try {
      FileInputStream fis = new FileInputStream("customers");
      ObjectInputStream ois = new ObjectInputStream(fis);

      customersList = (ArrayList) ois.readObject();

      ois.close();
      fis.close();
    } catch (IOException ioe) {
      System.out.println("IOException is caught");

    } catch (ClassNotFoundException c) {
      System.out.println("Class not found");

    }

    // TODO: Remember Delete this Dummy function before submit
    // for (Customer customer : customersList) {
    // System.out.println(customer);
    // }
    return customersList;
  }

  public static ArrayList<Shop> readShopsFromFile() throws Exception {
    ArrayList<Shop> shopsList = new ArrayList<>();
    try {
      FileInputStream fis = new FileInputStream("shops");
      ObjectInputStream ois = new ObjectInputStream(fis);

      shopsList = (ArrayList) ois.readObject();

      ois.close();
      fis.close();
    } catch (IOException ioe) {
      System.out.println("IOException is caught");

    } catch (ClassNotFoundException c) {
      System.out.println("Class not found");

    }

    // TODO: Remember Delete this Dummy function before submit
    // for (Shop shop : shopsList) {
    // System.out.println(shop);
    // }
    return shopsList;
  }

  public static ArrayList<Visit> readVisitsFromFile() throws Exception {
    ArrayList<Visit> visitsList = new ArrayList<>();
    try {
      FileInputStream fis = new FileInputStream("visits");
      ObjectInputStream ois = new ObjectInputStream(fis);

      visitsList = (ArrayList) ois.readObject();

      ois.close();
      fis.close();
    } catch (IOException ioe) {
      System.out.println("IOException is caught");

    } catch (ClassNotFoundException c) {
      System.out.println("Class not found");

    }

    // TODO: Remember Delete this Dummy function before submit
    // for (Visit visit : VisitsList) {
    // System.out.println(visit);
    // }
    return visitsList;
  }

}
