import java.io.Serializable;

abstract class Record implements Serializable {

  private static final long serialVersionUID = 1L;
  public final static String visitFilename = "Visits";
  public final static String customerFilename = "Customers";
  public final static String shopFilename = "Shops";

  public Record() {
  }
}
