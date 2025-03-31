package cz.uhk.veditor.gui;

import cz.uhk.veditor.grobjekty.AbstractGeomObject;
import cz.uhk.veditor.grobjekty.Circle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainWindow extends JFrame {
    private List<AbstractGeomObject> objekty = new ArrayList<>();


    public MainWindow() {
        super("Vektorový Editor");

         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         initTestData();
         add(new GraphPanel(objekty), BorderLayout.CENTER);
         setSize(800, 600);
         setLocationRelativeTo(null);

    }
    private void initTestData() {
        objekty.add(new Circle(new Point(500, 100), 50, Color.RED));
        objekty.add(new Circle(new Point(500, 400), 50, Color.BLUE));
        objekty.add(new Circle(new Point(600, 300), 50, Color.BLACK));
    }
}
