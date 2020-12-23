import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Utils {
  public static void saveCustomersToFile(ArrayList<Customer> customersList) throws Exception {

    try {
      FileOutputStream fos = new FileOutputStream("customers");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(customersList);
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

  public static void saveShopsToFile(ArrayList<Shop> shopsList) throws Exception {

    try {
      FileOutputStream fos = new FileOutputStream("shops");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(shopsList);
      oos.close();
      fos.close();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
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

  public static void saveVisitsToFile(ArrayList<Visit> visitsList) throws Exception {

    try {
      FileOutputStream fos = new FileOutputStream("visits");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(visitsList);
      oos.close();
      fos.close();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  public static ArrayList<Visit> readVisitsFromFile() throws Exception {
    ArrayList<Visit> VisitsList = new ArrayList<>();
    try {
      FileInputStream fis = new FileInputStream("visits");
      ObjectInputStream ois = new ObjectInputStream(fis);

      VisitsList = (ArrayList) ois.readObject();

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
    return VisitsList;
  }

}
