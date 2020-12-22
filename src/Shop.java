public class Shop extends Role {
  private String manager;

  public Shop(String name, String phone, String status, String manager) {
    super(name, phone, status);
    this.manager = manager;
  }

  public static void main(String args[]) {
    Shop obj = new Shop("yhchan", "121511122", "Normal", "Manager");
    System.out.println(obj.toString());
  }

  @Override
  public String toString() {
    return name + " " + phone + " " + status + " " + manager;
  }
}