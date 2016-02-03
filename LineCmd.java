import java.awt.*;

/**
 * LineCmd.java
 * Command class to perform a LineCmd
 * Written by Alec Cobban and Azhar Hussain for CS10 Lab Assignment 3
 *
 * @author Alec Cobban
 * @author Azhar Hussain
 * @see Command
 */

public class LineCmd extends Command {
    private Color myColor;
    private Segment thisLine;

    /**
     * The constructor for the LineCmd
     *
     * @param c takes as input parameter c a Color that the line will be drawn in
     */
    public LineCmd(Color c) {

        this.myColor = c;
    }

    /**
     * executePress
     * When the mouse is pressed make a new segment and start drawing it with start and end points
     * equal to the first point pressed
     *
     * @param p   the coordinates of the click
     * @param dwg the drawing being clicked
     */
    public void executePress(Point p, Drawing dwg) {
        thisLine = new Segment(this.myColor);
        thisLine.setStart(p);
        thisLine.setEnd(p);
        dwg.addShape(thisLine);
    }

    /**
     * executeDrag
     * When the mouse is dragged reset the endpoint of the line so that it constantly draws as dragged
     *
     * @param p   the corrdinates of the click
     * @param dwg the drawing being clicked
     */
    public void executeDrag(Point p, Drawing dwg) {

        thisLine.setEnd(p);
    }
}
