package graphics;

import files.state.State;
import defaultPackage.Coordinate;

import java.awt.*;
import javax.swing.*;
import java.util.List;
import java.util.Vector;

public class StatesScreen extends JFrame {

    private List<State> list;
    public StatesScreen(List<State> list) {
        setBackground(Color.LIGHT_GRAY);
        setSize(new Dimension(640, 480));
        setTitle("The USA map");
        setVisible(true);
        this.list=list;
        repaint();
    }

    public void paint(Graphics g) {
        for (int i=0;i<list.size();i++){
            List<Integer> X=new Vector();
            List<Integer> Y=new Vector();
            for (int j=0;j<list.get(i).getCoordinates().length;j++) {
                Coordinate coor1 = list.get(i).getCoordinates()[j];
                int x = ((int) coor1.getLatitude() + 126) * 10;
                int y = 540-(int) coor1.getLongitude() * 10;
                X.add(x);
                Y.add(y);
            }
            int[] Xarr=new int[X.size()];
            int[] Yarr=new int[Y.size()];
            for (int k=0;k<X.size();k++) {
                Xarr[k] = X.get(k);
                Yarr[k] = Y.get(k);
            }
            Polygon state=new Polygon(Xarr,Yarr, Xarr.length);
            g.setColor(new Color((int)(Math.random()*16777216)));
            g.fillPolygon(state);
        }
    }


}