package learning;

import com.sun.javafx.geom.Point2D;

public class Point extends Point2D {

    private Long id;
    private boolean visited;
    private boolean noise;
    private boolean isInAnyCluster;

    public Point(Long id, Float x, Float y) {
        super(x, y);
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

    public Float getX() {
       return super.x;
    }

    public Float getY() {
        return super.y;
    }
}
