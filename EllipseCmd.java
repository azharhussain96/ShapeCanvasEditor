import java.awt.*;

/**
 * EllipseCmd.java
 * Class for controlling what happens once Ellipse button is pressed
 * Edited by Azhar Hussain and Alec Cobban for CS 10 Lab 3
 *
 * @author Azhar Hussain and Alec Cobban
 */

public class EllipseCmd extends Command {

    private Color myColor;  // color of the shape
    private Ellipse thisEllipse;  // new ellipse that is being drawn 

    /**
     * Constructor method for EllipseCmd which takes a color
     * for shape drawing
     *
     * @param c is the color of the shape as passed in from editor
     */
    public EllipseCmd(Color c) {

        myColor = c;
    }

    /**
     * executePress method is what happens once the user pressed the mouse point
     * A new ellipse is created, the start point and end point are both set to the
     * user click point on the canvas, and the shape is drawn
     *
     * @param p   is the user click point on the canvas
     * @param dwg is the drawing that the user is drawing on
     */
    public void executePress(Point p, Drawing dwg) {
        thisEllipse = new Ellipse(this.myColor);
        thisEllipse.setStart(p);
        thisEllipse.setEnd(p);
        dwg.addShape(thisEllipse);
    }

    /**
     * method for once the user drags the mouse. The ellipse is references and end
     * points are updated to the new user click point
     *
     * @param p   is the user click point on the canvas
     * @param dwg is the drawing that the user is drawing on
     */
    public void executeDrag(Point p, Drawing dwg) {

        thisEllipse.setEnd(p);
    }
}

