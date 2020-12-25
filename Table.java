import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Table {
  public static void display(String[] colNamesList, ArrayList<HashMap<String, String>> hashMapList) {
    List<Integer> cmaxLen = new ArrayList<>();
    // Find the maximum length for columns
    for (int i = 0; i < colNamesList.length; i++) {
      cmaxLen.add(colNamesList[i].length());
    }
    for (int i = 0; i < hashMapList.size(); i++) {
      for (int j = 0; j < colNamesList.length; j++) {
        cmaxLen.set(j, Math.max(cmaxLen.get(j), hashMapList.get(i).get(colNamesList[j]).length()));
      }
    }
    // Add Two space
    int[] spaces = new int[cmaxLen.size()];
    for (int i = 0; i < cmaxLen.size(); i++) {
      spaces[i] = cmaxLen.get(i) + 2;
    }
    // Print ColName Header
    for (int i = 0; i < spaces.length; i++) {
      String format = "%-" + spaces[i] + "s";
      System.out.format(format, (colNamesList[i]));
    }
    System.out.println();
    // Print listData
    for (int i = 0; i < hashMapList.size(); i++) {
      for (int j = 0; j < colNamesList.length; j++) {
        String format = "%-" + spaces[j] + "s";
        System.out.format(format, hashMapList.get(i).get(colNamesList[j]));
      }
      System.out.println();
    }

  }
}
