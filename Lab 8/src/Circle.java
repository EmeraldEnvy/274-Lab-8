public class Circle {
    /**
     * Initialize x
     */
    private int x;
    /**
     * Initialize y
     */
    private int y;
    /**
     * Initialize radius
     */
    private int Radius;

    /**
     * Create circle
     * @param a = x
     * @param b = y
     * @param c = Radius
     */
    public Circle( int a, int b, int c ){
        x = a;
        y = b;
        Radius = c;
    }

    /**
     * Test if circles are same
     * @param o 2nd circle
     * @return true if circles are same
     */
    @Override
    public boolean equals( Object o){
        if ( o instanceof Circle ){
            Circle circle2 = (Circle) o;
            return (this.x == circle2.x) && (this.y == circle2.y) && (this.Radius == circle2.Radius);
        }
        return false;
    }

    /**
     * Create circle in string form
     * @return circle string
     */
    @Override
    public String toString(){
        return ("(" + x + "," + y + ") R = " + Radius );
    }
}
