/**
 * A shop object representing the shop's name, phone, status and manager which
 * extends from Role.java, where name, phone, status and manager are strings.
 */
public class Shop extends Role {
  private static final long serialVersionUID = 1L;
  private String manager;

  /**
   * Construct a shop with it's name, phone, status and manager are set to null
   * ("")
   */
  public Shop() {

  };

  /**
   * Construct a shop with specified name, phone, status and manager.
   * 
   * @param name    the name of the shop
   * @param phone   the phone number of the shop
   * @param status  the status of the shop
   * @param manager the manager's name of the shop
   */
  public Shop(String name, String phone, String status, String manager) {
    super(name, phone, status);
    this.manager = manager;
  }

  /**
   * Returns the manager's name from the specified shop.
   * 
   * @return the name of the manager
   */
  public String getManager() {
    return manager;
  }

  /**
   * Returns the shop in name phone status manager.
   * 
   * @return name phone status manager
   */
  @Override
  public String toString() {
    return super.toString() + " " + manager;
  }
}