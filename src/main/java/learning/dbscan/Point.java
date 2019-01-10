package learning.dbscan;

import java.io.Serializable;
import java.util.List;

public class Point implements Comparable<Point>, Serializable {

    private List<java.lang.Double> coordinates;
    private int id;
    private Integer clusterNumber = 0;
    private PointType pointType = PointType.UNDEFINED;

    public Point(int id, List<java.lang.Double> coordinates) {
        this.coordinates = coordinates;
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

    public List<Double> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }

    public double getDistance(List<Double> anotherPointCoordinates) throws Exception {

        if (coordinates.size() != anotherPointCoordinates.size()) {
            throw new Exception("The dimension of two point must be the same");
        }

        double sum = 0;
        for (int i=0; i<coordinates.size(); i++) {
            Double coordinate = coordinates.get(i);
            Double anotherPointCoordinate = anotherPointCoordinates.get(i);
            sum += Math.pow((coordinate - anotherPointCoordinate), 2);
        }

        return Math.sqrt(sum);
        //Point2D.distance(x, y, nextX, nextY);

    }

    @Override
    public String toString() {
        return "{" +
               coordinates +
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
