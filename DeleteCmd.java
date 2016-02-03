import java.awt.*;

/**
 * DeleteCmd.java
 * Removes the frontmost shape (found by delete function)
 *
 * @author Azhar Hussain and Alec Cobban
 */
public class DeleteCmd extends Command {

    /**
     * executePress
     * When mouse is clicked, delete the frontmost shape
     * in the drawing
     *
     * @param p   the coordinates of the click
     * @param dwg the drawing being clicked
     */
    public void executePress(Point p, Drawing dwg) {

        dwg.delete(p);
    }
}
