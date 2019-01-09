package learning.dbscan.tests;

import learning.dbscan.Dbscan;
import learning.dbscan.Point;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DbscanTest {
    Point point11, point12, point13, point14, point15;
    Point point21, point22, point23, point24, point25;
    Point point31, point32, point33, point34, point35;
    List<Point> dataSet;

    List<Point> cluster1;
    List<Point> cluster2;
    List<Point> cluster3;
    List<Point> neighbours1;
    List<Point> neighbours2;
    List<Point> neighboursJoined;

    List<List<Point>> clusterList;

    Dbscan dbscan1;



    @BeforeEach
    void setUp() {
        point11 = new Point(11, 1, 1);
        point12 = new Point(12, 1, 3);
        point13 = new Point(13, 2, 2);
        point14 = new Point(14, 3, 1);
        point15 = new Point(15, 3, 3);

        point21 = new Point(21, 11, 11);
        point22 = new Point(22, 11, 13);
        point23 = new Point(23, 12, 12);
        point24 = new Point(24, 13, 11);
        point25 = new Point(25, 13, 13);

        point31 = new Point(31, 31, 31);
        point32 = new Point(32, 31, 33);
        point33 = new Point(33, 32, 32);
        point34 = new Point(34, 33, 31);
        point35 = new Point(35, 33, 33);

        dataSet = new ArrayList<>();
        dataSet.add(point11);
        dataSet.add(point12);
        dataSet.add(point13);
        dataSet.add(point14);
        dataSet.add(point15);
        dataSet.add(point21);
        dataSet.add(point22);
        dataSet.add(point23);
        dataSet.add(point24);
        dataSet.add(point25);
        dataSet.add(point31);
        dataSet.add(point32);
        dataSet.add(point33);
        dataSet.add(point34);
        dataSet.add(point35);

        cluster1 = new ArrayList<>();
        cluster1.add(point11);
        cluster1.add(point12);
        cluster1.add(point13);
        cluster1.add(point14);
        cluster1.add(point15);

        cluster2 = new ArrayList<>();
        cluster2.add(point21);
        cluster2.add(point22);
        cluster2.add(point23);
        cluster2.add(point24);
        cluster2.add(point25);

        cluster3 = new ArrayList<>();
        cluster3.add(point31);
        cluster3.add(point32);
        cluster3.add(point33);
        cluster3.add(point34);
        cluster3.add(point35);

        clusterList = new ArrayList<>();
        clusterList.add(cluster1);
        clusterList.add(cluster2);
        clusterList.add(cluster3);

        neighbours1 = new ArrayList<>();
        neighbours1.add(point11);
        neighbours1.add(point12);
        neighbours1.add(point13);

        neighbours2 = new ArrayList<>();
        neighbours2.add(point13);
        neighbours2.add(point14);
        neighbours2.add(point15);

        neighboursJoined = new ArrayList<>();
        neighboursJoined.add(point11);
        neighboursJoined.add(point12);
        neighboursJoined.add(point13);
        neighboursJoined.add(point14);
        neighboursJoined.add(point15);

        dbscan1 = new Dbscan(dataSet, 4.0, 5);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getClusterList() {
        assertEquals(clusterList, dbscan1.getClusterList());
    }

    @Test
    void join() {
//       dbscan1.join(neighbours1, neighbours2);
       assertEquals(neighboursJoined, dbscan1.join(neighbours1, neighbours2));
       assertTrue(dbscan1.join(neighbours2, neighbours1).size() == neighboursJoined.size());
       Boolean bool1 = true;
       for(Point point : dbscan1.join(neighbours2, neighbours1)) {
           if (!neighboursJoined.contains(point)) {
               bool1 = false;
           }
       }
       assertTrue(bool1);
    }

    @Test
    void regionQuery() {
        assertEquals(cluster1, dbscan1.regionQuery(point11));
        assertEquals(cluster1, dbscan1.regionQuery(point12));
        assertEquals(cluster1, dbscan1.regionQuery(point13));
        assertEquals(cluster1, dbscan1.regionQuery(point14));
        assertEquals(cluster1, dbscan1.regionQuery(point15));
        assertEquals(cluster2, dbscan1.regionQuery(point21));
        assertEquals(cluster3, dbscan1.regionQuery(point31));

        assertNotEquals(cluster2, dbscan1.regionQuery(point11));
        assertNotEquals(cluster3, dbscan1.regionQuery(point11));
        assertNotEquals(cluster1, dbscan1.regionQuery(point21));
        assertNotEquals(cluster3, dbscan1.regionQuery(point21));
        assertNotEquals(cluster1, dbscan1.regionQuery(point31));
        assertNotEquals(cluster2, dbscan1.regionQuery(point31));
    }

    @Test
    void expandCluster() {
//        List<Point> neighbours = new ArrayList<>();
//        neighbours.add(point11);
//        neighbours.add(point12);
//
//        dbscan1.expandCluster(point11, cluster1);
//        assertEquals(cluster1, clusterList.get(0));

    }


}


