package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Created by korol on 24.05.16.
 */
class DrawLine extends JComponent {

    private int x1, x2, y1, y2;
    public DrawLine(int x1, int y1, int x2, int y2) {
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2=(Graphics2D)g;
        g2.draw(new Line2D.Double(x1, y1, x2, y2));
    }
}
