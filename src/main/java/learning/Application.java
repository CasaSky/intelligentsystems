package learning;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {

    public static void main(String[] args) {


        List<Point> dataSet = generateRandomList(100);
        WriteExcelUtil.write(dataSet);
        Dbscan dbscan = new Dbscan(dataSet, Float.valueOf(10), 2);
        List<List<Point>> clusterList = dbscan.getClusterList();
        for (List<Point> cluster : clusterList) {
            System.out.println(cluster.toString());
        }
    }

    private static List<Point> generateRandomList(int n) {
        List<Point> dataSet = new ArrayList<>();
        for (int i=0; i<n; i++) {
            Point point = new Point(Long.valueOf(i), getRandomAge(), getRandomSalary());
            dataSet.add(point);
        }

        return dataSet;
    }
    private static Float getRandomAge() {
        Random rand = new Random();

        int n = rand.nextInt(80) + 1;

        return Float.valueOf(n);
    }

    private static Float getRandomSalary() {
        Random rand = new Random();

        int n = rand.nextInt(80) + 1;

        return Float.valueOf(n);
    }

}
