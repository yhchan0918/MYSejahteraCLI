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

  public String ToDate() {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd");
    return dtf.format(this.checkInTime);
  }

  public String ToTime() {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("k:mm:ss");
    return dtf.format(this.checkInTime);
  }
}
