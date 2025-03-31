package cz.uhk.veditor.grobjekty;

import java.awt.*;

public abstract class AbstractGeomObject {
    protected Point position;
    protected Color color;


    public void setColor(Color color) {
        this.color = color;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Point getPosition() {
        return position;
    }

    public Color getColor() {
        return color;
    }

    public AbstractGeomObject(Point position, Color color) {
        this.position = position;
        this.color = color;
    }

    public AbstractGeomObject() {
        position = new Point(0, 0);
        color = Color.BLACK;
    }

    public abstract boolean contains(int x, int y);

    public abstract void draw(Graphics g);
}
