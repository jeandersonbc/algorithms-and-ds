# Queues

Queues are sequential/linear data structures with a specific policy for additions and removals.
Whenever we add an element, it goes to the end of the queue; conversely, removals happen at the front of the queue.
This is known as First-In-First-Out (FIFO) policy and it's widely used across computer science domains (and real-life examples).
For instance, buffering arriving network data to be processed, or serving orders to clients as they come in a cafe.

## Basic Operations

* enqueue: adds an element to the end of queue
* dequeue: removes an element from the front of the queue
* peek: checks the front element (next to be removed)

## Design Decisions

We need an underlying data structure to support Queue specifications.
A natural question is: _"Should we use an Array or a Linked List?"_.
Which ever we choose depends on the context and their respective trade-offs.

### Array-based queues

There are several reasons we might want to use an array to bake our data structure.
Perhaps we are using a fixed-size buffer to process incoming events, and it is only natural to have already a fully-fledged array allocated for that.

We know that we need a pointer to track the front and the rear part of the array.
However, there is a caveat: as we add and remove elements, the pointers are always advancing to the end of the array.
That means (1) wasted space of unused allocated space and (2) shortening the capacity as the pointers get closer to out of bounds.
There is a simple yet impactful trick to overcome this issue:

* The circular pointer trick

Recall we have two pointers to track the rear and front part of the array.
In addition to increment to next position (for dequeues and enqueues), we use _modulus N_ (N = length of the array):

```
front = (front + 1) mod N
rear = (rear + 1) mod N
```

This simple trick allows the pointers to circle back to the beginning of the array and use the available space.
This works because, conceptually, `front` is always less than (or equals when empty) `rear` and they never cross each other.
At most, there will always be N elements at the same time.
As long as adds and removals happen, the pointers always use the next available position.

* To resize or not resize?

The memory usage has been addressed by the circular pointer trick.
The next question then is _"What to do once the queue is at capacity?"_.
There are several strategies for this:

1. You can decide that no new element is added until the actual size is less than the capacity
2. You could drop the next element to free space for the upcoming enqueuing
3. You could resize the underlying array

The first two are very common within the context of event-based services, but not so common on data structure libraries.
The third, however, is an inherited decision of dynamic arrays and widely used.
Therefore, when resizing, we could set a strategy based on what we explored in [Arrays and Dynamic Arrays](ARRAYS.md):
- When enqueueing, if the array is at 75% of capacity:
  - Create a new array with double capacity, copy the old elements and add the new element
  - New array is 38% full, e.g., from 75 out of 100 to 76 out of 200 after doubling capacity and adding new element
- When dequeueing, if the array is at 25% of capacity:
  - Create a N/2 shorter array, copy the old elements, and dequeue the next element
  - New array is 48% full, e.g., from 25 out 100 to 24 out of 50 after shrinking capacity and removing next element

> The in-depth runtime analysis, implications, and influence of the thresholds are specific to the topic of Dynamic Arrays and beyond the scope of Stacks.

### LinkedList-based queues

The inherited dynamic nature of LinkedList simplifies a lot of design decisions.
All it takes is a `Node` representation, and track the front and last nodes.
LinkedLists naturally handle capacity as long as there is space for Node allocation.
For instance, there is no need for "clever" pointer tricks for optimal memory usage.
On the other hand, it's easy to forget to update some pointers, leaving dangling pointers behind.

* Should we use track next and prev nodes (as in doubly linked node)?

Let's assess this via Queue operations:

1. Peeking:
   * Peeking is a query operation from the front node.
   * Nothing special about tracking prev/next pointers.
2. Queueing:
   * We already have a pointer to track the last/rear Node.
   * Thus, we can create a new node, set the new element, and update the last element.
   * Nothing special about tracking prev/next pointers.
3. Dequeuing:
   * We already have a pointer to track the front Node.
   * Thus, we can return the element from front Node, update the current front (and other pointers).
   * Nothing special about tracking prev/next pointers.

The true benefit of tracking prev/next Nodes happens when we need to do (reversal-)traversals
and when we need to modify in-between elements.
We can just approach LinkedList-based queues with simply linked nodes.

However, if our usecase needs to support mid-queue removals, e.g., a print queue where a waiting job can be cancelled and removed,
then, prev/next pointers would help and simplify these removals.
It's _always_ a matter of context.

## The Language Zoo

Queue support differs a lot between Go, Python, and Java.
For instance, Java alone has an actual [Queue](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Queue.html) interface with several related interfaces
and concrete implementations for different contexts (e.g., concurrency).
See the language-specifics below:

<details>
<summary>Java</summary>

* From the ground-up
  * Check [Queue.java](https://github.com/jeandersonbc/algorithms-and-ds/blob/74cbf9bdd0a941f14dbee34a596fbab43fec76f7/java/lib/src/main/java/org/example/Queue.java) and related code for
    an implementation from scratch for learning purposes

* What is in Collections Framework
  * [Queue](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Queue.html) is an interface that offer two flavours of API.
    One returns special values on corner-cases (e.g., `null`) while the other throws runtime exceptions (e.g., `NoSuchElementException`).
    For concrete class, there are several options. Two interesting ones being `LinkedList` and `ArrayDeque` (A resizable double-ended array).
    Check the `Queue` page for docs and references.
  
</details>
<details>
  <summary>Go</summary>
  TBD
</details>
<details>
  <summary>Python</summary>
  TBD
</details>
