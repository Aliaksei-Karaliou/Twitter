package graphics;

import files.state.State;
import defaultPackage.Coordinate;

import java.awt.*;
import javax.swing.*;
import java.util.List;

public class StatesScreen extends JFrame {

    private List<State> list;
    public StatesScreen(List<State> list) {
        setBackground(Color.LIGHT_GRAY);
        setSize(new Dimension(640, 480));
        setTitle("Frame-Application");
        setVisible(true);
        this.list=list;
        repaint();
    }

    public void paint(Graphics g) {
        for (int i=0;i<list.size();i++){
            for (int j=0;j<list.get(i).getCoordinates().length-1;j++) {
                Coordinate coor1 = list.get(i).getCoordinates()[j];
                Coordinate coor2 = list.get(i).getCoordinates()[j+1];
                int x1 = ((int) coor1.getLatitude() + 126) * 10;
                int y1 = 640-(int) coor1.getLongitude() * 10;
                int x2 = ((int) coor2.getLatitude() + 126) * 10;
                int y2 = 640-(int) coor2.getLongitude() * 10;
                g.drawLine(x1, y1, x2, y2);
            }
            System.out.println(list.get(i).getName());

            g.setColor(new Color((int)Math.random()%255,(int)Math.random()%255,(int)Math.random()%255));
        }
    }


}