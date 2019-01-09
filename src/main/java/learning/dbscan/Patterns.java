package learning.dbscan;

import java.util.ArrayList;
import java.util.List;

public class Patterns {
    Patterngenerator patterngenerator = new Patterngenerator();
//    private List<List<Integer>> pattern1Coordinates = new ArrayList<>();
//    private List<List<Integer>> pattern2Coordinates = new ArrayList<>();


    public Patterns() {
    }

    public List<List<Integer>> createPattern1(){
        List<Integer> eckpunkte11 = new ArrayList<>();
        eckpunkte11.add(1000);
        eckpunkte11.add(10);
        eckpunkte11.add(40);
        eckpunkte11.add(10);
        eckpunkte11.add(20);

        List<Integer> eckpunkte12 = new ArrayList<>();
        eckpunkte12.add(1000);
        eckpunkte12.add(10);
        eckpunkte12.add(20);
        eckpunkte12.add(20);
        eckpunkte12.add(50);

        List<Integer> eckpunkte13 = new ArrayList<>();
        eckpunkte13.add(1000);
        eckpunkte13.add(20);
        eckpunkte13.add(50);
        eckpunkte13.add(40);
        eckpunkte13.add(50);

        List<Integer> eckpunkte14 = new ArrayList<>();
        eckpunkte14.add(1000);
        eckpunkte14.add(40);
        eckpunkte14.add(50);
        eckpunkte14.add(10);
        eckpunkte14.add(40);

        List<Integer> eckpunkte15 = new ArrayList<>();
        eckpunkte15.add(1000);
        eckpunkte15.add(25);
        eckpunkte15.add(35);
        eckpunkte15.add(25);
        eckpunkte15.add(35);

        List<Integer> rauschpunkte1 = new ArrayList<>();
        rauschpunkte1.add(0);
        rauschpunkte1.add(0);
        rauschpunkte1.add(70);
        rauschpunkte1.add(0);
        rauschpunkte1.add(70);

        List<List<Integer>> pattern1Coordinates = new ArrayList<>();
        pattern1Coordinates.add(eckpunkte11);
        pattern1Coordinates.add(eckpunkte11);
        pattern1Coordinates.add(eckpunkte12);
        pattern1Coordinates.add(eckpunkte13);
        pattern1Coordinates.add(eckpunkte14);
        pattern1Coordinates.add(eckpunkte15);
        pattern1Coordinates.add(rauschpunkte1);

        return pattern1Coordinates;

    }

    public List<List<Integer>> createPattern2() {
        List<Integer> eckpunkte21 = new ArrayList<>();
        eckpunkte21.add(1000);
        eckpunkte21.add(5);
        eckpunkte21.add(25);
        eckpunkte21.add(10);
        eckpunkte21.add(30);

        List<Integer> eckpunkte22 = new ArrayList<>();
        eckpunkte22.add(1000);
        eckpunkte22.add(35);
        eckpunkte22.add(55);
        eckpunkte22.add(10);
        eckpunkte22.add(30);

        List<Integer> eckpunkte23 = new ArrayList<>();
        eckpunkte23.add(1000);
        eckpunkte23.add(5);
        eckpunkte23.add(25);
        eckpunkte23.add(40);
        eckpunkte23.add(60);

        List<Integer> eckpunkte24 = new ArrayList<>();
        eckpunkte24.add(1000);
        eckpunkte24.add(35);
        eckpunkte24.add(55);
        eckpunkte24.add(40);
        eckpunkte24.add(60);

        List<Integer> rauschpunkte2 = new ArrayList<>();
        rauschpunkte2.add(0);
        rauschpunkte2.add(0);
        rauschpunkte2.add(70);
        rauschpunkte2.add(0);
        rauschpunkte2.add(70);


        List<List<Integer>> pattern2Coordinates = new ArrayList<>();
        pattern2Coordinates.add(eckpunkte21);
        pattern2Coordinates.add(eckpunkte22);
        pattern2Coordinates.add(eckpunkte23);
        pattern2Coordinates.add(eckpunkte24);
        pattern2Coordinates.add(rauschpunkte2);

        return pattern2Coordinates;
    }





}
