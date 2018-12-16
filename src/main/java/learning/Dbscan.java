package learning;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

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

        for (Point point : dataSet) {
            point.setVisited(true);
            LinkedHashSet<Point> neighbours = regionQuery(point);
            if (neighbours.size() < mintPts) {
                point.setNoise(true);
            } else {
                expandCluster(point, neighbours);
            }
        }

        return clusterList;
    }
    
    private void expandCluster(Point point, LinkedHashSet<Point> neighbours) {
        List<Point> cluster = new ArrayList<>();
        point.setInAnyCluster(true);
        cluster.add(point);
        Iterator<Point> iterator = neighbours.iterator();
        while (!iterator.hasNext()) {
            Point neighbour = iterator.next();
            if (!neighbour.isVisited()) {
                neighbour.setVisited(true);
                LinkedHashSet<Point> neigboursTemp =  regionQuery(neighbour);
                if (neigboursTemp.size() >= mintPts) {
                    neighbours.addAll(neigboursTemp);
                }
            }
            //TODO Diskussionsfrage
            if (!neighbour.isInAnyCluster()) {
                point.setInAnyCluster(true);
                point.setNoise(false);
                cluster.add(point);
            }
        }
        for (Point neighbour : neighbours) {

        }
        clusterList.add(cluster);
    }
    
    private LinkedHashSet<Point> regionQuery(Point point) {
        LinkedHashSet<Point> neighbours = new LinkedHashSet<>();

        for (Point pointTemp : dataSet) {
            if (point.getId() != pointTemp.getId()) {
                double distance = point.getDistance(pointTemp.getX(), pointTemp.getY());
                if (distance <= eps) {
                    neighbours.add(pointTemp);
                }
            }
        }

        return neighbours;
    }



}
