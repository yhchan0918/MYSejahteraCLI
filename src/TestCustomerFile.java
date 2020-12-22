import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TestCustomerFile {
  public static void main(String[] args) throws Exception {

  }

  private static void saveCustomersToFile() throws IOException{
      ArrayList<Customer> customersList = new ArrayList<Customer>();
         
      customersList.add(new Customer);
      customersList.add("brian");
      customersList.add("charles");

      try
      {
          FileOutputStream fos = new FileOutputStream("customers");
          ObjectOutputStream oos = new ObjectOutputStream(fos);
          oos.writeObject(customersList);
          oos.close();
          fos.close();
      } 
      catch (IOException ioe) 
      {
          ioe.printStackTrace();
      }
    }
}
