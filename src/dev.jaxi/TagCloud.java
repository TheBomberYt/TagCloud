package dev.jaxi;

import javax.swing.*;
import java.awt.*;
import java.util.TreeMap;



public class TagCloud {

    public static TreeMap<String,Integer> wordMap = new TreeMap<String, Integer>();

    public TagCloud(TreeMap<String,Integer> wordMapParam) {

        wordMap = wordMapParam;

        new TagCloud();

    }

    private TagCloud() {

        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch(Exception e) {
                System.out.println(e);
            }

            JFrame frame = new JFrame("TagCloud - Ethan Allen & Jax Brachetti");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.add(new TagCloudPane());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        });
    }

}

class TagCloudPane extends JPanel {

    TreeMap<String, Integer> wordMap = TagCloud.wordMap;
    public Dimension getPreferredSize() {
        return new Dimension(1000, 600);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.BLACK);

        g.drawString(wordMap.firstEntry().getKey(), 100, 100);
    }

}
