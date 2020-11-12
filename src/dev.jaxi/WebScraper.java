package dev.jaxi;

import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WebScraper {

    public static void main(String[] args) {


        try {
            URL url = new URL("https://jaxi.dev");
            File httpDoc = new File("index.html");
            if(httpDoc.exists()) httpDoc.delete();

            String.valueOf(Files.copy(url.openStream(), Paths.get("index.html")));
            FileReader httpDocString = new FileReader(httpDoc);
            final StringBuilder builder = new StringBuilder();

            Files.lines(Paths.get("index.html"), StandardCharsets.UTF_8).forEach((val)-> builder.append(val)); //lambda go brrr
            String rawHtmlString = builder.toString();

            //System.out.print(rawHtmlString);
            rawHtmlString = rawHtmlString.replaceAll("\\<.*?\\>", "");
            System.out.print(rawHtmlString);
        } catch(Exception e) {
            System.out.print(e);
        }

    //str.replaceAll("\\<.*?\\>", "")
    }


}

/*
URL url = new URL( "http://download.me/" );
Files.copy( url.openStream(), Paths.get("downloaded.html" ) );
from: https://stackoverflow.com/questions/238547/how-do-you-programmatically-download-a-webpage-in-java
 */