import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
    // items of stack
    private Item[] a = (Item[]) new Object[1];
    // number of stack items
    private int N = 0;

    // check to see if array is empty
    public boolean isEmpty() {
        return N == 0;
    }

    // size of array
    public int size() {
        return N;
    }

    // resize method allows for stack to always be at least 1/4 full and never overflows
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++)
            temp[i] = a[i];
        a = temp;
    }

    // push method adds an item to the top of the stack
    public void push(Item item) {
        if (N == a.length) { // resizing stack based on how full it is
            resize(2 * a.length);
        }
        a[N++] = item;
    }

    // pop method removes item from the top of the stack
    public Item pop() {
        Item item = a[--N];
        a[N] = null; // loitering (garbage policy collection), necessary to reclaim memory
        if (N > 0 && N == a.length / 4) { // resizing stack based on how full it is
            resize(a.length / 2);
        }
        return item;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> { // Support LIFO iteration.
        private int i = N;

        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            return a[--i];
        }

        public void remove() {
        }
    }
}

