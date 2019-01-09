package learning.testdbscan;

import learning.dbscan.Patterngenerator;
import learning.dbscan.Point;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PatterngeneratorTest {
    Patterngenerator patterngenerator;

    List<Integer> eckpunkte11;
    List<Integer> eckpunkte12;
    List<Integer> eckpunkte13;
    List<Integer> eckpunkte14;
    List<Integer> eckpunkte15;
    List<List<Integer>> pattern1;

    List<List<Integer>> pattern2;
    List<Integer> eckpunkte21;
    List<Integer> eckpunkte22;
    List<Integer> eckpunkte23;
    List<Integer> eckpunkte24;
    List<Integer> eckpunkte25;

    ArrayList pattern3;



    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        patterngenerator = new Patterngenerator();
//        #################   Pattern 1   ############################################################################################
        eckpunkte11 = new ArrayList<>();
        eckpunkte11.add(1000);
        eckpunkte11.add(10);
        eckpunkte11.add(40);
        eckpunkte11.add(10);
        eckpunkte11.add(20);

        eckpunkte12 = new ArrayList<>();
        eckpunkte12.add(1000);
        eckpunkte12.add(10);
        eckpunkte12.add(20);
        eckpunkte12.add(20);
        eckpunkte12.add(50);

        eckpunkte13 = new ArrayList<>();
        eckpunkte13.add(1000);
        eckpunkte13.add(20);
        eckpunkte13.add(50);
        eckpunkte13.add(40);
        eckpunkte13.add(50);

        eckpunkte14 = new ArrayList<>();
        eckpunkte14.add(1000);
        eckpunkte14.add(40);
        eckpunkte14.add(50);
        eckpunkte14.add(10);
        eckpunkte14.add(40);

        eckpunkte15 = new ArrayList<>();
        eckpunkte15.add(1000);
        eckpunkte15.add(25);
        eckpunkte15.add(35);
        eckpunkte15.add(25);
        eckpunkte15.add(35);

        pattern1 = new ArrayList<>();
        pattern1.add(eckpunkte11);
        pattern1.add(eckpunkte12);
        pattern1.add(eckpunkte13);
        pattern1.add(eckpunkte14);
        pattern1.add(eckpunkte15);

//        #################   Pattern 2   ############################################################################################

        eckpunkte21 = new ArrayList<>();
        eckpunkte21.add(1000);
        eckpunkte21.add(5);
        eckpunkte21.add(25);
        eckpunkte21.add(10);
        eckpunkte21.add(30);

        eckpunkte22 = new ArrayList<>();
        eckpunkte22.add(1000);
        eckpunkte22.add(35);
        eckpunkte22.add(55);
        eckpunkte22.add(10);
        eckpunkte22.add(30);

        eckpunkte23 = new ArrayList<>();
        eckpunkte23.add(1000);
        eckpunkte23.add(5);
        eckpunkte23.add(25);
        eckpunkte23.add(40);
        eckpunkte23.add(60);

        eckpunkte24 = new ArrayList<>();
        eckpunkte24.add(1000);
        eckpunkte24.add(35);
        eckpunkte24.add(55);
        eckpunkte24.add(40);
        eckpunkte24.add(60);

        eckpunkte25 = new ArrayList<>();
        eckpunkte25.add(0);
        eckpunkte25.add(0);
        eckpunkte25.add(70);
        eckpunkte25.add(0);
        eckpunkte25.add(70);

        pattern2 = new ArrayList<>();
        pattern2.add(eckpunkte21);
        pattern2.add(eckpunkte22);
        pattern2.add(eckpunkte23);
        pattern2.add(eckpunkte24);
        pattern2.add(eckpunkte25);

//        #################   Pattern   ############################################################################################

//        System.out.println(pattern1);

//        pattern3 = new ArrayList<>(){
//            add("AAA");
//            add("BBB");
//        };



    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void generatePattern() {
        // pattern1
        assertEquals(5000, patterngenerator.generatePattern(pattern1, 1.0).size());
        assertEquals(2500, patterngenerator.generatePattern(pattern1, 0.5).size());
        for(Point point : patterngenerator.generatePattern(pattern1, 1.0)){
            Double xValue = point.getCoordinates().get(0);
            Double yValue = point.getCoordinates().get(1);
            // linker senkrechter Balken
            if(xValue>=10 && xValue<=20){
                assertTrue(yValue>=10 && yValue<=50);
            }
            // unter waagerechter Balken
            if(yValue>=10 && yValue<=20){
                assertTrue(xValue>=10 && xValue<=50);
            }
            // rechter senkrechter Balken
            if(xValue>=40 && xValue<=50){
                assertTrue(yValue>=10 && yValue<=50);
            }
            // oberer waagerechter Balken
            if(yValue>=40 && yValue<=50){
                assertTrue(xValue>=10 && xValue<=50);
            }
            // mittleres Quadrat
            if(xValue>=25 && xValue<=35){
                assertTrue((yValue>=10 && yValue<=20) || (yValue>=40 && yValue<=50) || (yValue>=25 && yValue<=35)  );
                assertFalse((yValue>20 && yValue<25) || (yValue>35 && yValue<40)   );
            }
        }

        //pattern2
        assertEquals(4000, patterngenerator.generatePattern(pattern2, 1.0).size());
        assertEquals(2000, patterngenerator.generatePattern(pattern2, 0.5).size());
        for(Point point : patterngenerator.generatePattern(pattern2, 1.0)){
            Double xValue = point.getCoordinates().get(0);
            Double yValue = point.getCoordinates().get(1);
            if((xValue>=5 && xValue<=25) || (xValue>=35 && xValue<=55)){
                assertTrue((yValue>=10 && yValue<=30) || (yValue>=40 && yValue<=60));
                assertFalse((yValue>=0 && yValue<10) || (yValue>30 && yValue<40) || (yValue>60 && yValue<=70));
            }
            if((yValue>=10 && yValue<=30) || (yValue>=40 && yValue<=60)){
                assertTrue((xValue>=5 && xValue<=25) || (xValue>=35 && xValue<=55));
                assertFalse((xValue>=0 && xValue<5) || (xValue>25 && xValue<35) || (xValue>55 && xValue<=70));
            }

        }
    }



    @org.junit.jupiter.api.Test
    void generateRectangle() {
        assertEquals(15, patterngenerator.generateRectangle(15, 1, 5, 2, 3).size());
        for(List<Integer> coordinates : patterngenerator.generateRectangle(15, 1, 5, 2, 3)){
//            System.out.println(coordinates);
            Integer x = coordinates.get(0);
            Integer y = coordinates.get(1);
            assertTrue((x>=1 && x<=5) && (y>=2 && y<=3));
            assertFalse((x<1 || x>5) || (y<2 || y>3));
        }

    }

    @org.junit.jupiter.api.Test
    void generateRandomNumbersRange() {
        assertEquals(1, patterngenerator.generateRandomNumbersRange(1, 0, 1).size());
        assertEquals(0, patterngenerator.generateRandomNumbersRange(0, 12,11095).size());
        assertEquals(15, patterngenerator.generateRandomNumbersRange(15, 0, 9).size());
        assertEquals(3, patterngenerator.generateRandomNumbersRange(5, 3,3).get(0));
        assertEquals(3, patterngenerator.generateRandomNumbersRange(5, 3,3).get(1));
        assertEquals(3, patterngenerator.generateRandomNumbersRange(5, 3,3).get(2));
        for(Integer i : patterngenerator.generateRandomNumbersRange(15,1,3)){
            assertTrue(i>=1 && i<=3);
        }
        for(Integer i : patterngenerator.generateRandomNumbersRange(15, 1, 3)){
            assertFalse(i<1 || i>3);
        }

    }
}