
package math;


/**
 * A 3 element point that is represented by single precision floating point
 * x,y,z coordinates.
 *
 */
public class Point2f extends Tuple2f implements java.io.Serializable {


    // Compatible with 1.1
    static final long serialVersionUID = -8689337816398030143L;

    /**
     * Constructs and initializes a Point3f from the specified xy coordinates.
     * @param x the x coordinate
     * @param y the y coordinate
     
     */
    public Point2f(float x, float y)
    {
        super(x,y);
    }


    /**
     * Constructs and initializes a Point3f from the array of length 2.
     * @param p the array of length 3 containing xy in order
     */
    public Point2f(float[] p)
    {
       super(p);
    }


    /**
     * Constructs and initializes a Point3f from the specified Point3f.
     * @param p1 the Point3f containing the initialization x y z data
     */
    public Point2f(Point2f p1)
    {
       super(p1);
    }

    /**
     * Constructs and initializes a Point3f from the specified Tuple3f.
     * @param t1 the Tuple3f containing the initialization x y z data
     */
    public Point2f(Tuple2f t1)
    {
       super(t1);
    }

    /**
     * Constructs and initializes a Point3f to (0,0,0).
     */
    public Point2f()
    {
        super();
    }


 /**
   * Computes the square of the distance between this point and
   * point p1.
   * @param p1 the other point
   * @return  the square of the distance
   */
  public final float distanceSquared(Point2f p1)
    {
      float dx, dy;

      dx = this.x-p1.x;
      dy = this.y-p1.y;
      
      return dx*dx+dy*dy;
    }


  /**
   * Computes the distance between this point and point p1.
   * @param p1 the other point
   * @return the distance
   */
  public final float distance(Point2f p1)
    {
      float  dx, dy;

      dx = this.x-p1.x;
      dy = this.y-p1.y;
      
      return (float) Math.sqrt(dx*dx+dy*dy);
    }


  /**
    * Computes the L-1 (Manhattan) distance between this point and
    * point p1.  The L-1 distance is equal to:
    *  abs(x1-x2) + abs(y1-y2) + abs(z1-z2).
    * @param p1 the other point
    * @return  the L-1 distance
    */
  public final float distanceL1(Point2f p1)
    {
       return( Math.abs(this.x-p1.x) + Math.abs(this.y-p1.y));
    }


  /**
    * Computes the L-infinite distance between this point and
    * point p1.  The L-infinite distance is equal to
    * MAX[abs(x1-x2), abs(y1-y2)].
    * @param p1 the other point
    * @return  the L-infinite distance
    */
 /* public final float distanceLinf(Point2f p1)
    {
       float tmp;
       tmp = Math.max( Math.abs(this.x-p1.x), Math.abs(this.y-p1.y));
       return(Math.max(tmp,Math.abs(this.z-p1.z)));

    }*/

}