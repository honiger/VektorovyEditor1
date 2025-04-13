package cz.uhk.veditor.grobjekty;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Group extends AbstractGeomObject {

    private List <AbstractGeomObject> objects = new ArrayList<>();

    public Group(Point position, Color color) {
        super(position, color);
    }

    public void addObject(AbstractGeomObject object) {
        objects.add(object);
    }

    public void removeObject(AbstractGeomObject object) {
        objects.remove(object.toString());
    }

    public List <AbstractGeomObject> getObjects(){
        return objects;
    }


    @Override
    public boolean contains(int x, int y) {
        for (AbstractGeomObject object : objects) {
            if (object.contains(x, y)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void draw(Graphics g) {
        for (AbstractGeomObject object : objects) {
            object.draw(g);
        }
    }
}
