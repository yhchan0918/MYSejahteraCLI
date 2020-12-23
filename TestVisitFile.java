import java.util.ArrayList;

public class TestVisitFile {
  public static void main(String[] args) throws Exception {
    ArrayList<Visit> visitsList = new ArrayList<Visit>();
    Visit testVisit = new Visit("YhChan", "Watsons");
    System.out.println(testVisit);
    visitsList.add(new Visit("YhChan", "Watsons"));
    visitsList.add(new Visit("Boe", "Vivo Restaurant"));
    visitsList.add(new Visit("Jason", "Sushi Mentai"));
    visitsList.add(new Visit("Delphine", "Popular BookVisit"));

    Utils.saveToFile(visitsList, "visits");
    Utils.readVisitsFromFile();
  }

}
