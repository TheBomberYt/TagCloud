package dev.jaxi;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;


public class WebScraper {

    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();;

        try {
            URL url = new URL("https://www.cfisd.net/en");
            File httpDoc = new File("index.html");
            if(httpDoc.exists()) httpDoc.delete();

            String.valueOf(Files.copy(url.openStream(), Paths.get("index.html")));
            FileReader httpDocString = new FileReader(httpDoc);
            final StringBuilder builder = new StringBuilder();



            //from https://www.oracle.com/technical-resources/articles/javase/perftuning.html
            String fileName = "index.html";
            try (FileReader reader = new FileReader(fileName);
                 BufferedReader bufferedReader = new BufferedReader((reader))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    builder.append(line);
                }
            }
            String rawHtmlString = builder.toString();

            //Removed and replaced with optimization up above ^
            //Files.lines(Paths.get("index.html"), StandardCharsets.UTF_8).forEach((val)-> builder.append(val)); //lambda go brrr
            //String rawHtmlString = builder.toString();

            DataHouse YeahBoi = new DataHouse(rawHtmlString);
            /*
            System.out.println("tagScores");
            for(Map.Entry<String,Integer> map:YeahBoi.getTagScores().entrySet()){
                System.out.println("Key: "+map.getKey()+"|Value: "+map.getValue());
            }
            System.out.println("UnWords");
            for(Map.Entry<String,Integer> map:YeahBoi.getUnWordScores().entrySet()){
                System.out.println("Key: "+map.getKey()+"|Value: "+map.getValue());
            }
            //rawHtmlString = rawHtmlString.replaceAll("\\<.*?\\>", "");
            //System.out.print(rawHtmlString);


            //Performance Benchmark
*/          final long endTime = System.currentTimeMillis();;
            System.out.println(endTime - startTime);

        } catch(Exception e) {
            System.out.print(e);
        }
        //
        //str.replaceAll("\\<.*?\\>", "")
    }


}

/*
URL url = new URL( "http://download.me/" );
Files.copy( url.openStream(), Paths.get("downloaded.html" ) );
from: https://stackoverflow.com/questions/238547/how-do-you-programmatically-download-a-webpage-in-java
 */