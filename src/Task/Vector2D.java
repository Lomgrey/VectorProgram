package Task;


public class Vector2D {

    /**
     * First point of vector
     */
    private final double x1, y1;

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    /**
     * Second point of vector
     */
    private final double x2, y2;

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }

    public Vector2D() {
        x1 = 0;
        y1 = 0;
        x2 = 0;
        y2 = 0;
    }

    public Vector2D(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    /**
     * @param vector for adding with current
     * @return new vector as result adding current and specified vector
     */
    public Vector2D add (Vector2D vector){
        return new Vector2D(
                getX1() + vector.getX1(),
                getY1() + vector.getY1(),
                getX2() + vector.getX2(),
                getY2() + vector.getY2()
        );
    }

    /**
     * @param vector for take out from current
     * @return vector as result difference current and specified vector
     */
    public Vector2D subtract (Vector2D vector){
        return new Vector2D(
                getX1() - vector.getX1(),
                getY1() - vector.getY1(),
                getX2() - vector.getX2(),
                getY2() - vector.getY2()
        );
    }

    /**
     * @param factor for multiple on vector
     * @return vector as result multiple current vector on factor
     */
    public Vector2D multiply (double factor){
        return new Vector2D(
                x1 * factor,
                y1 * factor,
                x2 * factor,
                y2 * factor
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Vector2D){
            Vector2D other = (Vector2D) obj;
            return  (x1 == other.getX1() && y1 == other.getY1()
                    && x2 == other.getX2() && y2 == other.getY2());
        }else return false;
    }
}
