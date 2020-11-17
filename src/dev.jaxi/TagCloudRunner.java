package dev.jaxi;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
public class TagCloudRunner extends JFrame{
    public static final int WIDTH=1920;
    public static final int HEIGHT=1080;

    public TagCloudRunner(){
    super("TagCloud: Ethan Allen & Jax Brachetti");
        setSize(WIDTH,HEIGHT);
        getContentPane().add( new TagCloud() );
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args){
        TagCloudRunner run=new TagCloudRunner();
    }
}

