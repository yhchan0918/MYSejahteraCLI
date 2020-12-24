import java.util.ArrayList;

public class TestVisitFile {
  public static void main(String[] args) throws Exception {
    ArrayList<Visit> visitsList = new ArrayList<Visit>();

    visitsList.add(new Visit("YhChan", "Watsons"));
    visitsList.add(new Visit("Boe", "Vivo Restaurant"));
    visitsList.add(new Visit("Jason", "Sushi Mentai"));
    visitsList.add(new Visit("Delphine", "Popular BookShop"));

    Utils.saveToFile(visitsList, "visits");
    ArrayList<Visit> list = Utils.readListFromFile("visits");
    for (Visit visit : list) {
      System.out.println(visit);
    }
  }

}
