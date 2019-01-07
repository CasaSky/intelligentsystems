package learning.dbscan;

import org.junit.platform.commons.util.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;


public class Application {

    public static void main(String[] args) {
        readIrisDataset();


        int n = 5000;
        //List<Point> dataSet = generateRandomData(n);
        List<Point> dataSet = readIrisDataset();
        WriteExcelUtil.write(dataSet);
        double eps = 1.5;
        Dbscan dbscan = new Dbscan(dataSet, eps, 10);
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

    private static List<Point> generateRandomData(int n) {
        int minX = 20;
        int maxX = 50;
        int minY = 40000;
        int maxY = 90000;
        List<Point> dataSet = new ArrayList<>();
        for (int i=0; i<n/2; i++) {
            Point point = new Point(i, getRandomAge(minX, maxX/2), getRandomSalary(minY+20000, maxY-1000));
            dataSet.add(point);
        }

        for (int i=n/2; i<n; i++) {
            Point point = new Point(i, getRandomAge(maxX/2, maxX), getRandomSalary(minY, maxY));
            dataSet.add(point);
        }

        return dataSet;
    }
    private static double getRandomAge(int min, int max) {
        //int min = 20;
        //int max = 50;
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int result = ThreadLocalRandom.current().nextInt(min, max + 1);
        return result;
    }

    private static double getRandomSalary(int min, int max) {
        //int min = 40000;
        //int max = 90000;
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int result = ThreadLocalRandom.current().nextInt(min, max + 1);
        return result;
    }

    private static List<Point> readIrisDataset() {
        final String fileName = "iris.data";
        List<Point> data = new ArrayList<>();
        try {
            int i=0;
            for (String line : Files.readAllLines(Paths.get(fileName))) {
                String[] lineData = line.split(",");
                if (lineData != null && lineData.length >= 2) {
                    String x = lineData[0];
                    String y = lineData[1];
                    if (StringUtils.isNotBlank(x) && StringUtils.isNotBlank(y)) {
                        data.add(new Point(i, Double.parseDouble(x), Double.parseDouble(y)));
                    }
                }
                i++;
            }

            for (Point point : data) {
                System.out.println(point);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

}
