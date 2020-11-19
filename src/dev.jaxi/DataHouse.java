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


        Pattern p = Pattern.compile("<p>(.*?)</p>");
        Pattern h1 = Pattern.compile("<h1>(.*?)</h1>");
        Pattern h2 = Pattern.compile("<h2>(.*?)</h2>");
        Pattern h3 = Pattern.compile("<h3>(.*?)</h3>");
        Pattern h4 = Pattern.compile("<h4>(.*?)</h4>");
        Pattern h5 = Pattern.compile("<h5>(.*?)</h5>");
        Pattern h6 = Pattern.compile("<h6>(.*?)</h6>");
        Pattern title = Pattern.compile("<title>(.*?)</title>");
        Pattern href = Pattern.compile("<a href =\"(.*?)\">(.*?)</a>");
        Pattern li = Pattern.compile("<li>(.*?)</li>");
        Matcher pm = p.matcher(str);
        Matcher h1m = h1.matcher(str);
        Matcher h2m = h2.matcher(str);
        Matcher h3m = h3.matcher(str);
        Matcher h4m = h4.matcher(str);
        Matcher h5m = h5.matcher(str);
        Matcher h6m = h6.matcher(str);
        Matcher titlem = title.matcher(str);
        Matcher hrefm = href.matcher(str);
        Matcher lim = li.matcher(str);
        //String sanitizedHTML = sanitizeHTML(str);
        while (pm.find())
        {
            // Worth one point
            String ps = pm.group(1);
            cleanWordList.forEach(string -> houseData(string.toLowerCase(), 1));
        }
        while (h1m.find())
        {
            // Worth 10 points
            String h1s = h1m.group(1);
            cleanWordList.forEach(string -> houseData(string.toLowerCase(), 10));
        }
        while (h2m.find())
        {
            // Worth 8 points
            String h2s = h2m.group(1);
            cleanWordList.forEach(string -> houseData(string.toLowerCase(), 8));
        }
        while (h3m.find())
        {
            // Worth 6 points
            String h3s = h3m.group(1);
            cleanWordList.forEach(string -> houseData(string.toLowerCase(), 6));
        }
        while (h4m.find())
        {
            // Worth 4 points
            String h4s = h4m.group(1);
            cleanWordList.forEach(string -> houseData(string.toLowerCase(), 4));
        }
        while (h5m.find())
        {
            // Worth 2 points
            String h5s = h5m.group(1);
            cleanWordList.forEach(string -> houseData(string.toLowerCase(), 2));
        }
        while (h6m.find())
        {
            // Worth one point
            String h6s = h6m.group(1);
            cleanWordList.forEach(string -> houseData(string.toLowerCase(), 1));

        }
        while (titlem.find())
        {
            // Worth 10 points
            String titles = titlem.group(1);
            cleanWordList.forEach(string -> houseData(string.toLowerCase(), 10));
        }
        while (hrefm.find())
        {
            // Worth 5 points
            String hrefs = hrefm.group(1);
            cleanWordList.forEach(string -> houseData(string.toLowerCase(), 5));
        }
        while (lim.find())
        {
            // Worth 1 point
            String lis = lim.group(1);
            cleanWordList.forEach(string -> houseData(string.toLowerCase(), 1));
        }

        tagScores.remove("");
        tagScores.remove("+");
        tagScores.remove("amp");
        tagScores.remove("nbsp");
        tagScores.remove("hr");
        tagScores.remove("http");
        tagScores.remove("null");

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
