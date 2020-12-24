import java.util.ArrayList;

public class TestCustomerFile {
  public static void main(String[] args) throws Exception {
    ArrayList<Customer> customersList = new ArrayList<Customer>();
    customersList.add(new Customer("YHChan", "012456789"));
    customersList.add(new Customer("Boe", "0155547899", "Case"));
    customersList.add(new Customer("Neoh", "0158553685", "Close"));
    customersList.add(new Customer("Delphine", "0136744547", "Normal"));
    customersList.add(new Customer("Jason", "0177876345", "Normal"));

    Utils.saveToFile(customersList, "customers");
    ArrayList<Customer> list = Utils.readListFromFile("customers");
    for (Customer customer : list) {
      System.out.println(customer);
    }
  }

}
