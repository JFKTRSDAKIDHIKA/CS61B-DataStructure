package deque;

public class LinkedListDeque<T> implements Deque<T> {
    public Node sentF;
    //** add a second sentinel node to the back of the list */
    public Node sentB;
    public int size;


    public  class Node{
        public Node prev;
        public T item;
        public Node next;

        public Node(Node p, Node n){
            prev = p;
            next = n;
        }

        public Node(T i,Node p, Node n){
            item = i;
            prev = p;
            next = n;
        }
    }

    /** Creates an empty linked list deque with front sentinel and back sentinel. */
    public LinkedListDeque(){
        size=0;
        sentF = new Node(null,null);
        sentB = new Node(sentF,null);
        sentF.next = sentB;
    }

    //** Adds an item of type T to the front of the deque. */
    @Override
    public void addFirst(T item){
        size += 1;
        Node newItem = new Node(item,sentF,sentF.next);
        sentF.next.prev = newItem;
        sentF.next = newItem;
    }


    //** Adds an item of type T to the back of the deque. */
    @Override
    public void addLast(T item) {
        size += 1;
        Node newItem = new Node(item,sentB.prev,sentB);
        sentB.prev.next = newItem;
        sentB.prev = newItem;
    }

    /** Returns true if deque is empty, false otherwise. */
    /**public boolean isEmpty(){
        if(sentF.next == sentB){
            return true;
        }
        else{
            return false;
        }
    }*/

    /** Returns the number of items in the deque. */
    @Override
    public int size(){
        return size;
    }

    @Override
    public int Length(){
        return size;
    }



    /**  Prints the items in the deque from first to last, separated by a space.*/
    public void printDeque(){
        Node p = sentF.next ;
        while(p != sentB)
        {
            System.out.print(p.item);
            System.out.print(" ");
            p = p.next;
        }
        System.out.println();
    }

    /** Removes and returns the item at the front of the deque.*/
    @Override
    public T removeFirst(){
        if(! isEmpty()){
            T i =sentF.next.item;
            sentF.next.next.prev=sentF;
            sentF.next = sentF.next.next;
            size = size - 1;
            return i;
        }
        else{
            return null;
        }
    }

    /** Removes and returns the item at the back of the deque.*/
    @Override
    public T removeLast(){
        if(! isEmpty()){
            T i =sentB.prev.item;
            sentB.prev.prev.next=sentB;
            sentB.prev = sentB.prev.prev;
            size = size - 1;
            return i;
        }
        else{
            return null;
        }
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.*/
    @Override
    public T get(int index){
        Node p = sentF.next;
        for(int i = 0 ; i <= index ; i+=i) {
            p = p.next;
            if(p == sentB){
                return null;
            }
        }
        return p.item;
    }


    /** Same as get, but uses recursion. */
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(sentF.next, index);
    }

    private T getRecursiveHelper(Node node, int index) {
        if (index == 0) {
            return node.item;
        } else {
            return getRecursiveHelper(node.next, index - 1);
        }
    }

    @Override
    public T getFirst(){
        return sentF.next.item;
    }




    }
/**
 * public Iterator<T> iterator(): The Deque objects we’ll make are iterable (i.e. Iterable<T>)
 * so we must provide this method to return an iterator.
 * public boolean equals(Object o): Returns whether or not the parameter o is equal to the Deque.
 * o is considered equal if it is a Deque and if it contains the same contents
 * (as goverened by the generic T’s equals method) in the same order.
 * (ADDED 2/12: You’ll need to use the instance of keywords for this.
 * Read here for more information)
 */









