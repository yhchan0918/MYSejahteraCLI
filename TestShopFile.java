import java.util.ArrayList;

public class TestShopFile {
  public static void main(String[] args) throws Exception {
    ArrayList<Shop> shopsList = new ArrayList<Shop>();

    shopsList.add(new Shop("Watsons", "07-8956242", "Normal", "Manager1"));
    shopsList.add(new Shop("Vivo Restaurant", "07-4785515", "Normal", "Manager2"));
    shopsList.add(new Shop("Sushi Mentai", "07-4554425", "Normal", "Manager3"));
    shopsList.add(new Shop("Popular BookShop", "07-7647550", "Normal", "Manager4"));

    Utils.saveToFile(shopsList, "shops");
    ArrayList<Shop> list = Utils.readListFromFile("shops");
    for (Shop shop : list) {
      System.out.println(shop);
    }

  }

}
