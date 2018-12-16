package learning;

import java.awt.geom.Point2D;

public class Point extends Point2D {

    private double x;
    private double y;
    private Long id;
    private boolean visited;
    private boolean noise;
    private boolean isInAnyCluster;

    public Point(Long id, double x, double y) {
        setLocation(x, y);
        this.id = id;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isNoise() {
        return noise;
    }

    public void setNoise(boolean noise) {
        this.noise = noise;
    }

    public boolean isInAnyCluster() {
        return isInAnyCluster;
    }

    public void setInAnyCluster(boolean inAnyCluster) {
        isInAnyCluster = inAnyCluster;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
