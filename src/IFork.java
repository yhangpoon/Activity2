/**
 * @author Greg Chambers
 * @author Jacob Juby
 * @author Yin Poon
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
