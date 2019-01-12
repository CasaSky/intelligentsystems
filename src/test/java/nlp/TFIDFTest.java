package nlp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TFIDFTest {

    @DisplayName("TF-IDF and WordTokenizer computed successfully")
    @Test
    void computeTFIDFAndTokenizeSuccesfully() {
        List<String> documents = readDocuments();
        Assertions.assertFalse(documents == null);
        Assertions.assertTrue(documents.size() == 2);

        WordTokenizer wordTokenizer = new WordTokenizer();
        Map<Integer, List<String>> corpus = wordTokenizer.tokenize(documents);
        Assertions.assertFalse(corpus == null);
        Assertions.assertTrue(corpus.size() == 2);

        TFIDF tfidf = new TFIDF();
        Map<Integer, List<Double>> vectorOfWeights = tfidf.compute(corpus);
        Assertions.assertFalse(vectorOfWeights == null);
        Assertions.assertTrue(vectorOfWeights.size() == 2);
    }


    private static List<String> readDocuments() {
        final String documentName = "document";
        List<String> documents = new ArrayList<>();

        try {
            for (int i=1; i<=2; i++) {
                String lines = "";
                for (String line : Files.readAllLines(Paths.get(documentName + i))) {
                    lines += line;
                }
                System.out.println(lines);
                documents.add(lines);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return documents;
    }
}
