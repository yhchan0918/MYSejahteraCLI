import java.util.ArrayList;

public class Initializer {
  public static void main(String[] args) throws Exception {
    initCust();
    initShop();
    initVisit();
  }

  public static void initCust() throws Exception {
    ArrayList<Customer> customersList = new ArrayList<Customer>();
    customersList.add(new Customer("YHChan", "012456789"));
    customersList.add(new Customer("Boe", "0155547899", "Case"));
    customersList.add(new Customer("Neoh", "0158553685", "Close"));
    customersList.add(new Customer("Delphine", "0136744547", "Normal"));
    customersList.add(new Customer("Jason", "0177876345", "Normal"));

    Utils.saveToFile(customersList, Record.customerFilename);
    ArrayList<Customer> list = Utils.readListFromFile(Record.customerFilename);
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

    Utils.saveToFile(shopsList, Record.shopFilename);
    ArrayList<Shop> list = Utils.readListFromFile(Record.shopFilename);
    for (Shop shop : list) {
      System.out.println(shop);
    }

  }

  public static void initVisit() throws Exception {
    ArrayList<Visit> visitsList = new ArrayList<Visit>();

    visitsList.add(new Visit("YhChan", "Watsons"));
    visitsList.add(new Visit("Boe", "Vivo Restaurant"));
    visitsList.add(new Visit("Jason", "Sushi Mentai"));
    visitsList.add(new Visit("Delphine", "Popular BookShop"));

    Utils.saveToFile(visitsList, Record.visitFilename);
    ArrayList<Visit> list = Utils.readListFromFile(Record.visitFilename);
    for (Visit visit : list) {
      System.out.println(visit);
    }
  }
}