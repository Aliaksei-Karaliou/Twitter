package graphics;

import java.awt.*;
import javax.swing.*;

public class StatesWindow extends JFrame {

    static final String appTitle = "Frame-Application";

    public static void main(String[] args) {
        StatesWindow fr = new StatesWindow();
        fr.setBackground(Color.LIGHT_GRAY);
        fr.setSize(new Dimension(400, 400));
        fr.setTitle( appTitle );
        fr.setVisible(true);
        fr.repaint();
    }

    public void paint(Graphics g) {
        Dimension size = this.getSize();
        int[] xs = {
                (2 * size.width) / 3 };
        int[] ys = { (2 * size.height) / 3,
                size.height / 3, (2 * size.height) / 3 };
        Polygon triangle = new Polygon(xs, ys, xs.length );
        g.setColor( Color.red );
        g.fillPolygon(triangle);
    }


}