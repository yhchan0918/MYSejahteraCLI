public class Role {
  protected String name;
  protected String phone;
  protected String status;

  public Role() {
  }

  public Role(String name, String phone, String status) {
    this.name = name;
    this.phone = phone;
    this.status = status;
  }

  @Override
  public String toString() {
    return name + " " + phone + " " + status;
  }

}
