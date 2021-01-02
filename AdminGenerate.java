import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Random;
import java.util.ArrayList;

public class AdminGenerate {

    public static void menu() throws Exception {
        Utils.displayHeader("Visit Generator Menu");
        System.out.println("Do you want to generate 30 random Visits and append to the Master Visit History?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        List<Integer> options = Arrays.asList(1, 2);
        int choice = Utils.getUserChoice(options);
        switch (choice) {
            case 1:
                visitGenerator();
                AdminMain.menu();
                break;
            case 2:
                System.out.println("Going back to Main Menu\n");
                AdminMain.menu();
                break;
        }
    }

    private static void visitGenerator() throws Exception {
        ArrayList<Customer> custList = Utils.readListFromFile(Record.CUSTOMER_FILENAME);
        ArrayList<Shop> shopList = Utils.readListFromFile(Record.SHOP_FILENAME);
        ArrayList<Visit> visitList = Utils.readListFromFile(Record.VISIT_FILENAME);

        Random random = new Random();
        LocalDateTime[] randomTime = getRandomTime();

        for (int i = 0; i < 30; i++) {
            String randomCust = custList.get(random.nextInt(custList.size())).getName();
            String randomShop = shopList.get(random.nextInt(shopList.size())).getName();

            visitList.add(new Visit(randomCust, randomShop, randomTime[i]));
        }
        visitList = sortByDateTime(visitList);

        Utils.saveToFile(visitList, Record.VISIT_FILENAME);
        System.out.println("Successfully generated 30 random Visits and appended to Master Visit Records");
        System.out.println("Please go to Master Visit History under View Data Menu to check the results");
    }

    private static LocalDateTime[] getRandomTime() {
        LocalDateTime[] randomTime = new LocalDateTime[30];
        LocalDateTime now = LocalDateTime.now();
        long currentTime = now.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();

        Random random = new Random();
        final int secPerDay = 24 * 60 * 60;

        for (int i = 0; i < 30; i++) {
            long randGene = currentTime - random.nextInt(secPerDay);
            randomTime[i] = LocalDateTime.ofInstant(Instant.ofEpochSecond(randGene), ZoneId.systemDefault());
        }

        return randomTime;
    }

    private static ArrayList<Visit> sortByDateTime(ArrayList<Visit> visitList) {
        Collections.sort(visitList);
        return visitList;
    }
}
