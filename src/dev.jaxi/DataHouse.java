package dev.jaxi;
import java.util.*;
import java.util.regex.*;
import java.lang.*;
public class DataHouse {
    private ArrayList<String> Words;
    private static TreeMap<String,Integer> tagScores = new TreeMap<String, Integer>();
    public DataHouse(String data){
        process(data);
        TagCloud YeahBoi2 = new TagCloud(tagScores);
    }
    public void process(String str) {

        /*
        String temp = str.replaceAll("<([A-Z][A-Z0-9]*)\\b[^>]*>.*?</\\1>","");
        String[] test = temp.split("              ");
    for( String x:test){
        String tag=x;}
        */

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

        while (pm.find())
        {
            // Worth one point
            String ps = pm.group(1);
            arrayifyStringAndClean(sanitizeHTML(ps)).forEach(string -> houseData(string, 1));
           // houseData() // Store in treeMap
            System.out.print(tagScores);

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
        ArrayList<String> wordsList = new ArrayList<String>(Arrays.asList(words));
        for(int i=0; i<wordsList.size(); i++) {
            if(wordsList.get(i)=="\\\\s+"|| wordsList.get(i)=="nbsp" || wordsList.get(i).length()<2 || wordsList.get(i) == null || !(wordsList.get(i).substring(0,1) == "[^\\\\x20-\\\\x7e]")) {
                wordsList.remove(i);
            }
        }
        return wordsList;

    }

    public ArrayList<String> getWords() {
        return Words;
    }


}
