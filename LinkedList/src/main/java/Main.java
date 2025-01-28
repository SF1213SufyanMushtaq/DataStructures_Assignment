class SinglyLinkList {
    Node head;
    Node tail; // Pointer to the last node

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public int length() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void printMiddle() {
        Node slow = head;
        Node fast = head;

        if (head != null) {
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            System.out.println("Middle node: " + slow.data);
        }
    }

    public SinglyLinkedList reverse() {
        SinglyLinkedList reversedList = new SinglyLinkedList();
        Node current = head;
        while (current != null) {
            SinglyLinkedList.Node newNode = new SinglyLinkedList.Node(current.data);
            newNode.next = reversedList.head;
            reversedList.head = newNode;
            if (reversedList.tail == null) {
                reversedList.tail = newNode; // Set tail for the first node
            }
            current = current.next;
        }
        return reversedList;
    }

    public void removeDuplicates() {
        Node current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public static SinglyLinkedList merge(SinglyLinkedList list1, SinglyLinkedList list2) {
        SinglyLinkedList mergedList = new SinglyLinkedList();
        SinglyLinkedList.Node current1 = list1.head;
        SinglyLinkedList.Node current2 = list2.head;

        while (current1 != null && current2 != null) {
            if (current1.data <= current2.data) {
                mergedList.append(current1.data);
                current1 = current1.next;
            } else {
                mergedList.append(current2.data);
                current2 = current2.next;
            }
        }

        while (current1 != null) {
            mergedList.append(current1.data);
            current1 = current1.next;
        }

        while (current2 != null) {
            mergedList.append(current2.data);
            current2 = current2.next;
        }

        return mergedList;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode; // Set tail for the first node
        } else {
            tail.next = newNode; // Link the new node to the end of the list
            tail = newNode; // Update the tail to the new node
        }
    }

    public void deleteList() {
        head = null;
        tail = null; // Also clear the tail reference
        System.out.println("Singly Linked List deleted.");
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.append(1);
        list.append(2);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);

        System.out.println("Original List:");
        list.printList();

        System.out.println("Length of the list: " + list.length());

        list.printMiddle();

        SinglyLinkedList reversedList = list.reverse();
        System.out.println("Reversed List:");
        reversedList.printList();

        list.removeDuplicates();
        System.out.println("List after removing duplicates:");
        list.printList();

        // Merging two sorted lists
        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.append(2);
        list2.append(3);
        list2.append(5);
        list2.append(6);

        System.out.println("Second Sorted List:");
        list2.printList();

        SinglyLinkedList mergedList = SinglyLinkedList.merge(list, list2);
        System.out.println("Merged Sorted List:");
        mergedList.printList();

        // Deleting the original list
        list.deleteList();
    }
}