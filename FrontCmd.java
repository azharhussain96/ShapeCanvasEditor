import java.awt.*;

/**
 * FrontCmd.java
 * Command class to perform a front command
 * Written by Alec Cobban and Azhar Hussain for CS10 Lab Assignment 3
 *
 * @author Alec Cobban
 * @author Azhar Hussain
 * @see Command
 */

public class FrontCmd extends Command {
    private final int FRONT_INDEX = 0; //This is the first element of the list

    /**
     * When the mouse is clicked get the frontmost Shape in the drawing that contains
     * this mouse position, and if there is such a shape then
     * move this shape to the front of the drawing list, so that it is drawn on top
     *
     * @param p   the coordinates of the click
     * @param dwg the drawing being clicked
     */
    public void executeClick(Point p, Drawing dwg) {
        Shape front = dwg.getFrontmostContainer(p);
        if (front != null) {
            dwg.delete(p);
            dwg.getArrayList().add(FRONT_INDEX, front);
        }
    }
}
