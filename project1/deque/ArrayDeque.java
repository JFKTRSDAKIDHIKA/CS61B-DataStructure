package deque;

public class ArrayDeque<T> implements Deque<T>{
    /** Array to store the items of the list */
    private T[] items;
    /** The number of items in the array */
    private int size;
    /**"usage ratio" R which is equal to the size of the list
     * divided by the length of the items array.*/
    private float R;
    /** nextFirst points to the position prior to the first item in the array */
    private int nextFirst;
    /** nextLast points to the position later than the last item in the array */
    private int nextLast;
    /** Resize factor */
    private int factor =10;

    /** Create an empty list . */
    public ArrayDeque(){
        /** Create an array named "items" containing 8 elements */
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
        R = size/ items.length;
    }

    /** Resize the underlying array to target capacity. */
    private void resize(int capacity){
        T[] a = (T[]) new Object[capacity];
        int i = nextFirst+1 ;
        int m = 1;
        while( m <= size)
        {
            a[m] = items[i];
            m = m + 1;
            i = (i+1)%items.length;
        }
        items = a;
        nextFirst = 0;
        nextLast = size +1;
        R = (float) size / items.length;
    }

    /** Insert X into the back of the list. */
    @Override
    public void addLast(T x){
        if(size  == items.length){
            resize(size * factor);
        }
        items[nextLast] = x;
        size = size + 1;
        nextLast = (nextLast+1) % items.length;
        R = (float) size / items.length;
    }

    /** Insert X into the front of the list. */
    @Override
    public void addFirst(T x){
        if(size  == items.length){
            resize(size * factor);
        }
        items[nextFirst] = x;
        size = size + 1;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
        R = (float) size / items.length;


    }

    /** Returns the item from the back of the list  */
    public T getLast(){
        if(! isEmpty()) {
            return items[(nextLast - 1 + items.length) % items.length];
        }
        else{
            return null;
        }
    }


    /** Returns the item from the front of the list  */
    public T getFirst(){
        if(! isEmpty()) {
            return items[(nextFirst + 1) % items.length];
        }
        else
            return null;
    }

    /** Get the ith item in the list */
    @Override
    public T get(int i){
        if(! isEmpty()) {
            return items[(nextFirst + i) % items.length];
        }
        else{
            return null;
        }
    }

    /** Returns the number of items in the list. */
    @Override
    public int size() {
        return size;
    }

    /** public T removeFirst():
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null. */
    @Override
    public T removeFirst(){
        if (! isEmpty()) {
            T x = getFirst();
            items[(nextFirst + 1) % items.length] = null;
            nextFirst = (nextFirst+1) % items.length;
            size = size -1;
            R = (float)size/ items.length;
            if(R < 0.25){
                resize(size+2);
            }
            return x;
        }
        else{
            return null;

        }
    }

    /**Deletes item from back of the list and
     * returns deleted item. */
    @Override
    public T removeLast(){
        if(! isEmpty()){
            T x = getLast();
            items[(nextLast-1 + items.length) % items.length] = null;
            nextLast = (nextLast-1 + items.length) % items.length;
            size = size -1;
            R = (float)size / items.length;
            if(R < 0.25){
                resize(size+2);
        }
        return x;
        }
        else{
            return null;
        }
    }

    /** Returns true if deque is empty, false otherwise. */
    /**public boolean isEmpty(){
        if(size == 0) {
            return true;
        }
        else{
            return false;
        }
    }*/

@Override
    /** Returns the capacity of the array */
    public int Length(){
        return items.length;
    }

    /**  Prints the items in the deque from first to last, separated by a space. */
    public void printDeque(){
        int i = (nextFirst+1)% items.length ;
        for (int n = 0;n < size;n = n+1){
        System.out.print(items[i]);
        System.out.print(" ");
        i = (i+1)%items.length;
        }
        System.out.println();
    }















}
