package nlp;

import org.apache.commons.lang3.math.NumberUtils;
import org.tartarus.snowball.ext.German2Stemmer;
import org.tartarus.snowball.ext.GermanStemmer;

import java.util.*;

/**
 * Text Processing
 */
public class TextProcessing {

    private List<String> stopWords;

    public TextProcessing(List<String> stopWords) {
        this.stopWords = stopWords;
    }

    public Map<Integer, List<String>> compute(List<String> documents) {
        Map<Integer, List<String>> corpus = new HashMap<>();
        for (int i=0; i<documents.size(); i++) {
            System.out.println("\nProcessing document " + (i+1));

            List<String> normalizedTerms = new ArrayList<>();

            List<String> tokens = tokenize(documents.get(i));
            for (String token : tokens) {
                String normalizedTerm = normalize(token);
                if (normalizedTerm != null) {
                    normalizedTerms.add(normalizedTerm);
                }
            }

            corpus.put(i+1, normalizedTerms);
        }
        return corpus;
    }

    private List<String> tokenize(String text) {
        List<String> tokens = Arrays.asList(text.toLowerCase().split("(\\s|\\p{Punct})+"));

        return tokens;
    }

    private String normalize(String token) {
        String term = isStopWord(token) || isNumber(token) ? null : stem(token);

        return term;
    }

    private String stem(String term) {
        German2Stemmer stemmer = new German2Stemmer();
        stemmer.setCurrent(term);
        String stem = null;
        if (stemmer.stem()){
            stem = stemmer.getCurrent();
            System.out.println("Stem: " + term  + "->" + stem);
        } else {
            System.out.println("Stem: " + term + "->" + term);
        }
        return stem;
    }

    private boolean isStopWord(String token) {
        return stopWords.contains(token);
    }

    private boolean isNumber(String token) {
        return NumberUtils.isDigits(token);
    }
}
