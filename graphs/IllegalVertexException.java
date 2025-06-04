package graphs;
/**
 * Thrown to indicate that an argument to a Graph
 * method specified a non-existent vertex. 
 * 
 * You should NOT change this file for the assignment
 */
public class IllegalVertexException
    extends IllegalArgumentException {

    /**
     * Construct a new IllegalVertexException with the
     * specified detail message.
     *
     * @param s the detail message associated with this
     *          IllegalVertexException.
     */
    public IllegalVertexException(String s) {
	   super(s);
    }
}