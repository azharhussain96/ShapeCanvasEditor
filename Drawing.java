import java.awt.*;
import java.util.ArrayList;

/**
 * DeleteCmd.java
 * Removes the frontmost shape (found by delete function)
 *
 * @author Azhar Hussain and Alec Cobban
 */

public class Drawing {
    private ArrayList<Shape> shapeList;

    /**
     * Drawing
     * Constructor for new drawing
     * Creates an ArrayList to hold all shapes
     */
    public Drawing() {
        shapeList = new ArrayList<Shape>();
    }

    /**
     * draw
     * draw command draws all shapes starting at end
     * of list, moving to the front to layer shapes
     * in correct order
     *
     * @param page is the Graphics page user will be drawing on
     */
    public void draw(Graphics page) {

        for (int i = shapeList.size() - 1; i >= 0; i--) {
            shapeList.get(i).draw(page);
        }
    }

    /**
     * getFrontmostContainer
     * method to return the frontmost shape at a
     * click point in the window
     *
     * @param p is the point which user clicks
     * @return frontmost Shape object
     */
    public Shape getFrontmostContainer(Point p) {

        // start at front of list to get top shape at point
        for (int i = 0; i <= shapeList.size() - 1; i++) {

            // if point lays within given shape
            if (shapeList.get(i).containsPoint(p)) {
                return shapeList.get(i);
            }
        }
        return null;
    }

    /**
     * delete
     * method to delete the frontmost shape
     * starts at front of list, finds contained shape
     * and removes from ArrayList
     *
     * @param p is the point user clicks
     */
    public void delete(Point p) {

        // start at front of ArrayList
        for (int i = 0; i <= shapeList.size() - 1; i++) {

            if (shapeList.get(i).containsPoint(p)) {
                shapeList.remove(i);
                break; // break once you find the topmost shape
            }
        }
    }

    /**
     * addShape
     * method to add a new shape to drawing
     * by adding to the ArrayList containing shapes
     *
     * @param s is the shape user wants to draw
     */
    public void addShape(Shape s) {
        final int FRONT_INDEX = 0;  // front index of the list since index 0 is top layer

        // add shape to ArrayList at the frontmost index
        shapeList.add(FRONT_INDEX, s);
    }

    /**
     * getArrayList
     * getter method to return the ArrayList for other methods to
     * make adding and removing form list easier
     *
     * @return ArrayList of shapes currently drawn
     */
    public ArrayList<Shape> getArrayList() {

        return shapeList;
    }
}
