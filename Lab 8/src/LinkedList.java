public class LinkedList {
    public static class Node {
        /**
         * Initial data
         */
        private Circle data;
        /**
         * Initialize next
         */
        private Node next;
        public Node( Circle s ){
            data = s;
            next = null;
        }

        /**
         * Create node
         * @param s Circle
         * @param n Node
         */
        public Node ( Circle s, Node n ){
            data = s;
            next = n;
        }

    }

    /**
     * Initialize first node
     */
    private Node first;
    /**
     * Initialize last node
     */
    private Node last;

    /**
     * Create empty linked list
     */
    public LinkedList(){
        first = null;
        last = null;
    }

    /**
     * Checks for if empty
     * @return true if empty
     */
    public boolean isEmpty(){
        return first == null;
    }

    /**
     * Add a circle node
     * @param s the circle
     */
    public void add( Circle s ){
        if( first == null ){
            first = new Node( s );
            last = first;
        } else {
            Node n = new Node( s );
            last.next = n;
            last = n;
        }
    }

    /**
     * Add a circle node using the index and circle
     * @param i index
     * @param s circle
     */
    public void add( int i, Circle s){
        if( i < 0 ){
            throw new IndexOutOfBoundsException();
        }
        if( i == 0 ){
            first = new Node( s , first );
            if( last == null ){
                last = first;
            }
        } else {
            Node n = first;
            if( n == null ){
                throw new IndexOutOfBoundsException();
            }
            for( int j = 1 ; j < i ; j++){
                n = n.next;
                if( n == null ){
                    throw new IndexOutOfBoundsException();
                }
            }
            n.next = new Node( s , n.next );
            if( n.next.next == null ){
                last = n.next;
            }
        }
    }

    /**
     * Get circle
     * @param i index
     * @return circle
     */
    public Circle get( int i ){
        if( first == null || i < 0){
            throw new IndexOutOfBoundsException();
        }
        Node n = first;
        for( int j = 0 ; j < i ; j++ ){
            n = n.next;
            if( n == null ){
                throw new IndexOutOfBoundsException();
            }
        }
        return n.data;
    }

    /**
     * Set circle at index
     * @param i index
     * @param s circle
     */
    public void set( int i, Circle s ){
        if( first == null || i < 0){
            throw new IndexOutOfBoundsException();
        }
        Node n = first;
        for( int j = 0 ; j < i ; j++){
            n = n.next;
            if( n == null ){
                throw new IndexOutOfBoundsException();
            }
        }
        n.data=s;
    }

    /**
     * Get size of list
     * @return size
     */
    public int size(){
        int count = 0;
        Node n = first;
        while( n != null ){
            count++;
            n = n.next;
        }
        return count;
    }

    /**
     * Get string of list
     * @return list as string
     */
    @Override
    public String toString(){
        String str = "";
        Node n = first;
        while( n != null ){
            str = str + n.data + "\n";
            n = n.next;
        }
        return str;
    }

    /**
     * Remove circle at index
     * @param i index
     * @return removed circle
     */
    public Circle remove( int i ){
        Circle rem;
        if( first == null || i < 0 ){
            throw new IndexOutOfBoundsException();
        }
        if ( i == 0 ){
            rem = first.data;
            first = first.next;
            if( first == null ){
                last = null;
            }
        } else {
            Node n = first;
            for( int j = 1 ; j < i ; j++ ){
                n = n.next;
                if( n == null ){
                    throw new IndexOutOfBoundsException();
                }
            }
            if( n.next == null ){
                throw new IndexOutOfBoundsException();
            }
            rem = n.next.data;
            n.next = n.next.next;
            if( n.next == null ){
                last = n;
            }
        }
        return rem;
    }

    /**
     * Remove circle
     * @param s circle
     * @return true if removed
     */
    public boolean remove ( Circle s ){
        if ( first != null ){
            if( s.equals( first.data ) ){
                first = first.next;
                if( first == null ){
                    last = null;
                }
                return true;
            } else{
                Node n = first;
                while( n.next != null && !n.next.data.equals( s ) ){
                    n = n.next;
                }
                if( n.next != null ){
                    n.next = n.next.next;
                    if( n.next == null ){
                        last = n;
                    }
                    return true;
                }
            }
        }
        return false;
    }
}