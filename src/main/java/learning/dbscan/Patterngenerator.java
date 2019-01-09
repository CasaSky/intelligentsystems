package learning.dbscan;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Patterngenerator {
    List<Point> pattern;

    public Patterngenerator() {
        pattern = new ArrayList<>();
    }

    public List<Point> generatePattern(List<List<Integer>> rectangleList, Double numberOfPointsPerRectangleModificator) {
        List<List<Integer>> coordinatesList = new ArrayList<>();
        List<Point> resultList = new ArrayList<>();
        for (int i=0; i<rectangleList.size(); i++) {
            Integer numberOfPoints, x1, x2, y1, y2;
            Double nOPTemp = rectangleList.get(i).get(0) * numberOfPointsPerRectangleModificator;
            numberOfPoints = nOPTemp.intValue();
            x1 = rectangleList.get(i).get(1);
            x2 = rectangleList.get(i).get(2);
            y1 = rectangleList.get(i).get(3);
            y2 = rectangleList.get(i).get(4);
            List<List<Integer>> tempCoordinatesList = generateRectangle(numberOfPoints, x1, x2, y1, y2);
            for(List<Integer> coordinates : tempCoordinatesList){
                coordinatesList.add(coordinates);
            }
        }

        for(List<Integer> coordinates : coordinatesList){
            Integer idCounter = 0;
            List<Double> tempCoordinates = new ArrayList<>();
            tempCoordinates.add(coordinates.get(0).doubleValue());
            tempCoordinates.add(coordinates.get(1).doubleValue());
            Point tempPoint = new Point(idCounter, tempCoordinates);
            resultList.add(tempPoint);
            idCounter++;
        }
        return resultList;
    }

    public List<List<Integer>> generateRectangle(Integer numberOfPoints, Integer xMinimum, Integer xMaximum, Integer yMinimum, Integer yMaximum) {
        List<Integer> xList = generateRandomNumbersRange(numberOfPoints, xMinimum, xMaximum);
        List<Integer> yList = generateRandomNumbersRange(numberOfPoints, yMinimum, yMaximum);
        List<List<Integer>> resultList = new ArrayList<>();
        for(int i=0; i<numberOfPoints; i++){
            List<Integer> coordinatesTemp = new ArrayList<>();
            coordinatesTemp.add(xList.get(i));
            coordinatesTemp.add(yList.get(i));
            resultList.add(coordinatesTemp);
        }
        return resultList;
    }

    public List<Integer> generateRandomNumbersRange(Integer numberOfNumbers, Integer minimum, Integer maximum){
        Random random = new Random();
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<numberOfNumbers; i++){
            int randomInt = random.nextInt(maximum - minimum + 1) + minimum;
            result.add(randomInt);
        }
        return result;
    }

}
