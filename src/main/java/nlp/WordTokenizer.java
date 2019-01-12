package nlp;

import java.util.*;

/**
 * Simple tokenizer -_-
 */
public class WordTokenizer {

    public Map<Integer, List<String>> tokenize(List<String> documents) {
        Map<Integer, List<String>> corpus = new HashMap<>();
        for (int i=0; i<documents.size(); i++) {
            System.out.println("\nTokenize document " + i);
            List<String> tokens = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(documents.get(i));
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                System.out.print(token + "<*>");
                tokens.add(token);
            }
            corpus.put(i, tokens);
        }
        return corpus;
    }
}
