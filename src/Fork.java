/**
 * @author Greg Chambers
 * @author Jacob Juby
 * @author Yin Poon
 */
public class Fork implements IFork {

    private boolean use;

    public Fork() {
        this.use = false;
    }

    /*
     * A philosopher (attempts to) acquire the fork.
     * 
     * @see IFork#acquire()
     */
    @Override
    public void acquire() {
        if (use == false) {
            use = true;
        } else {

        }

    }

    /*
     * A philosopher releases the fork.
     * 
     * @see IFork#release()
     */
    @Override
    public void release() {
        use = false;

    }

}
