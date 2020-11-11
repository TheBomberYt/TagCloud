package dev.jaxi;
import java.util.*;
public class DataHouse {
    private ArrayList<String> uniqueWords;
    private TreeMap<String,Integer> unWordCount;
    private TreeMap<TagType,Integer> tagScores;
    public ArrayList<String> getUniqueWords() {
        return uniqueWords;
    }
    public TreeMap<String, Integer> getUnWordCount() {
        return unWordCount;
    }
    public TreeMap<TagType, Integer> getTagScores() {
        return tagScores;
    }
    public void setTagScores(TreeMap<TagType, Integer> tagScores) {
        this.tagScores = tagScores;
    }
    public void setUniqueWords(ArrayList<String> uniqueWords) {
        this.uniqueWords = uniqueWords;
    }
    public void setUnWordCount(TreeMap<String, Integer> unWordCount) {
        this.unWordCount = unWordCount;
    }
    public static void main(String[] args){

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
