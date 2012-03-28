/**
 * @author Greg Chambers
 * @author Jacob Juby
 * @author Yin Poon
 */
public class Fork implements IFork {

    private boolean inUse;
    private boolean inRun;

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
        while (inRun) {
            if (!inUse) {
                inUse = true;
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {

                }
            }
            inRun = false;
        }
        inRun = true;
    }

    /*
     * A philosopher releases the fork.
     * 
     * @see IFork#release()
     */
    @Override
    public void release() {
        inUse = false;
        notifyAll();
    }

    /**
     * @return the inUse
     */
    public boolean isInUse() {
        return inUse;
    }

}
