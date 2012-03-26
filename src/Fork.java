/**
 * @author Greg Chambers
 * @author Jacob Juby
 * @author Yin Poon
 */
public class Fork implements IFork {

    private boolean inUse;

    public Fork() {
        this.inUse = false;
    }

    /*
     * A philosopher (attempts to) acquire the fork.
     * 
     * @see IFork#acquire()
     */
    @Override
    public void acquire() {
        if (!inUse) {
            inUse = true;
        }
    }

    /*
     * A philosopher releases the fork.
     * 
     * @see IFork#release()
     */
    @Override
    public void release() {
        inUse = false;
    }

    /**
     * @return the inUse
     */
    public boolean isInUse() {
        return inUse;
    }

}
