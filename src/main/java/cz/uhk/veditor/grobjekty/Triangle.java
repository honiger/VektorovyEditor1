package cz.uhk.veditor.grobjekty;


import java.awt.*;

public class Triangle extends AbstractGeomObject {
    protected int a;
    protected int v;

    public Triangle(Point position,int a, int v, Color color) {
        super(position, color);
        this.a = a;
        this.v = v;
    }

    public Triangle(int a) {
        this.a = a;
        this.v = v;
    }


    @Override
    public boolean contains(int x, int y) {
        return x >= position.x && x <= position.x + a
                && y >= position.y && y <= position.y + v;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawPolygon(new int[] {position.x, a, (v*a)/2}, new int[] {position.y, (v*a)/2, a}, 3);

    }
}