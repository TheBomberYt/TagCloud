package dev.jaxi;
import java.util.*;
import java.util.regex.*;
import java.lang.*;
public class DataHouse {
    private ArrayList<String> Words;
    private TreeMap<String,Integer> unWordScores;
    private static TreeMap<String,Integer> tagScores = new TreeMap<String, Integer>();

    public DataHouse(String data){
        tagScores.put(".*< *h1.*>.*< */ *h1.*>.*",10);
        tagScores.put(".*< *h2.*>.*< */ *h2.*>.*",8);
        tagScores.put(".*< *h3.*>.*< */ *h3.*>.*",6);
        tagScores.put(".*< *h4.*>.*< */ *h4.*>.*",4);
        tagScores.put(".*< *h5.*>.*< */ *h5.*>.*",2);
        tagScores.put(".*< *h6.*>.*< */ *h6.*>.*",1);
        tagScores.put(".*< *a *href *= *\".*\".*>.*< */ *a *>.*",5);
        tagScores.put(".*< *title.*< */ *title *>.*",10);
        tagScores.put(".*< *ul .*>.*< *li .*>.*< */ *li *>.*< */ *ul *>",1);


        process(data);
    }
    public void process(String str) {
    String[] temp=str.split("\n");
    for(int x=0;x<temp.length;x++){

    }
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
class TagType {
    public int value;
    public TagType(String x){

    }

    public int getValue() {
        return value;
    }


    public int compareTo(TagType o) {
        return value-o.getValue();
    }



}
