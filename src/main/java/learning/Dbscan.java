package learning;

import com.sun.javafx.geom.Point2D;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Dbscan {

    private List<Point> dataSet = new ArrayList<>();
    private Float eps;
    private Integer mintPts;
    private List<List<Point>> clusterList = new ArrayList<>();

    public Dbscan(List<Point> dataSet, Float eps, Integer mintPts) {
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
        for (Point neighbour : neighbours) {
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
        clusterList.add(cluster);
    }
    
    private LinkedHashSet<Point> regionQuery(Point point) {
        LinkedHashSet<Point> neighbours = new LinkedHashSet<>();
        Float x = point.getX();
        Float y = point.getY();
        for (Point pointTemp : dataSet) {
            if (point.getId() != pointTemp.getId()) {
                float distance = Point2D.distance(x, y, pointTemp.getX(), pointTemp.getY());
                if (distance <= eps) {
                    neighbours.add(pointTemp);
                }
            }
        }

        return neighbours;
    }



}
