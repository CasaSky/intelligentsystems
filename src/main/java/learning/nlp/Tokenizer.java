package learning.nlp;

import learning.dbscan.Point;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    String stringFahrrad1 = "Dies ist ein Text über ein Fahrrad.\n" + "Ein Fahrrad ist ein Fahrrad weil es fährt und Räder hat.\n" + "Ein Fahrrad hat zwei Räder.";
    String stringFahrrad2 = "Dies ist Text zwei über ein Fahrrad.\n" + "Wer Fahrrad fahren will braucht nicht unbedingt einen Helm.\n" + "Ein Fahrrad hat keinen Motor.";
    String stringFahrrad3 = "Dies ist Text drei über ein Fahrrad.\n" + "Ein Fahrrad ist nicht so schnell wie ein Moped.\n" + "Ein Fahrrad braucht kein Benzin.\n" + "Ein Fahrrad fährt auf dem Fahrrad Weg.";
    String stringMoped1 = "Dies ist ein Text über ein Moped.\n" + "Wer Moped fahren will braucht einen Moped Führerschein.\n" + "Ein Moped hat zwei Räder.";
    String stringMoped2 = "Dies ist Text zwei über ein Moped.\n" + "Ein Moped hat einen Motor.\n" + "Ein Moped ist schneller als ein Fahrrad.";
    String stringMoped3 = "Dies ist Text drei über ein Moped.\n" + "Ein Moped fährt mit Benzin.\n" + "Ein Moped hat manchmal auch drei Räder.\n" + "Wer ein Moped fahren will braucht einen Helm.";
    String stringText1 = "Dies ist ein Text über Text.\n" + "Das Thema von diesem Text ist Text, deshalb wird Text auch so oft erwähnt.\n" + "Text ohne Text ist ja kein Text.";
    String stringText2 = "Dies ist Text zwei über Text.\n" + "Es ist ein Text über ein Haus.\n" + "Es ist auch ein Text über einen Baum.";
    String stringText3 = "Dies ist Text drei über Text.\n" + "Ein Text kann sehr kurz sein.\n" + "Ein Text kann aber auch sehr lang sein.\n" + "Ob ein Text lang oder kurz ist hängt von der Anzahl der verwendeten Buchstaben ab.";
    List<String> dataset = createDataset();

    String stopwords = "ab\n" + "aber\n" + "alle\n" + "allem\n" + "allen\n" + "aller\n" + "allerdings\n" + "als\n" + "also\n" + "am\n" + "an\n" + "andere\n" + "anderem\n" + "anderen\n" + "anderer\n" + "andernfalls\n" + "anders\n" + "andersherum\n" + "anfangs\n" + "anhand\n" + "anschließend\n" + "ansonsten\n" + "anstatt\n" + "auch\n" + "auf\n" + "aufgrund\n" + "aus\n" + "außerdem\n" + "befindet\n" + "bei\n" + "beide\n" + "beim\n" + "beispielsweise\n" + "bereits\n" + "besonders\n" + "besteht\n" + "bestimmte\n" + "bestimmten\n" + "bestimmter\n" + "bevor\n" + "bietet\n" + "bis\n" + "bleiben\n" + "bringen\n" + "bringt\n" + "bsp\n" + "bzw\n" + "d.h\n" + "da\n" + "dabei\n" + "dafür\n" + "daher\n" + "damit\n" + "danach\n" + "dann\n" + "dar\n" + "daran\n" + "darauf\n" + "daraus\n" + "darf\n" + "darstellt\n" + "darüber\n" + "das\n" + "dass\n" + "davon\n" + "dazu\n" + "dem\n" + "demzufolge\n" + "den\n" + "denen\n" + "denn\n" + "der\n" + "deren\n" + "des\n" + "dessen\n" + "desto\n" + "die\n" + "dies\n" + "diese\n" + "diesem\n" + "diesen\n" + "dieser\n" + "dieses\n" + "doch\n" + "dort\n" + "durch\n" + "ebenfalls\n" + "eher\n" + "eigenen\n" + "eigentlich\n" + "ein\n" + "eine\n" + "einem\n" + "einen\n" + "einer\n" + "eines\n" + "einigen\n" + "einiges\n" + "einmal\n" + "einzelnen\n" + "entscheidend\n" + "entweder\n" + "er\n" + "erstmals\n" + "es\n" + "etc\n" + "etwas\n" + "euch\n" + "folgende\n" + "folgendem\n" + "folgenden\n" + "folgender\n" + "folgendes\n" + "folgt\n" + "für\n" + "ganz\n" + "gegen\n" + "gehen\n" + "gemacht\n" + "genannte\n" + "genannten\n" + "gerade\n" + "gerne\n" + "gibt\n" + "gilt\n" + "gleich\n" + "gleichen\n" + "gleichzeitig\n" + "habe\n" + "haben\n" + "hält\n" + "hat\n" + "hatte\n" + "hätte\n" + "hauptsächlich\n" + "her\n" + "heutigen\n" + "hier\n" + "hierbei\n" + "hierfür\n" + "hin\n" + "hingegen\n" + "hinzu\n" + "hoch\n" + "ihn\n" + "ihr\n" + "ihre\n" + "ihren\n" + "ihrer\n" + "im\n" + "immer\n" + "immerhin\n" + "in\n" + "indem\n" + "insgesamt\n" + "ist\n" + "ja\n" + "je\n" + "jede\n" + "jedem\n" + "jeder\n" + "jedes\n" + "jedoch\n" + "jetzt\n" + "jeweilige\n" + "jeweiligen\n" + "jeweils\n" + "kam\n" + "kann\n" + "keine\n" + "kommen\n" + "kommt\n" + "können\n" + "konnte\n" + "könnte\n" + "konnten\n" + "lassen\n" + "lässt\n" + "lautet\n" + "lediglich\n" + "leider\n" + "letztendlich\n" + "letztere\n" + "letzteres\n" + "liegt\n" + "machen\n" + "macht\n" + "mal\n" + "man\n" + "mehr\n" + "mehrere\n" + "meine\n" + "meinem\n" + "meisten\n" + "mich\n" + "mit\n" + "mithilfe\n" + "mittels\n" + "möchte\n" + "möglich\n" + "möglichst\n" + "momentan\n" + "muss\n" + "müssen\n" + "musste\n" + "nach\n" + "nachdem\n" + "nächsten\n" + "nahezu\n" + "nämlich\n" + "natürlich\n" + "neue\n" + "neuen\n" + "nicht\n" + "nichts\n" + "noch\n" + "nun\n" + "nur\n" + "ob\n" + "obwohl\n" + "oder\n" + "oftmals\n" + "ohne\n" + "per\n" + "sämtliche\n" + "scheint\n" + "schon\n" + "sehr\n" + "sein\n" + "seine\n" + "seinem\n" + "seinen\n" + "sich\n" + "sicherlich\n" + "sie\n" + "siehe\n" + "sind\n" + "so\n" + "sobald\n" + "sofern\n" + "solche\n" + "solchen\n" + "soll\n" + "sollen\n" + "sollte\n" + "sollten\n" + "somit\n" + "sondern\n" + "sorgt\n" + "sowie\n" + "sowohl\n" + "später\n" + "sprich\n" + "statt\n" + "trotz\n" + "über\n" + "überhaupt\n" + "um\n" + "und\n" + "uns\n" + "unter\n" + "usw\n" + "viel\n" + "viele\n" + "vielen\n" + "völlig\n" + "vom\n" + "von\n" + "vor\n" + "vorerst\n" + "vorher\n" + "während\n" + "war\n" + "wäre\n" + "waren\n" + "warum\n" + "was\n" + "weil\n" + "weitere\n" + "weiteren\n" + "weiterer\n" + "weiteres\n" + "weiterhin\n" + "welche\n" + "welchen\n" + "welcher\n" + "welches\n" + "wenn\n" + "wer\n" + "werden\n" + "wesentlich\n" + "wichtige\n" + "wichtigsten\n" + "wie\n" + "wieder\n" + "wiederum\n" + "will\n" + "wir\n" + "wird\n" + "wirklich\n" + "wo\n" + "wobei\n" + "worden\n" + "wurde\n" + "wurden\n" + "z.b\n" + "ziemlich\n" + "zu\n" + "zuerst\n" + "zum\n" + "zur\n" + "zusätzlich\n" + "zuvor\n" + "zwar\n" + "zwecks";

    public Tokenizer(){
    }


    public List<String> getDataset() {
        return dataset;
    }

    public void setDataset(List<String> dataset) {
        this.dataset = dataset;
    }

    public String[] getStopwordsArray() {
        return stopwordsArray;
    }

    public void setStopwordsArray(String[] stopwordsArray) {
        this.stopwordsArray = stopwordsArray;
    }

    String[] stopwordsArray = stopwords.split("\\s");
    List<String> stopwordsList = createStopWordsList(stopwordsArray);
//    List<String> stopwordsList = createwordlistWithoutDoubles(stopwordsArray);


    public String getStringFahrrad1() {
        return stringFahrrad1;
    }

    public void setStringFahrrad1(String stringFahrrad1) {
        this.stringFahrrad1 = stringFahrrad1;
    }

    public String getStringFahrrad2() {
        return stringFahrrad2;
    }

    public void setStringFahrrad2(String stringFahrrad2) {
        this.stringFahrrad2 = stringFahrrad2;
    }

    public String getStringFahrrad3() {
        return stringFahrrad3;
    }

    public void setStringFahrrad3(String stringFahrrad3) {
        this.stringFahrrad3 = stringFahrrad3;
    }

    public String getStopwords() {
        return stopwords;
    }

    public void setStopwords(String stopwords) {
        this.stopwords = stopwords;
    }

    public List<String> getStopwordsList() {
        return stopwordsList;
    }

    public void setStopwordsList(List<String> stopwordsList) {
        this.stopwordsList = stopwordsList;
    }

    public List<String> createDataset(){
        List<String> result = new ArrayList<>();
        result.add(stringFahrrad1);
        result.add(stringFahrrad2);
        result.add(stringFahrrad3);
        result.add(stringMoped1);
        result.add(stringMoped2);
        result.add(stringMoped3);
        result.add(stringText1);
        result.add(stringText2);
        result.add(stringText3);
        return result;
    }

    public List<String> tokenize(String string){
         List<String> result = new ArrayList<>();
         String[] stringArray = string.split("(\\s|\\p{Punct})+");
         for(int i=0; i<stringArray.length; i++){
             String partString = stringArray[i];
             partString = partString.toLowerCase();
             result.add(partString);
         }
         return result;
    }

    public List<String> createStopWordsList(String[] stringArray){
        List<String> result = new ArrayList<>();
        for(String string : stringArray){
            result.add(string);
        }
        return result;
    }

    public List<String> createwordlistWithoutDoubles(List<String> tokens){
        List<String> result = new ArrayList<>();
        for(int i=0; i<tokens.size(); i++){
            if (!result.contains(tokens.get(i))){
                result.add(tokens.get(i));
            }
        }
        return result;
    }

    public List<String> createCompleteWordSet(List<String> dataset){
        List<String> result = new ArrayList<>();
        for(String document : dataset){
            List<String> tokenizedDocumentWithoutStopwords = deleteStopWords(tokenize(document));
            for(String word : tokenizedDocumentWithoutStopwords){
                if(!result.contains(word)){
                    result.add(word);
                }
            }
        }
        return result;
    }

    public List<String> deleteStopWords(List<String> stringList){
        List<String> result = new ArrayList<>();
        for(String string : stringList){
            if(!stopwordsList.contains(string)){
                result.add(string);
            }
        }
        return result;
    }

    public Integer countNumberOfOccurrences(List<String> stringList, String word){
        Integer result = 0;
        for(String occurence : stringList){
            if(word.equals(occurence)){
                result++;
            }
        }
        return result;
    }

    public Double computeTF(List<String> document, String word){
        Double result = 0.0;
        Integer numberOfOccurrencesInDocument = countNumberOfOccurrences(document, word);
        Integer numberOfTermsInDocument = document.size();
        result = numberOfOccurrencesInDocument.doubleValue() / numberOfTermsInDocument.doubleValue();
        return result;
    }

    public Double computeIDF(List<String> dataset, String word){
        Double result = 0.0;
        Integer numberOfDocuments = dataset.size();
        Integer numberOfDocumentsWithOccurrences = findDocumentsWithOccurrences(dataset, word);
        Double quotient = numberOfDocuments.doubleValue() / numberOfDocumentsWithOccurrences.doubleValue();
//        System.out.println(numberOfDocuments);
//        System.out.println(numberOfDocumentsWithOccurrences);
//        System.out.println(quotient);
        result = Math.log10(quotient);
        return result;
    }

    public Integer findDocumentsWithOccurrences(List<String> dataset, String word) {
        List<List<String>> tokenizedDatasetWithoutStopwords = new ArrayList<>();
        for(String document : dataset){
            tokenizedDatasetWithoutStopwords.add(deleteStopWords(tokenize(document)));
        }
//        System.out.println(tokenizedDatasetWithoutStopwords);
        Integer result = 0;
        for(List<String> tokenizedDocument : tokenizedDatasetWithoutStopwords){
            if(tokenizedDocument.contains(word)){
                result++;
            }
        }
        return result;
    }

    public Double computeTFIDF(List<String> document, List<String> dataset, String word){
        Double result = 0.0;
        Double tf = computeTF(document, word);
        Double idf = computeIDF(dataset, word);
//        System.out.println("tf = " + tf);
//        System.out.println("idf = " + idf);
//        System.out.println("tfidf = " + result);

        result = tf * idf;
        return result;
    }

    public List<Point> computeTFIDFPoints(List<String> dataset){
        List<Point> result = new ArrayList<>();
        Integer documentcounter = 0;
        List<String> completeWordSet = createCompleteWordSet(dataset);
                                                                                                            System.out.println(completeWordSet);


        for(String document : dataset){
            List<String> tokenizedDocumentWithoutStopwords = deleteStopWords(tokenize(document));
                                                                                                            System.out.println(tokenizedDocumentWithoutStopwords);
            List<Double> coordinates = new ArrayList<>();

            for(String word : completeWordSet){
                Double coordinate = computeTFIDF(tokenizedDocumentWithoutStopwords, dataset, word);
                coordinates.add(coordinate);
            }
            Point documentPoint = new Point(documentcounter, coordinates);
                                                                                                            System.out.println(documentPoint);
            result.add(documentPoint);

            documentcounter++;
        }


        return result;
    }




}
