package design;

public class MyLinkedList {

    private Node head;
    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        Node p = head;
        while(index > 0){
            p = p.next;
            index--;
        }
        return p.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node();
        node.val = val;
        node.next = head;
        this.head = node;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node();
        node.val = val;

        Node p = head;
        while(p.next != null){
            p = p.next;
        }
        p.next = node;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index <= 0){
            addAtHead(val);
            return;
        }
        if(index >= size){
            addAtTail(val);
            return;
        }

        Node node = new Node();
        node.val = val;

        Node p = head;
        while(index > 1){
            p = p.next;
            index--;
        }
        node.next = p.next;
        p.next = node;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size){
            return;
        }
        Node p = head;
        if(index == 0){
            head = p.next;
            p.next = null;
            size--;
            return;
        }
        while(index > 1){
            p = p.next;
            index--;
        }
        p.next = p.next.next;
        size--;
    }

    class Node{
        int val;
        Node next;
    }

    public static void main(String[] args){
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(0);  //现在链表是1-> 3
        linkedList.get(1);            //返回3
    }
}
