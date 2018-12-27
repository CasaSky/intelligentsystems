package learning.dbscan;

import java.awt.geom.Point2D;
import java.io.Serializable;

public class Point extends Point2D implements Comparable<Point>, Serializable {

    private double x;
    private double y;
    private int id;
    private Integer clusterNumber = 0;
    private PointType pointType = PointType.UNDEFINED;

    public Point(int id, double x, double y) {
        setLocation(x, y);
        this.id = id;
    }

    public PointType getLabel() {
        return pointType;
    }

    public void setLabel(PointType pointType, Integer clusterNumber) {
        this.pointType = pointType;
        this.clusterNumber = clusterNumber;
    }

    public void makeItNoise() {
        this.pointType = PointType.NOISE;
    }

    public Integer getClusterNumber() {
        return clusterNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(double nextX, double nextY) {
        return Point2D.distance(x, y, nextX, nextY);
    }

    @Override
    public String toString() {
        return "Point{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public int compareTo(Point o) {
        return Integer.compare(id, o.id);
        /*double distance = this.getDistance(o.x, o.y);
        if (distance == 0) {
            return 0;
        } else if (distance > 0) {
            return 1;
        } else {
            return -1;
        }*/

    }

}
