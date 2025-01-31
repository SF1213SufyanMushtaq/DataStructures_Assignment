import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueTasks {
    // Queue implemented using LinkedList
    private Queue<Integer> queue = new LinkedList<>();

    // Function to add an element to the queue
    public void enqueue(int value) {
        queue.add(value);
    }

    // Function to remove an element from the queue
    public int dequeue() {
        if (!queue.isEmpty()) {
            return queue.poll();
        }
        throw new IllegalStateException("Queue is empty.");
    }

    // 1. Reverse the first K elements of the Queue
    public void reverseFirstKElements(int k) {
        if (k > queue.size() || k < 0) {
            throw new IllegalArgumentException("Invalid value of K.");
        }

        Stack<Integer> stack = new Stack<>();
        // Push first K elements into a stack
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        // Add the elements back to the queue in reversed order
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        // Move the remaining elements (queue.size() - k) to the back of the queue
        int size = queue.size();
        for (int i = 0; i < size - k; i++) {
            queue.add(queue.poll());
        }
    }

    // 2. Implement getMinimum() function for Queue
    public int getMinimum() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }

        int min = Integer.MAX_VALUE;
        // Iterate through the queue to find the minimum element
        for (int value : queue) {
            min = Math.min(min, value);
        }
        return min;
    }

    // Function to display the queue
    public void displayQueue() {
        System.out.println(queue);
    }

    public static void main(String[] args) {
        QueueTasks queueTasks = new QueueTasks();

        // Adding elements to the queue
        queueTasks.enqueue(10);
        queueTasks.enqueue(20);
        queueTasks.enqueue(30);
        queueTasks.enqueue(40);
        queueTasks.enqueue(50);

        System.out.println("Original Queue:");
        queueTasks.displayQueue();

        // Reverse the first 3 elements of the queue
        queueTasks.reverseFirstKElements(3);
        System.out.println("Queue after reversing first 3 elements:");
        queueTasks.displayQueue();

        // Get the minimum element from the queue
        int minimum = queueTasks.getMinimum();
        System.out.println("Minimum element in the queue: " + minimum);
    }
}
