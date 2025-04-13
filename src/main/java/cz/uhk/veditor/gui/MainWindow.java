package cz.uhk.veditor.gui;

import cz.uhk.veditor.grobjekty.*;
import cz.uhk.veditor.grobjekty.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

public class MainWindow extends JFrame {
    private List<AbstractGeomObject> objekty = new ArrayList<>();

    private JToolBar toolbar;
    private JToggleButton btSquare;
    private JToggleButton btCircle;
    private JToggleButton btRectangle;
    private JToggleButton btTriangle;
    private JToggleButton btSelect;
    private AbstractGeomObject selectedObject = null;
    private boolean isMovingObject = false;
    private Point offset = null;




    public MainWindow() {
        super("Vektorový Editor");

         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         createToolbar();

        GraphPanel panel = new GraphPanel(objekty);

        add(panel, BorderLayout.CENTER);
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1){
                    if(btRectangle.isSelected()){
                        objekty.add(
                                new Rectangle(new Point(e.getX()-50, e.getY()-25),
                                        100, 50,Color.BLACK));
                        panel.repaint();}
                    else if(btSquare.isSelected()){
                        objekty.add(
                                new Square(new Point(e.getX()-50, e.getY()-50),
                                        100,Color.BLACK));
                        panel.repaint();}
                    else if(btCircle.isSelected()){
                        objekty.add(
                                new Circle(new Point(e.getX()-50, e.getY()-50),
                                        50,Color.BLACK));
                        panel.repaint();}
                    else if(btTriangle.isSelected()){
                        objekty.add(
                                new Triangle(new Point(e.getX()-50, e.getY()-50),
                                        100,100,Color.BLACK));
                        panel.repaint();}
                    else if(btSelect.isSelected()){
                        if (!isMovingObject) {
                            for (AbstractGeomObject obj : objekty) {
                                if (obj.contains(e.getX(), e.getY())) {
                                    selectedObject = obj;
                                    offset = new Point(e.getX() - obj.getPosition().x, e.getY() - obj.getPosition().y);
                                    isMovingObject = true;
                                    break;
                                }
                            }
                        } else {
                            isMovingObject = false;
                            selectedObject = null;
                            offset = null;
                        }
                    }
                }
            }

        });

        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if (isMovingObject && selectedObject != null && offset != null) {
                    int newX = e.getX() - offset.x;
                    int newY = e.getY() - offset.y;
                    selectedObject.setPosition(new Point(newX, newY));
                    panel.repaint();
                }
            }
        });



        setSize(800, 600);
        setLocationRelativeTo(null);

    }
    private void createToolbar(){
        toolbar = new JToolBar(JToolBar.HORIZONTAL);
        add(toolbar, BorderLayout.NORTH);
        btSquare = new JToggleButton("", new ImageIcon(getClass().getResource("/icons/ctverec.png")));
        btCircle = new JToggleButton("",new ImageIcon(getClass().getResource("/icons/kruh.png")));
        btRectangle = new JToggleButton("", new ImageIcon(getClass().getResource("/icons/obdelnik.png")));
        btTriangle = new JToggleButton("", new ImageIcon(getClass().getResource("/icons/trojuhelnik.png")));
        btSelect = new JToggleButton("", new ImageIcon(getClass().getResource("/icons/vybrat.png")));
        toolbar.add(btSquare);
        toolbar.add(btCircle);
        toolbar.add(btRectangle);
        toolbar.add(btTriangle);
        toolbar.add(btSelect);
        ButtonGroup gr = new ButtonGroup();
        gr.add(btSquare);
        gr.add(btCircle);
        gr.add(btRectangle);
        gr.add(btTriangle);
        gr.add(btSelect);

    }



}
