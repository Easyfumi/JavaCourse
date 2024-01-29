package ru.marinin.geometry;

import javax.swing.*;
import java.awt.*;


public class VisionPolylines extends JFrame {
        protected static int x[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        protected static int y[] =  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        protected static int n = 5;

        public VisionPolylines (Polyline polyline) {
            super("График по точкам");
            initPoints(polyline);
            JPanel jcp = new JPanel(new BorderLayout());
            setContentPane(jcp);
            jcp.add(new DrawingComponent (), BorderLayout.CENTER);
            jcp.setBackground(Color.gray);
            setSize(800, 800);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }

        private void initPoints(Polyline polyline) {
            int size = polyline.getPoitns().size();
            n = size;
            System.out.println("size: " + n);
            for (int i=0; i<size; i++) {
                x[i]=polyline.getPoitns().get(i).x;
                y[i]=polyline.getPoitns().get(i).y;
            }
        }
    }

class DrawingComponent extends JPanel {
    private int xg[] = VisionPolylines.x;
    private int yg[] =  VisionPolylines.y;
    private int ng = VisionPolylines.n;

    @Override
    protected void paintComponent(Graphics gh) {
        Graphics2D drp = (Graphics2D)gh;
       drp.drawLine(400, 740, 400, 20);
       drp.drawLine(20, 400, 740, 400);
        for (int i=0; i<xg.length; i++) {
            xg[i] = xg[i] + 400;
        }
        for (int i=0; i<yg.length; i++) {
            yg[i] = -yg[i] + 400;
        }
      drp.drawPolyline(xg, yg, ng);
    }
}
