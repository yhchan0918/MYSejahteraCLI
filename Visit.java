import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Visit {
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

  public String toDate() {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd");
    return dtf.format(this.checkInTime);
  }

  public String toTime() {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("k:mm:ss");
    return dtf.format(this.checkInTime);
  }

  public String toString() {
    return toDate() + " " + toTime() + " " + customer + " " + shop;
  }
}
