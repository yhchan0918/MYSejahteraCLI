import java.util.ArrayList;

public class TestCustomerFile {
  public static void main(String[] args) throws Exception {
    ArrayList<Customer> customersList = new ArrayList<Customer>();
    Customer cust = new Customer("Yhchan", "0127891459", "Normal");

    customersList.add(new Customer("Yhchan", "0127891459", "Normal"));
    customersList.add(new Customer("Boe", "0155547899", "Normal"));
    customersList.add(new Customer("Neoh", "0158553685", "Normal"));
    customersList.add(new Customer("Delphine", "0136744547", "Normal"));
    customersList.add(new Customer("Jason", "0177876345", "Normal"));

    Utils.saveCustomersToFile(customersList);
    Utils.readCustomersFromFile();
  }

}
