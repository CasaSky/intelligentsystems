package nlp;

import learning.dbscan.Dbscan;
import learning.dbscan.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TFIDFTest {

    @DisplayName("TF-IDF computed successfully")
    @Test
    void computeTFIDFSuccesfully() {
        List<String> documents = readDocuments("document");
        Assertions.assertFalse(documents == null);
//        Assertions.assertTrue(documents.size() == 2);

        TextProcessing wordTokenizer = new TextProcessing(readStopwords());
        Map<Integer, List<String>> corpus = wordTokenizer.compute(documents);
        Assertions.assertFalse(corpus == null);
//        Assertions.assertTrue(corpus.size() == 2);

        TFIDF tfidf = new TFIDF();
        Map<Integer, List<Double>> vectorOfWeights = tfidf.compute(corpus);
        Assertions.assertFalse(vectorOfWeights == null);
  //      Assertions.assertTrue(vectorOfWeights.size() == 2);

        List<Point> dataSet = new ArrayList<>();
        for (Map.Entry<Integer, List<Double>> document : vectorOfWeights.entrySet()) {
            dataSet.add(new Point(document.getKey(), document.getValue()));
        }
        // min eps = 0.10
        // max eps = 0.133
        Dbscan dbscan = new Dbscan(dataSet, 0.130, 2);
        Map<Integer, List<Point>> dataLabels = dbscan.findDataLabels();
        Assertions.assertFalse(dataLabels == null);
        for (Map.Entry<Integer, List<Point>> cluster : dataLabels.entrySet()) {
            Integer key = cluster.getKey();
            String text = key == -1 ? "\nRauschen" : "\nCluster " + key;
            System.out.println(text + ":");
            for (Point point : cluster.getValue()) {
                System.out.print("-->");
                System.out.println(point);
            }

        }

        System.out.println("\nAnzahl Cluster: " + (dataLabels.size() - 1));
    }

    private List<String> readStopwords() {
        List<String> document = new ArrayList<>();
        try {
            for (String line : Files.readAllLines(Paths.get("stopwords"))) {
                document.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return document;
    }
    
    private static List<String> readDocuments(String documentName) {
        List<String> documents = new ArrayList<>();
        for (int i=1; i<=6; i++) {
            documents.add(readDocument(documentName + i));
        }
        return documents;
    }

    private static String readDocument(String documentName) {
        String document = "";
        try {
            String lines = "";
            for (String line : Files.readAllLines(Paths.get(documentName))) {
                lines += line;
            }
            System.out.println(lines);
            document = lines;


        } catch (IOException e) {
            e.printStackTrace();
        }

        return document;
    }
}
