package dev.jaxi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;


public class WebScraper {

    public static void main(String[] args) {

        final long startTime = System.currentTimeMillis();;

        try {
            URL url = new URL("https://www.cfisd.net");
            File httpDoc = new File("index.html");
            if(httpDoc.exists()) httpDoc.delete();

            String.valueOf(Files.copy(url.openStream(), Paths.get("index.html")));
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

            DataHouse YeahBoi = new DataHouse(rawHtmlString);

            final long endTime = System.currentTimeMillis();;
            System.out.println(endTime - startTime);

        } catch(Exception e) {
            System.out.print(e);
        }

    }

}

/*
URL url = new URL( "http://download.me/" );
Files.copy( url.openStream(), Paths.get("downloaded.html" ) );
from: https://stackoverflow.com/questions/238547/how-do-you-programmatically-download-a-webpage-in-java
 */