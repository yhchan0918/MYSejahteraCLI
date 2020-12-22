public class Shop extends Role {
  private static final long serialVersionUID = 1L;
  private String manager;

  public Shop() {

  };

  public Shop(String name, String phone, String status, String manager) {
    super(name, phone, status);
    this.manager = manager;
  }

  @Override
  public String toString() {
    return super.toString() + " " + manager;
  }
}