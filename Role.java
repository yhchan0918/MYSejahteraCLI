public class Role extends Record {

  private static final long serialVersionUID = 1L;
  private String name;
  private String phone;
  private String status = "Normal";

  public Role() {
  }

  public Role(String name, String phone) {
    this.name = name;
    this.phone = phone;

  }

  public Role(String name, String phone, String status) {
    this.name = name;
    this.phone = phone;
    this.status = status;
  }

  public String getName() {
    return name;
  }

  public String getPhone() {
    return phone;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return name + " " + phone + " " + status;
  }

}
