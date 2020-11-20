package dev.jaxi;


import javax.swing.*;

import java.awt.Color;
import java.awt.*;
import java.util.TreeMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;



public class TagCloud {

    public static TreeMap<String,Integer> wordMap = new TreeMap<String, Integer>();
    public static ArrayList<Word>words=new ArrayList<Word>();
    public TagCloud(TreeMap<String,Integer> wordMapParam) {

        wordMap = wordMapParam;

        new TagCloud();

    }

    public TagCloud() {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch(Exception e) {
                    System.out.println(e);
                }

                JFrame frame = new JFrame("TagCloud - Ethan Allen & Jax Brachetti");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                TagCloudPane jeff=new TagCloudPane();
                jeff.makeList();
                jeff.placeWords();
                frame.add(jeff);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            }
        });
    }

}

class TagCloudPane extends JPanel {

    public static Color[] color = new Color[6];
    public static ArrayList<Word> words = new ArrayList<Word>();
    public static int width=1920,height=1080;
    public static Dimension dim=new Dimension(width,height);
    TreeMap<String, Integer> wordMap = TagCloud.wordMap;

    public int Size() {
        int size = 0;
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            size += entry.getValue();
        }
        return size;
    }

    public int Average() {
        return Size() / wordMap.size();
    }

    public int Mean() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list);
        return list.get(list.size() / 2);
    }

    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    public int makeSize(int g) {

        return 10 * g / Average();
    }

    public void makeList() {
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            words.add(new Word(new Font("Courier", Font.PLAIN, makeSize(entry.getValue())), entry.getKey(), entry.getValue()));
        }
        for (int x = words.size() - 1; x > -1; x--) {
            if (words.get(x).str.length() < 3 || words.get(x).str.equals("getelementsbytagname") || words.get(x).size < Average()) {
                words.remove(x);
            }
        }
        Word temp;
        for (int x = 0; x < words.size(); x++) {
            for (int y = 1; y < words.size(); y++) {
                if (words.get(y - 1).compareTo(words.get(y)) < 0) {
                    temp = words.get(y - 1);
                    words.set(y - 1, words.get(y));
                    words.set(y, temp);
                }
            }
        }
        for (int x = words.size() - 1; x > 32; x--) {
            words.remove(x);
        }

        for (int x = 0; x < words.size(); x++) {
            words.get(x).rect.setLocation(getPreferredSize().width / 2 - words.get(x).rect.width / 2, getPreferredSize().height / 2 - words.get(x).rect.width / 2);
        }
        System.out.println("" + (getPreferredSize().width / 2 - words.get(0).rect.width / 2) + "   " + (getPreferredSize().height / 2 - words.get(0).rect.width / 2));
        for (int x = 0; x < words.size(); x++) {
            System.out.println("" + words.get(x).str + "|Score:" + words.get(x).size);
        }
        System.out.print("Average:" + Average() + "|Size:" + Size() + "|Mean:" + Mean());

    }

    public void placeWords() {
        for (int x = 1; x < words.size(); x++) {
            int y=0;
            while(words.get(x).intersects(words,x)){
                words.get(x).rect.setLocation(Polar.fromPolar(y,y));
                y++;
            }
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        color[0] = Color.RED;
        color[1] = Color.ORANGE;
        color[2] = Color.YELLOW;
        color[3] = Color.GREEN;
        color[4] = Color.BLUE;
        color[5] = Color.MAGENTA;
        g.setColor(Color.GREEN);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getPreferredSize().width, getPreferredSize().height);

        for (Word x : words) {
            x.paint(g);


        }


    }
}
class Word{
    public Font font;
    public String str;
    public FontMetrics metric;
    public Rectangle rect;
    public int size;
    public Color[] color=new Color[6];
    public Word(String s,Font f,int si){
        str=s;
        font=f;
        metric=new TagCloudPane().getFontMetrics(font);
        size=si;
        rect=new Rectangle(0,0,metric.charsWidth(str.toCharArray(),0,str.length()),metric.getHeight());
        color[0]=Color.RED;
        color[1]=Color.ORANGE;
        color[2]=Color.YELLOW;
        color[3]=Color.GREEN;
        color[4]=Color.BLUE;
        color[5]=Color.MAGENTA;
    }
    public Word(Font f,String s,int si){
        str=s;
        font=f;
        metric=new TagCloudPane().getFontMetrics(font);
        size=si;
        rect=new Rectangle(0,0,metric.charsWidth(str.toCharArray(),0,str.length()),metric.getHeight());
        color[0]=Color.RED;
        color[1]=Color.ORANGE;
        color[2]=Color.YELLOW;
        color[3]=Color.GREEN;
        color[4]=Color.BLUE;
        color[5]=Color.MAGENTA;
    }
    public int compareTo(Word g){
        return this.size-g.size;
    }
    public boolean intersects(Word w){
        if(w.rect.intersects(this.rect)){
            return true;
        }return false;
    }


    public boolean intersects(ArrayList<Word> w,int spot){
        for(int x=0;x<spot;x++) {
            if (rect.intersects(w.get(x).rect)) {
                return true;
            }
        }
        return false;
    }
    public void paint(Graphics window){
        window.setColor(color[(int)(Math.random()*6)]);
        window.setFont(font);
       // window.drawString("CFISD",this.rect.x,this.rect.y+metric.getHeight()-metric.getDescent());
        window.drawString(str,this.rect.x,this.rect.y+metric.getHeight()-metric.getDescent());
      //  window.drawRect(rect.x,rect.y,rect.width,rect.height+ metric.getDescent());
    }

}
class Polar {
    public static Point fromPolar(double magnitude, double angle) {
        return new Point((int)(magnitude * Math.cos(angle))+TagCloudPane.dim.width/2,
                (int)(magnitude * Math.sin(angle))+TagCloudPane.dim.height/2);
    }
}

