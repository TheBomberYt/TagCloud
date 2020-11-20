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
                jeff.placeWords(.01);
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
    public static int width=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),height=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    public static Dimension dim=new Dimension(width,height);
    public TreeMap<String, Integer> wordMap = TagCloud.wordMap;


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
            return (int) (Math.sqrt((((getPreferredSize().height*getPreferredSize().height)+(getPreferredSize().width*getPreferredSize().width)))))/(getPreferredSize().height/6)*g/Average();

    }

    public void makeList() {
        color[0]=Color.RED;
        color[1]=Color.ORANGE;
        color[2]=Color.YELLOW;
        color[3]=Color.GREEN;
        color[4]=Color.BLUE;
        color[5]=Color.MAGENTA;
        String jeff="#GungSeo\n" + "#HeadLineA\n" + "#PCMyungjo\n" + "#PilGi\n" + "Abadi MT Condensed Extra Bold\n" + "Abadi MT Condensed Light\n" + "Academy Engraved LET\n" + "Al Bayan\n" +"American Typewriter\n" + "Andale Mono\n" + "Apple Casual\n" + "Apple Chancery\n" + "Apple LiGothic\n" + "Apple LiSung\n" + "Apple Symbols\n" + "AppleGothic\n" + "AppleMyungjo\n" + "Arial\n" + "Arial Black\n" + "Arial Hebrew\n" + "Arial Narrow\n" + "Arial Rounded MT Bold\n" + "Ayuthaya\n" + "Baghdad\n" + "Bank Gothic\n" + "Baskerville\n" + "Baskerville Old Face\n" + "Batang\n" + "Bauhaus 93\n" + "Bell MT\n" + "Bernard MT Condensed\n" + "BiauKai\n" + "Big Caslon\n" + "Bitstream Vera Sans\n" + "Bitstream Vera Sans Mono\n" + "Bitstream Vera Serif\n" + "Blackmoor LET\n" + "BlairMdITC TT\n" + "Bodoni Ornaments ITC TT\n" + "Bodoni SvtyTwo ITC TT\n" + "Bodoni SvtyTwo OS ITC TT\n" + "Bodoni SvtyTwo SC ITC TT\n" + "Book Antiqua\n" + "Bookman Old Style\n" + "Bordeaux Roman Bold LET\n" + "Bradley Hand ITC TT\n" + "Braggadocio\n" + "Britannic Bold\n" + "Brush Script MT\n" + "Calisto MT\n" + "Century\n" + "Century Gothic\n" + "Century Schoolbook\n" + "Chalkboard\n" + "Charcoal CY\n" + "Cochin\n" + "Colonna MT\n" + "Comic Sans MS\n" + "Cooper Black\n" + "Copperplate\n" + "Copperplate Gothic Bold\n" + "Copperplate Gothic Light\n" + "Corsiva Hebrew\n" + "Courier\n" + "Courier New\n" + "Cracked\n" + "Curlz MT\n" + "DecoType Naskh\n" + "Desdemona\n" + "Devanagari MT\n" + "Dialog\n" + "DialogInput\n" + "Didot\n" + "Edwardian Script ITC\n" + "Engravers MT\n" + "Euphemia UCAS\n" + "Eurostile\n" + "Footlight MT Light\n" + "Futura\n" + "Garamond\n" + "GB18030 Bitmap\n" + "Geeza Pro\n" + "Geneva\n" + "Geneva CY\n" + "Georgia\n" + "Gill Sans\n" + "Gill Sans Ultra Bold\n" + "Gloucester MT Extra Condensed\n" + "Goudy Old Style\n" + "Gujarati MT\n" + "Gulim\n" + "Gurmukhi MT\n" + "Haettenschweiler\n" + "Handwriting - Dakota\n" + "Harrington\n" + "Hei\n" + "Helvetica\n" + "Helvetica CY\n" + "Helvetica Neue\n" + "Herculanum\n" + "Hiragino Kaku Gothic Pro\n" + "Hiragino Kaku Gothic Std\n" + "Hiragino Maru Gothic Pro\n" + "Hiragino Mincho Pro\n" + "Hoefler Text\n" + "Impact\n" + "Imprint MT Shadow\n" + "InaiMathi\n" + "Jazz LET\n" + "Kai\n" + "Kino MT\n" + "Krungthep\n" + "KufiStandardGK\n" + "LiHei Pro\n" + "LiSong Pro\n" + "Lucida Blackletter\n" + "Lucida Bright\n" + "Lucida Calligraphy\n" + "Lucida Fax\n" + "Lucida Grande\n" + "Lucida Handwriting\n" + "Lucida Sans\n" + "Lucida Sans Typewriter\n" + "Marker Felt\n" + "Matura MT Script Capitals\n" + "Mistral\n" + "Modern No. 20\n" + "Mona Lisa Solid ITC TT\n" + "Monaco\n" + "Monospaced\n" + "Monotype Corsiva\n" + "Monotype Sorts\n" + "MS Gothic\n" + "MS Mincho\n" + "MS PGothic\n" + "MS PMincho\n" + "Mshtakan\n" + "MT Extra\n" + "Nadeem\n" + "New Peninim MT\n" + "News Gothic MT\n" + "Onyx\n" + "OpenSymbol\n" + "Optima\n" + "Osaka\n" + "Palatino\n" + "Papyrus\n" + "Party LET\n" + "Perpetua Titling MT\n" + "Plantagenet Cherokee\n" + "Playbill\n" + "PMingLiU\n" + "PortagoITC TT\n" + "Princetown LET\n" + "Raanana\n" + "Rockwell\n" + "Rockwell Extra Bold\n" + "SansSerif\n" + "Santa Fe LET\n" + "Sathu\n" + "Savoye LET\n" + "SchoolHouse Cursive B\n" + "SchoolHouse Printed A\n" + "Serif\n" + "Silom\n" + "SimSun\n" + "Skia\n" + "Snell Roundhand\n" + "Stencil\n" + "STFangsong\n" + "STHeiti\n" + "STKaiti\n" + "Stone Sans ITC TT\n" + "Stone Sans Sem ITC TT\n" + "STSong\n" + "Symbol\n" + "Synchro LET\n" + "Tahoma\n" + "Thonburi\n" + "Times\n" + "Times New Roman\n" + "Trebuchet MS\n" + "Type Embellishments One LET\n" + "Verdana\n" + "Webdings\n" + "Wide Latin\n" +"Zapf Dingbats\n" + "Zapfino";
        String[] fonts= jeff.split("\n");
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            words.add(new Word(new Font(fonts[(int)(Math.random()*fonts.length)], Font.PLAIN, makeSize(entry.getValue())), entry.getKey(), entry.getValue(),color[(int)(Math.random()*6)]));
        }
        for (int x = words.size() - 1; x > -1; x--) {
            if (words.get(x).str.length()<3||words.get(x).str.equals("getelementsbytagname")||words.get(x).str.equals("attr") ) {
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


        for (int x = 0; x < words.size(); x++) {
            words.get(x).rect.setLocation(getPreferredSize().width / 2 - words.get(x).rect.width / 2, getPreferredSize().height / 2 - words.get(x).rect.width / 2);
        }



    }

    public void placeWords(double g) {final long startTime = System.currentTimeMillis();
        for (int x = 1; x < words.size(); x++) {
            double y=0;
            while(words.get(x).intersects(words,x)){
                words.get(x).rect.setLocation(Polar.fromPolar(y,y));
                y+=g;
            }
        }final long endTime = System.currentTimeMillis();;
        System.out.println(endTime - startTime);
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
    public Color color;
    public Word(String s,Font f,int si,Color cl){
        str=s;
        font=f;
        metric=new TagCloudPane().getFontMetrics(font);
        size=si;
        rect=new Rectangle(0,0,metric.charsWidth(str.toCharArray(),0,str.length()),metric.getHeight());
        color=cl;
    }
    public Word(Font f,String s,int si,Color cl){
        color=cl;
        str=s;
        font=f;
        metric=new TagCloudPane().getFontMetrics(font);
        size=si;
        rect=new Rectangle(0,0,metric.charsWidth(str.toCharArray(),0,str.length()),metric.getHeight());

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
        window.setColor(color);
        window.setFont(font);
        window.drawString(str,this.rect.x,this.rect.y+metric.getHeight()-metric.getDescent());
        //window.drawRect(rect.x,rect.y,rect.width,rect.height+ metric.getDescent());
    }

}
class Polar {
    public static Point fromPolar(double magnitude, double angle) {
        return new Point((int)(magnitude * Math.cos(angle))+TagCloudPane.dim.width/2, (int)(magnitude * Math.sin(angle))+TagCloudPane.dim.height/2);
    }
}

