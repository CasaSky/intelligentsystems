package learning.dbscan;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Application {

    public static void main(String[] args) {


        int n = 5000;
        List<Point> dataSet = generateRandomList(n);
        WriteExcelUtil.write(dataSet);
        double eps = 2.5;
        Dbscan dbscan = new Dbscan(dataSet, eps, 3);
        Map<Integer, List<Point>> dataLabels = dbscan.findDataLabels();
        int anzahlCluster = 0;
        if (dataLabels.size() > 0) {
            System.out.println("\n\nKategorisieren der Daten nach DBSCAN Algorithmus");
            for (Map.Entry<Integer, List<Point>> cluster : dataLabels.entrySet()) {
                anzahlCluster += cluster.getValue().size();
                System.out.println(cluster.toString());
            }
            System.out.println("\n\nStatistics");
            System.out.println(dataLabels.size() + " Cluster bei Radius von " + eps + " gefunden");
            System.out.println(anzahlCluster + " von " + n + " Daten sind kategorisiert worden");
        } else {
            System.out.println("Es wurde kein Cluster gefunden.");
        }
    }

    private static List<Point> generateRandomList(int n) {
        List<Point> dataSet = new ArrayList<>();
        for (int i=0; i<n; i++) {
            Point point = new Point(i, getRandomAge(), getRandomSalary());
            dataSet.add(point);
        }

        return dataSet;
    }
    private static double getRandomAge() {
        int min = 20;
        int max = 50;
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int result = ThreadLocalRandom.current().nextInt(min, max + 1);
        return result;
    }

    private static double getRandomSalary() {
        int min = 40000;
        int max = 90000;
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int result = ThreadLocalRandom.current().nextInt(min, max + 1);
        return result;
    }

}
