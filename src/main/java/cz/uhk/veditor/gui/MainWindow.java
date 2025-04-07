package cz.uhk.veditor.gui;

import cz.uhk.veditor.grobjekty.*;
import cz.uhk.veditor.grobjekty.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MainWindow extends JFrame {
    private List<AbstractGeomObject> objekty = new ArrayList<>();
    private JToolBar toolbar;
    private JToggleButton btSquare;
    private JToggleButton btCircle;


    public MainWindow() {
        super("Vektorový Editor");

         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         initTestData();

         createToolbar();

        GraphPanel panel = new GraphPanel(objekty);
        add(panel, BorderLayout.CENTER);
         panel.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e) {
                 if(e.getButton() == MouseEvent.BUTTON1){
                     if(btCircle.isSelected()){
                         objekty.add(
                                 new Circle(new Point(e.getX(), e.getY()),
                                         50,Color.RED))
                     ;}
                 }
             }
         });

        add(panel, BorderLayout.CENTER);
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1){
                    if(btSquare.isSelected()){
                        objekty.add(
                                new Square(new Point(e.getX(), e.getY()),
                                        50,Color.RED))
                        ;}
                }
            }
        });


         setSize(800, 600);
         setLocationRelativeTo(null);

    }
    private void createToolbar(){
        toolbar = new JToolBar(JToolBar.HORIZONTAL);
        add(toolbar, BorderLayout.NORTH);
        btSquare = new JToggleButton("Čtverec");
        btCircle = new JToggleButton("Kružnice");
        toolbar.add(btSquare);
        toolbar.add(btCircle);
        ButtonGroup gr = new ButtonGroup();
        gr.add(btSquare);
        gr.add(btCircle);

    }
    private void initTestData() {
        objekty.add(new Circle(new Point(500, 100), 50, Color.RED));
        objekty.add(new Circle(new Point(500, 400), 50, Color.BLUE));
        objekty.add(new Circle(new Point(600, 300), 50, Color.BLACK));
        objekty.add(new Rectangle(new Point(200, 300), 50,20, Color.BLACK));
        objekty.add(new Triangle(new Point(200, 300), 50,20, Color.BLACK));


    }
}
