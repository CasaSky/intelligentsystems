package learning.dbscan;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Dbscan {

    private List<Point> dataSet;
    private double eps;
    private int mintPts;

    public Dbscan(List<Point> dataSet, double eps, int mintPts) {
        this.dataSet = dataSet;
        this.eps = eps;
        this.mintPts = mintPts;
    }

    public Map<Integer, List<Point>> findDataLabels() {

        int clusterNumber = 0;
        int i = 0;
        while (i < dataSet.size()) {
            Point point = dataSet.get(i);
            if (point.getLabel() == PointType.UNDEFINED) {
                List<Point> neighbours = regionQuery(point);
                if (neighbours.size() < mintPts) { // density check
                    point.makeItNoise(); // label point as noise
                } else {
                    clusterNumber++;
                    point.setLabel(PointType.CORE, clusterNumber); // label point
                    neighbours.remove(point);
                    int j = 0;
                    while (j < neighbours.size()) {
                        Point neighbour = neighbours.get(j);
                        List<Point> neighboursTemp = regionQuery(neighbour); // find neighbors
                            if (neighboursTemp.size() >= mintPts) { // density check
                                neighbour.setLabel(PointType.CORE, clusterNumber);
                                join(neighbours, neighboursTemp); // add neighbors to seed set
                            }
                            neighbour.setLabel(PointType.BORDER, clusterNumber);
                        j++;
                    }
                }
            }
            i++;
        }
        // Preparing the output, output contains only the input that is been clustered
        List<Point> clusteredPoints = dataSet.stream().filter(d -> d.getClusterNumber() > 0).collect(Collectors.toList());
        // Grouping the output in order to group points together
        Map<Integer, List<Point>> result = clusteredPoints.stream().collect(groupingBy(d -> d.getClusterNumber()));
        return result;
    }
    
    public List<Point> regionQuery(Point point) {
        List<Point> neighbours = new ArrayList<>();

        for (Point pointTemp : dataSet) {
            List<Double> coordinates = pointTemp.getCoordinates();
            double distance = 0;
            try {
                distance = point.getDistance(coordinates);
            } catch (Exception e) {
            }
            if (distance <= eps) {
                neighbours.add(pointTemp);
            }
        }

        return neighbours;
    }

    public List<Point> join(List<Point> neighbours1, List<Point> neighbours2) {
        for (Point point : neighbours2) {
            if (!neighbours1.contains(point)) {
                neighbours1.add(point);
            }
        }
        return neighbours1;
    }


}
