import java.awt.*;

/**
 * *
 * Rectangle.java
 * Command class to draw and edit a Rectangle
 * Written by Alec Cobban and Azhar Hussain for CS10 Lab Assignment 3
 *
 * @author Alec Cobban
 * @author Azhar Hussain
 * @see Shape
 */
public class Rectangle extends Shape {
    private Point startPoint;
    private Point endPoint;
    private int width;
    private int height;
    private int trueStartX; //These values are used to determine which point is the top left
    private int trueStartY;
    private final double HALF_LENGTH = .5;

    /**
     * The constructor for Rectangle
     *
     * @param c takes color c and sets it as the color of the rectangle
     */
    public Rectangle(Color c) {
        super(c);
    }

    /**
     * drawShape
     * The method to draw the shape of type rectangle
     *
     * @param page the page on which the Rectangle is drawn
     */
    public void drawShape(Graphics page) {
        width = Math.abs(((int) (endPoint.getX() - startPoint.getX())));
        height = Math.abs(((int) (endPoint.getY() - startPoint.getY())));
        trueStartX = (int) Math.min(startPoint.getX(), endPoint.getX());
        trueStartY = (int) Math.min(startPoint.getY(), endPoint.getY());
        page.fillRect(trueStartX, trueStartY, width, height);
    }

    /**
     * setStart
     * takes a point and sets the startPoint to this new Point. useful for moving
     * an object
     *
     * @param p the Point to set the startPoint as
     */
    public void setStart(Point p) {
        startPoint = p;
    }

    /**
     * setEnd
     * takes a point and sets the endPoin the this point
     *
     * @param p the Point to set the startPoint as
     * @see setStart
     */
    public void setEnd(Point p) {
        endPoint = p;
    }

    /**
     * containsPoint
     * takes as input a point and determines if this point is in the bounds of the rectangle
     *
     * @param p the coordinates of a point in the drawing
     * @return boolean of if the point p is within a shape
     */
    public boolean containsPoint(Point p) {
        return ((p.getX() >= trueStartX) && (p.getX() <= trueStartX + width) && ((p.getY() >= trueStartY) && (p.getY() <= trueStartY + height)));
    }

    /*
     * (non-Javadoc)
     * @see Shape#move(int, int)
     * command unused because it was more practical to set the
     * centerPoint, as that fulfilled more operations
     * @see MoveCmd
     * @see ExchangeCmd
     */
    public void move(int deltaX, int deltaY) {
    }

    /**
     * getCenter
     * Gives the center of a rectangle
     *
     * @return centerPoint the point in the center of the rectangle
     */
    public Point getCenter() {
        Point centerPoint;

        // center x and y are found by adding hal of width and height
        int centerX = (int) (trueStartX + (HALF_LENGTH * width));
        int centerY = (int) (trueStartY + (HALF_LENGTH * height));

        centerPoint = new Point(centerX, centerY);
        return centerPoint;
    }

    /**
     * setCenter
     * set a new center by moving the entire object
     * move the start and end points to the a given point
     *
     * @param p the Point that is given as the new Center
     */
    public void setCenter(Point p) {

        // start x and y and end x and y are found by subtracting and adding half of width and height to center point
        int startX = (int) (p.getX() - (HALF_LENGTH * width));
        int startY = (int) (p.getY() - (HALF_LENGTH * height));
        int endX = (int) (p.getX() + (HALF_LENGTH * width));
        int endY = (int) (p.getY() + (HALF_LENGTH * height));

        // create new start and end points
        Point newEndPoint;
        newEndPoint = new Point(endX, endY);
        Point newStartPoint;
        newStartPoint = new Point(startX, startY);

        // set start and end points
        setStart(newStartPoint);
        setEnd(newEndPoint);
    }


}
