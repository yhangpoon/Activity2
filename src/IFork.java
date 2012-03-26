/**
 * 
 */

/**
 * @author Yin
 * 
 */
public interface IFork {
    /*
     * A philosopher (attempts to) acquire the fork.
     */
    public void acquire();

    /*
     * A philosopher releases the fork.
     */
    public void release();
}
