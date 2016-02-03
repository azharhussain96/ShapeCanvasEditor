import java.awt.*;

/**
 * *
 * RectCmd.java
 * Command class to perform RectCmd
 * Written by Alec Cobban and Azhar Hussain for CS10 Lab Assignment 3
 *
 * @author Alec Cobban
 * @author Azhar Hussain
 * @see Command
 */

public class RectCmd extends Command {
    private Color myColor;
    private Rectangle thisRectangle;

    /**
     * RectCmd
     * The constructor for RectCmd, sets the color to a given color
     *
     * @param c the color with which the rectangle should be drawn
     */
    public RectCmd(Color c) {
        this.myColor = c;
    }

    /**
     * executePress
     * When the mouse is pressed set the start point and endpoint of a new rectangle
     * to the point of the press
     * Then draw this new rectangle
     *
     * @param p   the coordinates of the point being pressed
     * @param dwg the Drawing in which the mouse is clicked
     */
    public void executePress(Point p, Drawing dwg) {
        thisRectangle = new Rectangle(this.myColor);
        thisRectangle.setStart(p);
        thisRectangle.setEnd(p); //make the dimensions of rectangle contain only this point to start
        dwg.addShape(thisRectangle);//add this shape to the drawing
    }

    /**
     * executeDrag
     * resets the endPoint based on the location of the mouse, allowing changing the size of the rectangle
     *
     * @param p the coordinates of the Point being pressed
     * @ param dwg the Drawing in which the mouse is clicked
     */
    public void executeDrag(Point p, Drawing dwg) {
        thisRectangle.setEnd(p); //reset the endpoint to change the size of the rectangle
    }
}

