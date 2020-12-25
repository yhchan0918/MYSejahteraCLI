import java.util.ArrayList;
import java.util.HashMap;

public class TestTable {
  public static void main(String[] args) throws Exception {
    ArrayList<HashMap<String, String>> hashMapVisitsList = new ArrayList<HashMap<String, String>>();
    ArrayList<Visit> visitslist = Utils.readListFromFile("visits");
    String[] colNamesList = { "No", "Date", "Time", "Shop" };
    for (int i = 0; i < visitslist.size(); i++) {
      int index = i + 1;
      HashMap<String, String> map = new HashMap<>();
      map.put("No", Integer.toString(index));
      map.put("Date", visitslist.get(i).getDate());
      map.put("Time", visitslist.get(i).getTime());
      map.put("Shop", visitslist.get(i).getShop());
      hashMapVisitsList.add(map);
    }
    Table.display(colNamesList, hashMapVisitsList);
  }

}
