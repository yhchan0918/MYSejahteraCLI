import java.io.Serializable;

public class Role implements Serializable {
  private String name;
  private String phone;
  private String status;

  public Role() {
  }

  public Role(String name, String phone, String status) {
    this.name = name;
    this.phone = phone;
    this.status = status;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return name + " " + phone + " " + status;
  }

}
