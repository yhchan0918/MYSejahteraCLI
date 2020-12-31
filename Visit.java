import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Visit extends Record {

  private static final long serialVersionUID = 1L;
  private LocalDateTime checkInTime;
  private String customer;
  private String shop;

  public Visit() {
  };

  public Visit(String customer, String shop) {
    this.checkInTime = LocalDateTime.now();
    this.customer = customer;
    this.shop = shop;
  };

  public String getCustomer() {
    return customer;
  }

  public String getShop() {
    return shop;
  }

  public String getDate() {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd");
    return dtf.format(this.checkInTime);
  }

  public String getTime() {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("kk:mm:ss");
    return dtf.format(this.checkInTime);
  }

  public LocalDateTime getCheckInTime() {
    return this.checkInTime;
  }

  public String toString() {
    return getDate() + " " + getTime() + " " + customer + " " + shop;
  }
}
