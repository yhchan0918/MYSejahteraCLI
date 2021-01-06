import java.util.ArrayList;

/**
 * This class is for resetting dataList
 */
public class Initializer {
  public static void main(String[] args) throws Exception {
    initCust();
    initShop();

  }

  public static void initCust() throws Exception {
    ArrayList<Customer> customersList = new ArrayList<Customer>();
    customersList.add(new Customer("Boe", "0155547899", "Normal"));
    customersList.add(new Customer("Chan", "012456789", "Normal"));
    customersList.add(new Customer("Delphine", "0136744547", "Normal"));
    customersList.add(new Customer("Neoh", "0158553685", "Normal"));
    customersList.add(new Customer("Jason", "0177876345", "Normal"));

    Utils.saveToFile(customersList, Record.CUSTOMER_FILENAME);
    ArrayList<Customer> list = Utils.readListFromFile(Record.CUSTOMER_FILENAME);
    for (Customer customer : list) {
      System.out.println(customer);
    }
  }

  public static void initShop() throws Exception {
    ArrayList<Shop> shopsList = new ArrayList<Shop>();

    shopsList.add(new Shop("Watsons", "07-8956242", "Normal", "Manager1"));
    shopsList.add(new Shop("Vivo Restaurant", "07-4785515", "Normal", "Manager2"));
    shopsList.add(new Shop("Sushi Mentai", "07-4554425", "Normal", "Manager3"));
    shopsList.add(new Shop("Popular BookShop", "07-7647550", "Normal", "Manager4"));

    Utils.saveToFile(shopsList, Record.SHOP_FILENAME);
    ArrayList<Shop> list = Utils.readListFromFile(Record.SHOP_FILENAME);
    for (Shop shop : list) {
      System.out.println(shop);
    }

  }

}
