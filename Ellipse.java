import java.awt.*;

/**
 * Ellipse.java
 * Class for an ellipse.
 * <p>
 * Edited by Azhar Hussain and Alec Cobban for CS 10 Lab 3
 *
 * @author Thomas H. Cormen
 * @author Azhar Hussain and Alec Cobban
 * @see Shape
 */
public class Ellipse extends Shape {
    private int left; // minimum x value for corner coordinates
    private int height; // height of Ellipse
    private int top;  // minimum y value for corder coordinates
    private int width;  // width of Ellipse
    private int trueStartX;  // minimum x value for start of ellipse drawing from top left corner
    private int trueStartY;  // minimum y value for start of ellipse drawing from top left corner
    private Point startPoint; // point that contains trueStartX and trueStartY
    private Point endPoint;  // end point of user dragging for ellipse
    private final double HALF_DISTANCE = .5; // half the distance of shape width or height

    /**
     * Ellipse
     * Constructor method for Ellipse which creates a new shape
     *
     * @param c is the color of the shape as passed in from editor
     */
    public Ellipse(Color c) {
        super(c);
    }

    /**
     * drawShape
     * method to draw the Ellipse on the canvas using the trueStartX and Y, which
     * are the top left most x and y coordinates, and width and height which are the
     * difference between the user's mouse and start point
     *
     * @param page takes the graphics page which the shape will be drawn on
     */
    public void drawShape(Graphics page) {
        width = Math.abs(((int) (endPoint.getX() - startPoint.getX())));
        height = Math.abs(((int) (endPoint.getY() - startPoint.getY())));
        trueStartX = (int) Math.min(startPoint.getX(), endPoint.getX());
        trueStartY = (int) Math.min(startPoint.getY(), endPoint.getY());
        page.fillOval(trueStartX, trueStartY, width, height);
        left = trueStartX;
        top = trueStartY;

    }

    /**
     * containsPoint
     * Helper method that returns whether Point p is in an Ellipse with the given
     * top left corner and size.
     * Function provided by Professor
     *
     * @param p      is the point user clicks on the page
     * @param left   is the minimum x value of the ellipse
     * @param top    is the minimum y value of the ellipse
     * @param width  is the difference between two x coordinates
     * @param height is the difference between two y coordinates
     * @return boolean value of is point is within shape or not
     */
    private static boolean containsPoint(Point p, int left, int top, int width,
                                         int height) {
        double a = width / 2.0; // half of the width
        double b = height / 2.0; // half of the height
        double centerx = left + a; // x-coord of the center
        double centery = top + b; // y-coord of the center
        double x = p.x - centerx; // horizontal distance between p and center
        double y = p.y - centery; // vertical distance between p and center

        // Now we just apply the standard geometry formula.
        // (See CRC, 29th edition, p. 178.)
        return Math.pow(x / a, 2) + Math.pow(y / b, 2) <= 1;
    }

    /**
     * setStart
     * Method to set the start point of the ellipse
     *
     * @param p is a point on the graphics page from user interaction
     */
    public void setStart(Point p) {
        startPoint = p;
    }

    /**
     * setEnd
     * Method to set the end point of the ellipse
     *
     * @param p is a point on the graphics page from user interaction
     */
    public void setEnd(Point p) {
        endPoint = p;
    }

    /**
     * move
     * Move method abstracted from Shape Class
     * This method is not used in our implemenation
     */
    @Override
    public void move(int deltaX, int deltaY) {
    }

    /**
     * getCenter
     * Method that returns the center point of the ellipse
     * by taking top left coordinates and adding half of
     * the height to Y and half the width to X
     *
     * @return Point that is in the center of the shape
     */
    public Point getCenter() {
        Point centerPoint;

        // X and Y found by adding half of width and height
        int centerX = (int) (trueStartX + (HALF_DISTANCE * width));
        int centerY = (int) (trueStartY + (HALF_DISTANCE * height));

        // new Center Point is equal to new values
        centerPoint = new Point(centerX, centerY);

        return centerPoint;
    }

    /**
     * setCenter
     * Method that sets the center of the shape by taking a
     * Point and working backwords by subtracting half of the
     * width of X and half of the height for Y to find
     * the topleft most coordinates and setting the
     * startX and Y points to these values so that the shape is now
     * drawn with the given center point. End points are found by adding half of the
     * width and height to center point.
     *
     * @param p is the point being passed in to set the shape's center equal to
     */
    public void setCenter(Point p) {

        // find starting points by subtracting half of width and height
        int startX = (int) (p.getX() - (HALF_DISTANCE * width));
        int startY = (int) (p.getY() - (HALF_DISTANCE * height));

        // find ending points by adding half of width and height
        int endX = (int) (p.getX() + (HALF_DISTANCE * width));
        int endY = (int) (p.getY() + (HALF_DISTANCE * height));

        // create new ending and starting points
        Point newEndPoint;
        newEndPoint = new Point(endX, endY);
        Point newStartPoint;
        newStartPoint = new Point(startX, startY);

        // set start point and end point to new points
        setStart(newStartPoint);
        setEnd(newEndPoint);
    }

    /**
     * containsPoint
     * Override method accept only Point value and call local method that required
     * more parameters to find if a point is contained within a shape
     *
     * @param p is the point the user clicks on in the image
     * @return boolean of if user click point p is within shape
     */
    @Override
    public boolean containsPoint(Point p) {
        return this.containsPoint(p, this.left, this.top, this.width, this.height);
    }
}