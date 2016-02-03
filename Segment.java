import java.awt.*;

/**
 * Segment.java
 * Class for a line segment.
 * <p>
 * Written by THC for CS 5 Lab Assignment 3.
 *
 * @author Thomas H. Cormen
 * @author Alec Cobban
 * @author Azhar Hussain
 *         Edited by AC and AH for the CS 10 Lab assignment 3
 * @see Shape
 */
public class Segment extends Shape {
    private Point startPoint = new Point(); //the place the line starts
    private Point endPoint = new Point(); //the place the line ends
    private int top; //the top of the line-following are used primarily to get center
    private int bottom;// the bottom of the line
    private int left; //the leftmost point in the line
    private int right;//the rightmost point in the line
    private final int TOLERANCE = 3;

    public Segment(Color c) {
        super(c);
    }

    /**
     * drawShape
     * takes as input a page and uses the instance variables of the startPoint and endpoint
     * to draw a line
     * then sets other instance variables to appropriate values to allow for further commands on this object
     *
     * @param page is the page which will be drawn on
     */
    public void drawShape(Graphics page) {
        page.drawLine(((int) startPoint.getX()), ((int) startPoint.getY()), ((int) endPoint.getX()), ((int) endPoint.getY()));
        this.top = (int) Math.min(startPoint.getY(), endPoint.getY());
        this.bottom = (int) Math.max(startPoint.getY(), endPoint.getY());
        this.left = (int) Math.min(startPoint.getX(), endPoint.getX());
        this.right = (int) Math.max(startPoint.getX(), endPoint.getX());
    }


    // Helper method that returns true if Point p is within a tolerance of a
    // given bounding box. Here, the bounding box is given by the coordinates of
    // its left, top, right, and bottom.
    //This helper method was not necessary to the implementation as written, but remains in case useful
    private static boolean almostContainsPoint(Point p, int left, int top,
                                               int right, int bottom, double tolerance) {
        return p.x >= left - tolerance && p.y >= top - tolerance
                && p.x <= right + tolerance && p.y <= bottom + tolerance;
    }

    /**
     * distanceToPoint
     * Helper method that returns the distance from Point p to the line
     * containing a line segment whose endpoints are given.
     *
     * @param p the point user clicks
     * @param x1 x coordinate of the segment start point
     * @param x2 x coordinate of the segment end point
     * @param y1 y coordinate of the segment start point
     * @param y2 y coodinate of the segment end point
     *
     * @return double of the pixel distance from the shape which the user clicks
     */
    private static double distanceToPoint(Point p, int x1, int y1, int x2,
                                          int y2) {
        if (x1 == x2) // vertical segment?
            return (double) (Math.abs(p.x - x1)); // yes, use horizontal distance
        else if (y1 == y2) // horizontal segment?
            return (double) (Math.abs(p.y - y1)); // yes, use vertical distance
        else {
            // Here, we know that the segment is neither vertical nor
            // horizontal.
            // Compute m, the slope of the line containing the segment.
            double m = ((double) (y1 - y2)) / ((double) (x1 - x2));

            // Compute mperp, the slope of the line perpendicular to the
            // segment.
            double mperp = -1.0 / m;

            // Compute the (x, y) intersection of the line containing the
            // segment and the line that is perpendicular to the segment and that
            // contains Point p.
            double x = (((double) y1) - ((double) p.y) - (m * x1) + (mperp * p.x))
                    / (mperp - m);
            double y = m * (x - x1) + y1;

            // Return the distance between Point p and (x, y).
            return Math.sqrt(Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2));
        }
    }

    /**
     * setStart
     * make the start Point a new Point, this allows the startPoint to be selected outside
     * this class
     *
     * @param p the new Point to set startPoint to
     */
    public void setStart(Point p) {
        startPoint = p;
    }

    /**
     * setEnd
     *
     * @param p the new point to set endPoint to
     * @see setStart
     */
    public void setEnd(Point p) {
        endPoint = p;
    }

    /**
     * containsPoint
     * To determine if a line contains a point, see if the point is within a given tolerance of the line
     * this removes the necessity of extreme accuracy when selecting a line
     *
     * @param p the Point near the line that is clicked
     *
     * @return boolean of if the point where user clicks is contained in the shape
     */
    public boolean containsPoint(Point p) {


        return (distanceToPoint(p, (int) startPoint.getX(), (int) startPoint.getY(), (int) endPoint.getX(), (int) endPoint.getY()) <= TOLERANCE);
    }

    /**
     * move
     * Move is not used in this because the setCenter Command was better able to fill both commands without
     * need for the Move command as a helper. This is abstracted in from Shape
     *
     * @see Shape
     */
    public void move(int deltaX, int deltaY) {
    }

    /**
     * getCenter
     * returns the center of a segment by averaging the endpoints of the segment
     *
     * @return centerPoint the Point at the center of the segment
     */
    public Point getCenter() {
        int centerX = (left + right) / 2;
        int centerY = (top + bottom) / 2;
        Point centerPoint = new Point(centerX, centerY);
        return centerPoint;
    }

    /**
     * setCenter
     * This determines the displacement of the object based on a new given Center Point
     *
     * @param p the coordinates of the new center of the segment
     * @see MoveCmd
     * @see ExchangeCmd
     */
    public void setCenter(Point p) {
        Point initialCenter = getCenter();
        int displaceX = (int) (p.getX() - initialCenter.getX());
        int displaceY = (int) (p.getY() - initialCenter.getY());
        startPoint = new Point(((int) (startPoint.getX() + displaceX)), (int) (startPoint.getY() + displaceY));
        endPoint = new Point(((int) (endPoint.getX() + displaceX)), (int) (endPoint.getY() + displaceY));
    }
}
