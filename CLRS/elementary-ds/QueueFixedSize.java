import java.lang.StringBuilder;

class Main { 

    static class QueueFixedSize<E> {
        private Object[] elements;
        private int tail, head, n;

        QueueFixedSize(int initialCapacity) {
            if (initialCapacity < 1)
                throw new RuntimeException("Initial capacity must be greater than zero");
            this.elements = new Object[initialCapacity];
        }

        void enqueue(E element) {
            this.elements[this.tail] = element;
            this.tail = (this.tail + 1) % this.elements.length;
            n++;
        }

        E dequeue() {
            @SuppressWarnings("unchecked")
            E element = (E) this.elements[this.head];

            this.elements[this.head] = null;
            this.head = (this.head + 1) % this.elements.length;
            n--;

            return element;
        }

        @Override
        public String toString() {
            StringBuilder str = new StringBuilder("Q: ");
            for (int i = 0; i < n; i++) {
                str.append(this.elements[(this.head + i) % this.elements.length]).append(" ");
            }
            return str.toString();
        }
    }

    public static void main(String[] args) {
        QueueFixedSize<Integer> Q = new QueueFixedSize<>(5);
        System.out.println(Q);

        Q.enqueue(3);
        Q.enqueue(4);
        Q.enqueue(8);
        Q.enqueue(10);
        Q.enqueue(20);
        System.out.println(Q);

        System.out.println(Q.dequeue());
        System.out.println(Q.dequeue());
        System.out.println(Q);

        Q.enqueue(3);
        Q.enqueue(4);
        System.out.println(Q);

        for (int i = 0; i < 5; i++) {
            System.out.println(Q.dequeue());
            System.out.println(Q.dequeue());
            System.out.println(Q.dequeue());
            Q.enqueue((i + 1) * 100);
            Q.enqueue((i + 2) * 100);
            Q.enqueue((i + 3) * 100);
            System.out.println(Q);
        }
    }
}
