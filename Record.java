import java.io.Serializable;

abstract class Record implements Serializable {

  private static final long serialVersionUID = 1L;
  public final static String VISIT_FILENAME = "Visits";
  public final static String CUSTOMER_FILENAME = "Customers";
  public final static String SHOP_FILENAME = "Shops";

  public Record() {
  }
}
