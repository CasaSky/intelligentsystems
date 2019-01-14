package nlp;

import java.util.*;
import java.util.stream.Collectors;

/**
 * TF-IDF: Term frequency - Inversion document frequency class that computes a term-weighting vector of a given corpus
 * The tf–idf value increases proportionally to the number of times a word appears in the document
 * and is offset by the number of documents in the corpus that contain the word,
 * which helps to adjust for the fact that some words appear more frequently in general. @source Wikipedia
 * @author Talal Tabia
 */
public class TFIDF {

    public TFIDF() { }

    /**
     * Computes the tf-idf weights vector for a given corpus
     * @param corpus is a key-value map containing all documents.
     *               The key is the document number and the value is a list of terms that are in the document.
     * @return a key-value containing the weight of each term in all documents (Coordinates).
     *         Where the key is the document number and the value is a list of term-weights of all document terms.
     */
    public Map<Integer, List<Double>> compute(Map<Integer, List<String>> corpus) {
        Map<Integer, List<Double>> vectorOfWeights= new HashMap<>();

        int counter = 1;
        List<String> terms = computeTerms(corpus);
        for (Map.Entry<Integer, List<String>> document : corpus.entrySet()) {
            System.out.println("\n\nComputing TFIDF for document " + counter);
            counter ++;
            if (terms.size() == 0) {
                System.out.println("Document " + document.getKey() + " does not have any terms");
                continue;
            }
            List<Double> weights = new ArrayList<>();
            for (String term : terms) {
                double termFrequency = termFrequency(term, document.getValue());
                double inverseDocumentFrequency = inverseDocumentFrequency(term, corpus);
                double frequency = termFrequency * inverseDocumentFrequency;
                System.out.println(term + " >W> " + frequency);
                weights.add(frequency);
            }
            vectorOfWeights.put(document.getKey(), weights);
        }

        return vectorOfWeights;
    }

    private List<String> computeTerms(Map<Integer, List<String>> corpus) {
        Set<String> uniqueTerms = new LinkedHashSet<>();
        for (Map.Entry<Integer, List<String>> document : corpus.entrySet()) {
            for (String term : document.getValue()) {
                uniqueTerms.add(term);
            }
        }

        return uniqueTerms.stream().collect(Collectors.toList());
    }

    private double termFrequency(String term, List<String> terms) {
        double termCount = terms.stream().filter(t -> term.equalsIgnoreCase(t)).count();
        double maxTerms = terms.size();

        double frequency = termCount / maxTerms;
        return frequency;
    }

    private double inverseDocumentFrequency(String term, Map<Integer, List<String>> corpus) {
        double numberOfDocuments = corpus.size();
        double termAppearanceCount = corpus.values().stream().filter(document -> document.contains(term)).count();
        if (termAppearanceCount == 0) {
            termAppearanceCount = 1;
        }

        double frequency = Math.log10(numberOfDocuments / termAppearanceCount);
        return frequency;
    }
}
