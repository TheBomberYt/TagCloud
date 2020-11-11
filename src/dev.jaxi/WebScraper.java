package dev.jaxi;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WebScraper {

    public static void main(String[] args) {

        System.out.println("testing");
        try {
            URL url = new URL("https://jaxi.dev");
            Files.copy(url.openStream(), Paths.get("index.html"));
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