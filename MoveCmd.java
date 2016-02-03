import java.awt.*;

/**
 * MoveCmd.java
 * Command class to perform a Move command
 * Written by Alec Cobban and Azhar Hussain for CS10 Lab Assignment 3
 *
 * @author Alec Cobban
 * @author Azhar Hussain
 * @see Command
 */
public class MoveCmd extends Command {
    private Shape moveShape;
    private Point initialClick;
    private Point dragPoint;

    /**
     * executePress
     * finds the first shape under the point clicked and sets it as the shape to be moved
     *
     * @param p   the coordinates of the point being clicked
     * @param dwg the drawing being clicked
     */
    public void executePress(Point p, Drawing dwg) {
        moveShape = dwg.getFrontmostContainer(p);
        initialClick = p;
    }

    /**
     * executeDrag
     * When the mouse is dragged use the set center command of a given shape type to
     * move the object a displacement value based on how far the mouse has moved
     *
     * @param p   the coordinates of the point being clicked
     * @param dwg the drawing being clicked
     */
    public void executeDrag(Point p, Drawing dwg) {
        if (moveShape != null) {
            dragPoint = p;
            int displaceX = (int) (dragPoint.getX() - initialClick.getX());
            int displaceY = (int) (dragPoint.getY() - initialClick.getY());
            dragPoint = new Point((int) (moveShape.getCenter().getX() + displaceX), (int) (moveShape.getCenter().getY() + displaceY));
            moveShape.setCenter(dragPoint);
            initialClick = p;
        }
    }
}
