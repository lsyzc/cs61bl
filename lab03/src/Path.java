/** A class that represents a path via pursuit curves. */
public class Path {

    // TODO
    private Point curr;
    private Point next;

    public Path(double x, double y) {
        next = new Point(x, y);

    }

    public double getCurrX(){
        return curr.getX();
    }
    public  double getCurrY(){
        return curr.getY();
    }
    public double getNextX(){
        return next.getX();
    }
    public double getNextY(){
        return next.getY();
    }
    public Point getCurrentPoint() {
        return curr;
    }
    public void setCurrentPoint(Point curr) {
        this.curr = curr;
    }

    public void iterate(double dx, double dy) {
        double new_x = next.getX() + dx;
        double new_y = next.getY() + dy;
        curr = next;
        next = new Point(new_x,new_y);
    }


}
