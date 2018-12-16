package learning;

import java.util.*;

public class Dbscan {

    private List<Point> dataSet;
    private double eps;
    private int mintPts;
    private List<List<Point>> clusterList = new ArrayList<>();

    public Dbscan(List<Point> dataSet, double eps, int mintPts) {
        this.dataSet = dataSet;
        this.eps = eps;
        this.mintPts = mintPts;
    }

    public List<List<Point>> getClusterList() {

        int i = 0;
        while (dataSet.size() > i) {
            Point point = dataSet.get(i);
            if (!point.isVisited()) {
                point.setVisited(true);
                //visitedPoints.add(point);
                List<Point> neighbours = regionQuery(point);
                if (neighbours.size() < mintPts) {
                    point.setNoise(true);
                } else {
                    expandCluster(point, neighbours);
                }
            }
            i++;
        }
        return clusterList;
    }
    
    private void expandCluster(Point point, List<Point> neighbours) {
        List<Point> cluster = new ArrayList<>();
        point.setInAnyCluster(true);
        cluster.add(point);
        int i=0;
        while (neighbours.size() > i) {
            Point neighbour = neighbours.get(i); // visited
            if (!neighbour.isVisited()) {
                neighbour.setVisited(true);
                List<Point> neigboursTemp = regionQuery(neighbour);
                if (neigboursTemp.size() >= mintPts) {
                    join(neighbours, neigboursTemp);
                }

                //TODO Diskussionsfrage
                if (!neighbour.isInAnyCluster()) {
                    neighbour.setInAnyCluster(true);
                    neighbour.setNoise(false);
                    cluster.add(neighbour);
                }
            }
            i++;
        }
       clusterList.add(cluster);
    }
    
    private List<Point> regionQuery(Point point) {
        List<Point> neighbours = new ArrayList<>();

        for (Point pointTemp : dataSet) {
            double distance = point.getDistance(pointTemp.getX(), pointTemp.getY());
            if (distance <= eps) {
                neighbours.add(pointTemp);
            }
        }

        return neighbours;
    }

    private List<Point> join(List<Point> neighbours1, List<Point> neighbours2) {
        for (Point point : neighbours2) {
            if (!neighbours1.contains(neighbours2)) {
                neighbours1.add(point);
            }
        }
        return neighbours1;
    }


}
