import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Visit extends Record implements Comparable<Visit> {

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

  public Visit(String customer, String shop, LocalDateTime checkInTime) {
    this.customer = customer;
    this.shop = shop;
    this.checkInTime = checkInTime;
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

  @Override
  public int compareTo(Visit v) {
    return this.getCheckInTime().compareTo(v.getCheckInTime());
  }
}
