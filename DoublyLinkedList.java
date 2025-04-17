import java.util.*;


class MyDoublyLinkedList<T>{
    Node<T> head;

    class Node<T>{
        T data;
        Node<T> next=null;
        Node<T> prev=null;

        Node(T data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }

    public int countNodes() {
        if(head==null) return 0;
        int count=1;
        if(head.next==null) return count;
        Node<T> temp=head.next;
        while(temp!=null) {
            temp=temp.next;
            count++;
        }
        return count;
    }
    public void insert_front(T element) {
        Node<T>	newNode=new Node<>(element);
        if(head==null) {
            head=newNode;
            newNode.next=null;
            newNode.prev=null;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
        newNode.prev=null;
    }
    //Method to insert an element into any index
    public void insert_index(T element,int index) {
        if(head==null) return;
        Node<T>	newNode=new Node<>(element);
        if(index==0) {
            insert_front(element);
            return;
        }
        Node<T> temp=head;
        int place=0;
        while(temp!=null && place!=index) {
            temp=temp.next;
            place++;
        }
        if (temp == null && place == index) {
            insert_end(element);
            return;
        }
        if(temp==null) {
            System.out.println("index Out of bounds");
            return;
        }
        Node<T> prevNode = temp.prev;
        newNode.next = temp;
        newNode.prev = prevNode;

        // Update previous node's next pointer
        if (prevNode != null) {
            prevNode.next = newNode;
        }

        // Update temp's previous pointer
        temp.prev = newNode;
    }

    public void insert_end(T element) {
        Node<T>	newNode=new Node<>(element);
        if(head==null) {
            head=newNode;
            return;
        }
        Node<T> temp=head;

        while(temp.next!=null) {
            temp=temp.next;
        }
        temp.next=newNode;
        newNode.prev=temp;
        newNode.next=null;
    }

    public void del_front(){
        if(head==null) return;
        if(head.next==null) {
            head = null;
            return;
        }
        head=head.next;
        head.prev=null;
    }

    public void del_end(){
        if(head==null) return;
        if(head.next==null){
            head=null;
            return;
        }
        Node<T> temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        Node<T> prevNode=temp.prev;
        prevNode.next=null;
        temp.prev=null;

    }

    public void del_index(int index){
        if(head==null) return;
        if(index==0){
            head=head.next;
            if(head!=null){
                head.prev=null;
            }
            return;
        }
        Node<T> temp=head;
        int place=0;
        while(temp!=null && place!=index){
            temp=temp.next;
            place++;
        }
        if(temp==null){
            System.out.println("Overflow");
            return;
        }
        Node<T> prevNode=temp.prev;
        prevNode.next=temp.next;
        if(temp.next==null){
            temp.prev=null;
            return;
        }
        temp.next.prev=prevNode;
        temp.prev = null;
        temp.next = null;
    }

    public void display(){
        Node<T> temp=head;
        while(temp!=null){
            System.out.print(temp.data +" ");
            temp=temp.next;
        }
        System.out.println();
    }
}

public class DoublyLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyDoublyLinkedList<Object> list = new MyDoublyLinkedList<>();
        int choice;

        do {
            System.out.println("\n--- Doubly Linked List Menu ---");
            System.out.println("1. Insert at Front");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Index");
            System.out.println("4. Delete from Front");
            System.out.println("5. Delete from End");
            System.out.println("6. Delete from Index");
            System.out.println("7. Display");
            System.out.println("8. Count Nodes");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            int element, index;

            switch (choice) {
                case 1:
                    System.out.print("Enter element to insert at front: ");
                    element = sc.nextInt();
                    list.insert_front(element);
                    list.display();
                    break;
                case 2:
                    System.out.print("Enter element to insert at end: ");
                    element = sc.nextInt();
                    list.insert_end(element);
                    list.display();
                    break;
                case 3:
                    System.out.print("Enter element to insert: ");
                    element = sc.nextInt();
                    System.out.print("Enter index: ");
                    index = sc.nextInt();
                    list.insert_index(element, index);
                    list.display();
                    break;
                case 4:
                    list.del_front();
                    System.out.println("Front element deleted.");
                    list.display();
                    break;
                case 5:
                    list.del_end();
                    System.out.println("End element deleted.");
                    list.display();
                    break;
                case 6:
                    System.out.print("Enter index to delete: ");
                    index = sc.nextInt();
                    list.del_index(index);
                    list.display();
                    break;
                case 7:
                    list.display();
                    break;
                case 8:
                    System.out.println("Number of nodes: " + list.countNodes());
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 0);

        sc.close();

    }
}
