import java.awt.*;

/**
 * ColorCmd.java
 * Sets the action of the Color buttons
 * New shapes drawn will be in this color
 * Clicking existing shapes will click color
 *
 * @author Azhar Hussain and Alec Cobban
 */
public class ColorCmd extends Command {
    private Color myColor;
    private Shape colorShape;

    public ColorCmd(Color c) {

        // myColor is set to the color picked by button in Editor.java
        myColor = c;
    }

    /**
     * executePress
     * When the mouse is clicked, find the topmost shape on that click point
     * and setColor to the selected color
     *
     * @param p   the coordinates of the click
     * @param dwg the drawing being clicked
     */
    public void executePress(Point p, Drawing dwg) {
        colorShape = dwg.getFrontmostContainer(p);
        if (colorShape != null) {
            colorShape.setColor(myColor);
        }
    }
}
