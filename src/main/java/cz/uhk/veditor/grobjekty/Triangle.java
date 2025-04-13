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

    public Triangle(int a, int v) {
        this.a = a;
        this.v = v;
    }


    @Override
    public boolean contains(int x, int y) {
        int x1 = position.x + a / 2;
        int y1 = position.y;

        int x2 = position.x;
        int y2 = position.y + v;

        int x3 = position.x + a;
        int y3 = position.y + v;

        int d1 = (x - x2) * (y1 - y2) - (x1 - x2) * (y - y2);
        int d2 = (x - x3) * (y2 - y3) - (x2 - x3) * (y - y3);
        int d3 = (x - x1) * (y3 - y1) - (x3 - x1) * (y - y1);

        return (d1 > 0 && d2 > 0 && d3 > 0) || (d1 < 0 && d2 < 0 && d3 < 0);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawPolygon(new int[] {position.x + a/2, position.x, position.x + a},
                new int[] {position.y, position.y + v, position.y + v}, 3);

    }
}