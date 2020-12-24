public class Customer extends Role {
  private static final long serialVersionUID = 1L;

  public Customer() {

  };

  public Customer(String name, String phone) {
    super(name, phone);
  }

  public Customer(String name, String phone, String status) {
    super(name, phone, status);
  }
}