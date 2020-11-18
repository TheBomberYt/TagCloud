package dev.jaxi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataHouse {

    private ArrayList<String> wordsList;
    private static TreeMap<String,Integer> tagScores = new TreeMap<String, Integer>();

    //optimizations of process() method by pre-compiling regex
    public Pattern regexHTMLParse = Pattern.compile("<(?:\"[^\"]*\"['\"]*|'[^']*'['\"]*|[^'\">])+>");
    public Pattern regexALPHAParse = Pattern.compile("[^a-zA-Z\\\\s+]");
    public Pattern regexWHITESPACEParse = Pattern.compile("\\\\s+");

    public DataHouse(String data){

        process(data);
        TagCloud YeahBoi2 = new TagCloud(tagScores);

    }
    public void process(String str) {

        ArrayList<String> cleanWordList = arrayifyStringAndClean(sanitizeHTML(str));

        Pattern test = Pattern.compile("<p>(.*?)</p>|<h1>(.*?)</h1>|<h2>(.*?)</h2>|<h3>(.*?)</h3>|<h4>(.*?)</h4>|<h5>(.*?)</h5>|<h6>(.*?)</h6>|<title>(.*?)</title>|<a href =\"(.*?)\">(.*?)</a>|<li>(.*?)</li>");
        Matcher testm = test.matcher(str);

        while(testm.find()) {
            String tests = testm.group(1);
            cleanWordList.forEach(string -> houseData(string.toLowerCase(), 1));
        }
        tagScores.remove("");
        tagScores.remove("+");
        tagScores.remove("amp");
        tagScores.remove("nbsp");

        System.out.println(tagScores);

    }
    public void putIntoTagScores(Matcher mat, int value) {

        String matString = mat.group(1);

        while(mat.find()) {
            arrayifyStringAndClean(sanitizeHTML(matString)).forEach(string -> houseData(string.toLowerCase(), value));
        }

    }
    public TreeMap<String, Integer> houseData(String tag, int value) {

        if(tagScores.containsKey(tag)) {
            tagScores.put(tag, tagScores.get(tag)+value);
        } else
            tagScores.put(tag, value);

        return tagScores;

    }

    public String sanitizeHTML(String unSanitizedHTML) {

        String sanitizedHTML = unSanitizedHTML.replaceAll(regexHTMLParse.pattern(), "").replaceAll(regexALPHAParse.pattern(), " ").replaceAll("&.*?;" , "");

        return sanitizedHTML;

    }

    public ArrayList<String> arrayifyStringAndClean(String sanitizedHTML) {

        String[] words = (sanitizedHTML.split(" "));
        wordsList = new ArrayList<String>(Arrays.asList(words));

        int size = wordsList.size();
        for (int i = 0; i < size; i++) {
            if (wordsList.get(i).equals(regexWHITESPACEParse.pattern()) || wordsList.get(i).length() < 2 || wordsList.get(i) == null || (wordsList.get(i).equals(""))) {
                wordsList.remove(i);

            }

            return wordsList;

        }

        return wordsList;

    }
    //get methods are for chumps
}
