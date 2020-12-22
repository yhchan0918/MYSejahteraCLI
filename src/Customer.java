public class Customer extends Role {

  public Customer(String name, String phone, String status) {
    super(name, phone, status);
  }

  public static void main(String args[]) {
    Customer obj = new Customer("yhchan", "121511122", "Normal");
    System.out.println(obj.toString());

  }
}