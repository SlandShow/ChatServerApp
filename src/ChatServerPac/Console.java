package ChatServerPac;

import java.awt.Dimension;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Console {

    static final JFrame frame = new JFrame();
    static final JPanel panel = new JPanel();

    static final int WIDTH = 640;
    static final int HEIGHT = 900;

    public static final JTextArea textarea = new JTextArea();
    public static final JScrollPane scrole = new JScrollPane(textarea);

    public Console(){

        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        scrole.setPreferredSize(new Dimension(WIDTH - 32 , HEIGHT - 16));

        textarea.setEditable(false); //не могу писать на текстареи

        panel.add(scrole);

        frame.add(panel);

    }


    public void wtiteToConsole(String text){

        textarea.append(text + "\n");


    }



}
