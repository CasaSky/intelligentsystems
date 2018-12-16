package learning;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Application {

    public static void main(String[] args) {


        List<Point> dataSet = generateRandomList(90);
        WriteExcelUtil.write(dataSet);
        Dbscan dbscan = new Dbscan(dataSet, 5, 3);
        List<List<Point>> clusterList = dbscan.getClusterList();
        for (List<Point> cluster : clusterList) {
            System.out.println(cluster.toString());
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
        int min = 40;
        int max = 90;
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int result = ThreadLocalRandom.current().nextInt(min, max + 1);
        return result;
    }

}
