import javax.swing.*;
import java.awt.*;

public class Display {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JustGame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(1000,1000);
        Arcanoid arcanoid = new Arcanoid(600,500, frame);
        arcanoid.setSize(300,200);
        frame.add(arcanoid, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
