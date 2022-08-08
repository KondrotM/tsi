import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Application {

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the ubiquitous "Hello World" label.
//        JLabel label = new JLabel("Hello World");
        JButton btn = new JButton("*");

        Vector board = new Vector();

        for (int r = 0; r < 10; r++) {
            Vector row = new Vector();
            for (int c = 0; c < 10; c++) {
                Tile t = new Tile(r,c);
                row.add(t);
//                frame.getContentPane().add(t);
            }
            board.add(row);
        }


//        frame.getContentPane().add(btn);

        frame.setLayout(new GridLayout(10,10));

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
