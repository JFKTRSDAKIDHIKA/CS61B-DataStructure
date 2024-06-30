package gh2;

import deque.ArrayDeque;
import deque.LinkedListDeque;
import deque.Deque;



public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final
     * means the values cannot be changed at runtime. We'll discuss this and
     * other topics in lecture on Friday. */
    private static final int SR= 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private Deque<Double> buffer;
    private int capacity;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        capacity = (int) Math.round(SR / frequency);
        // create and initialize the buffer.
        buffer = new LinkedListDeque<>();
        for (int i = 0; i < capacity; i++) {
            buffer.addLast(0.0);
        }
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        while (!buffer.isEmpty()) {
            buffer.removeFirst();
        }

        for (int i = 0; i < capacity; i++) {
            double r = Math.random() - 0.5;
            buffer.addLast(r);
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        // Dequeue the front sample
        double firstSample = buffer.removeFirst();

        // enqueue a new sample that is the average of the two multiplied by the DECAY factor.
        double nextSample = buffer.getFirst();
        double newSample = (firstSample + nextSample) / 2 * DECAY;

        // add the new sample to the back of the buffer
        buffer.addLast(newSample);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        return buffer.getFirst();
    }
}
