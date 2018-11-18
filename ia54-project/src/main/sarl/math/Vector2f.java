package math;

import math.Vector2f;


/**
 * A 3-element vector that is represented by single-precision floating point
 * x,y coordinates.  If this value represents a normal, then it should
 * be normalized.
 *
 */
public class Vector2f extends Tuple2f implements java.io.Serializable {

    // Combatible with 1.1
    static final long serialVersionUID = -7031930069184524614L;

    /**
     * Constructs and initializes a Vector3f from the specified xyz coordinates.
     * @param x the x coordinate
     * @param y the y coordinate
     
     */
    public Vector2f(float x, float y)
    {
        super(x,y);
    }


    /**
     * Constructs and initializes a Vector3f from the array of length 3.
     * @param v the array of length 3 containing xyz in order
     */
    public Vector2f(float[] v)
    {
       super(v);
    }


    /**
     * Constructs and initializes a Vector3f from the specified Vector3f.
     * @param v1 the Vector3f containing the initialization x y z data
     */
    public Vector2f(Vector2f v1)
    {
       super(v1);
    }

    /**
     * Constructs and initializes a Vector3f from the specified Tuple3f.
     * @param t1 the Tuple3f containing the initialization x y z data
     */
    public Vector2f(Tuple2f t1) {
       super(t1);
    }

    /**
     * Constructs and initializes a Vector3f to (0,0,0).
     */
    public Vector2f()
    {
        super();
    }


   /**
     * Returns the squared length of this vector.
     * @return the squared length of this vector
     */
    public final float lengthSquared()
    {
        return (this.x*this.x + this.y*this.y);
    }

    /**
     * Returns the length of this vector.
     * @return the length of this vector
     */
    public final float length()
    {
        return (float)
             Math.sqrt(this.x*this.x + this.y*this.y);
    }


  /**
     * Sets this vector to be the vector cross product of vectors v1 and v2.
     * @param v1 the first vector
     * @param v2 the second vector
     */
   /* public final void cross(Vector2f v1, Vector2f v2)
    {
        float x,y;

        x = v1.y*v2.z - v1.z*v2.y;
        y = v2.x*v1.z - v2.z*v1.x;
        this.z = v1.x*v2.y - v1.y*v2.x;
        this.x = x;
        this.y = y;
    }*/

 /**
   * Computes the dot product of this vector and vector v1.
   * @param v1 the other vector
   * @return the dot product of this vector and v1
   */
  public final float dot(Vector2f v1)
    {
      return (this.x*v1.x + this.y*v1.y);
    }

   /**
     * Sets the value of this vector to the normalization of vector v1.
     * @param v1 the un-normalized vector
     */
    public final void normalize(Vector2f v1)
    {
        float norm;

        norm = (float) (1.0/Math.sqrt(v1.x*v1.x + v1.y*v1.y));
        this.x = v1.x*norm;
        this.y = v1.y*norm;
        
    }

    /**
     * Normalizes this vector in place.
     */
    public final void normalize()
    {
        float norm;

        norm = (float)
               (1.0/Math.sqrt(this.x*this.x + this.y*this.y));
        this.x *= norm;
        this.y *= norm;
        
    }


  /**
    *   Returns the angle in radians between this vector and the vector
    *   parameter; the return value is constrained to the range [0,PI].
    *   @param v1    the other vector
    *   @return   the angle in radians in the range [0,PI]
    */
   public final float angle(Vector2f v1)
   {
      double vDot = this.dot(v1) / ( this.length()*v1.length() );
      if( vDot < -1.0) vDot = -1.0;
      if( vDot >  1.0) vDot =  1.0;
      return((float) (Math.acos( vDot )));
   }


   /**Addition d'un vecteur
    *
    * @param Vector2f vect : vecteur a additionner
    *
    * */
   public void plus(Vector2f vect){
	   x += vect.x;
	   y += vect.y;
	   
   }

   /**Soustraction d'un vecteur
    *
    * @param Vector2f vect : vecteur à soustraire
    * */
   public void moins(Vector2f vect){
	   x -= vect.x;
	   y -= vect.y;
	   
   }
   
   public void moins(float xVal,float yVal,float zVal){
	   x -= xVal;
	   y -= yVal;
	   
   }

   /**Homothetie d'un vecteur
    *
    * @param double nbr : facteur de l'homothetie
    * */
   public void fois(double nbr){
	   x *= nbr;
	   y *= nbr;
	  
   }

   public double point(Vector2f vect){
	   return (x*vect.x + y*vect.y);
   }


public double distance(Vector2f v) {
	return Math.sqrt(Math.pow(this.x - v.getX(), 2) + Math.pow(this.y - v.getY(), 2));
}



}