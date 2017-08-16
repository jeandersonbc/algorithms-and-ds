import java.lang.StringBuilder;

/*
 * Chapter 10.1 - Elementary Data Structures: Stacks and Queues
 * Compile and run: javac StackFixedSize.java && java Main
 *
 * Author: Jeanderson Candido <http://jeandersonbc.github.io>
 */
class Main {

    /*
     * Elementary implementation of Stack using a fixed-size array
     */
    static class StackFixedSize<E> {
        private Object[] elements;
        private int top; // This index holds the position of the next element to be removed

        StackFixedSize(int initialCapacity) {
            if (initialCapacity < 1)
                throw new RuntimeException("Initial capacity must be a positive integer greater than 0");
            this.elements = new Object[initialCapacity];
            this.top = -1;
        }

        void push(E element) {
            if (this.top == this.elements.length - 1)
                throw new RuntimeException("Reached maximum capacity!"); 
            this.elements[++this.top] = element;
        }

        E pop() {
            if (isEmpty())
                throw new RuntimeException("Empty stack!"); 
                
            // This suppressing is safe since the implementation guarantees
            // that array "elements" contains only elements of type E (see "push")
            @SuppressWarnings("unchecked")
            E element = (E) this.elements[this.top];

            this.elements[this.top--] = null;
            return element;
        }

        @Override
        public String toString() {
            StringBuilder str = new StringBuilder("[");
            for (int i = 0; i < this.top; i++) {
                str.append(elements[i]).append(", ");
            }
            if (this.top > -1) {
                str.append("top=").append(elements[this.top]);
            }
            return str.append("]").toString();
        }

        boolean isEmpty() {
            return this.top < 0;
        }
    }

    public static void main(String[] args) {
        // Example from Figure 10.1
        StackFixedSize<Integer> S = new StackFixedSize<>(7);

        S.push(15);
        S.push(6);
        S.push(2);
        S.push(9);
        System.out.println(S);

        S.push(17);
        S.push(3);
        System.out.println(S);

        System.out.println(S.pop());
        System.out.println(S);
    }
}
