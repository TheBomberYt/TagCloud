package dev.jaxi;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class TagCloud() {
    public TagCloud(TreeMap<String, Integer> test) {


        TagCloudCanvas canvas = new TagCloudCanvas();
        TagCloudJFrame jframe = new TagCloudJFrame();
    }
}


public class TagCloudCanvas extends Canvas {
   private
    public TagCloud(){

    }

}

public class TagCloudJFrame extends JFrame{
    public static final int WIDTH=1920;
    public static final int HEIGHT=1080;

    public void TagCloudRunner(){
        setSize(WIDTH,HEIGHT);
        getContentPane().add( new TagCloud() );
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
