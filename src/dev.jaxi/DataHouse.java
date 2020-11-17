package dev.jaxi;
import java.util.*;
import java.util.regex.*;
import java.lang.*;
public class DataHouse {
    private ArrayList<String> Words;
    private static TreeMap<String,Integer> tagScores = new TreeMap<String, Integer>();
    public DataHouse(String data){
        process(data);
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
            String ps = pm.group(1);
            ps = ps.replaceAll("<[/]?a[^>]*>", "");
            System.out.print(sanitizeHTML(ps)); // Store in treeMap

        }
    }

    public TreeMap<String, Integer> houseData(String tag, int value) {
        if(tagScores.containsKey(tag)) {

        }
        return null;
    }

    public String sanitizeHTML(String unSanitizedHTML) {
        String sanitizedHTML = unSanitizedHTML.replaceAll("<(?:\"[^\"]*\"['\"]*|'[^']*'['\"]*|[^'\">])+>", "").replaceAll("&.*?;" , "").replace(".", " ").replace(",", "").replace(":", " ");
        sanitizedHTML = sanitizedHTML.replaceAll("[^a-zA-Z\\\\s+]", "");
        return sanitizedHTML;
    }




    public ArrayList<String> getWords() {
        return Words;
    }

    public TreeMap<String, Integer> getTagScores() {
        return tagScores;
    }

    

    public static void main(String[] args){
    System.out.println("");
    }
}
