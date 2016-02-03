import java.awt.Point;

/**
 * BackCmd.java
 * Class to set action for send to back button
 * Sends a shape to the back of the image
 *
 * @author Azhar Hussain and Alec Cobban
 */

public class BackCmd extends Command {


    /**
     * executeClick
     * When the mouse is clicked, find the topmost shape on that click point
     * delete that shape from its position in the list
     * re-add that shape to the end of the ArrayList containing shapes
     *
     * @param p   the coordinates of the click
     * @param dwg the drawing being clicked
     */
    public void executeClick(Point p, Drawing dwg) {
        Shape back = dwg.getFrontmostContainer(p);
        if (back != null) {
            dwg.delete(p);
            dwg.getArrayList().add(back);
        }
    }
}
