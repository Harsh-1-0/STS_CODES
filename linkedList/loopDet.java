public class loopDet {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head;

    void push(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    void detectLoop() {
        Node slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                System.out.print("Loop Detected");
                return;
            }
        }
        System.out.print("No Loop Detected");
        return;
    }

    public static void main(String args[]) {
        loopDet list = new loopDet();
        list.push(10);
        list.push(20);
        list.push(30);
        list.push(40);
        list.push(50);
        list.head.next.next.next = list.head;
        list.detectLoop();

    }
}
