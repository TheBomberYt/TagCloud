package dev.jaxi;
import java.util.*;
import java.util.regex.*;
import java.lang.*;
public class DataHouse {

    private ArrayList<String> wordsList;
    private static TreeMap<String,Integer> tagScores = new TreeMap<String, Integer>();

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
            // Worth one point
            String h1s = h1m.group(1);
            cleanWordList.forEach(string -> houseData(string.toLowerCase(), 10));

        }

        while (h2m.find())
        {
            // Worth one point
            String h2s = h2m.group(1);
            cleanWordList.forEach(string -> houseData(string.toLowerCase(), 8));

        }
        while (h3m.find())
        {
            // Worth one point
            String h3s = h3m.group(1);
            cleanWordList.forEach(string -> houseData(string.toLowerCase(), 6));

        }
        while (h4m.find())
        {
            // Worth one point
            String h4s = h4m.group(1);
            cleanWordList.forEach(string -> houseData(string.toLowerCase(), 4));

        }
        while (h5m.find())
        {
            // Worth one point
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
            // Worth one point
            String titles = titlem.group(1);
            cleanWordList.forEach(string -> houseData(string.toLowerCase(), 10));

        }
        while (hrefm.find())
        {
            // Worth one point
            String hrefs = hrefm.group(1);
            cleanWordList.forEach(string -> houseData(string.toLowerCase(), 5));

        }
        while (lim.find())
        {
            // Worth one point
            String lis = lim.group(1);
            cleanWordList.forEach(string -> houseData(string.toLowerCase(), 1));

        }
        tagScores.remove("");
        tagScores.remove("+");
        //putIntoTagScores(h1m, 10);
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

        //System.out.println(tagScores); //test to make sure it works
        return tagScores;

    }

    public String sanitizeHTML(String unSanitizedHTML) {

        String sanitizedHTML = unSanitizedHTML.replaceAll("<(?:\"[^\"]*\"['\"]*|'[^']*'['\"]*|[^'\">])+>", "").replaceAll("[^a-zA-Z\\\\s+]", " ").replaceAll("&.*?;" , "").replace(".", " ").replace(",", "").replace(":", " ");
        sanitizedHTML = sanitizedHTML.replaceAll("[\\uFEFF-\\uFFFF]", "");

        return sanitizedHTML;

    }
    public ArrayList<String> arrayifyStringAndClean(String sanitizedHTML) {

        String[] words = (sanitizedHTML.split(" "));
        wordsList = new ArrayList<String>(Arrays.asList(words));

        for(int i=0; i<wordsList.size(); i++) {

            if(wordsList.get(i).equals("\\\\s+")|| wordsList.get(i).equals("nbsp") || wordsList.get(i).length()<2 || wordsList.get(i) == null || (wordsList.get(i).equals(""))) {
                wordsList.remove(i);
            }

        }

        return wordsList;
    }

 //get methods are for chumps


}
