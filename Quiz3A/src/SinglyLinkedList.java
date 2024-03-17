// Name: Zhiyuan Chang
// Computing ID: vgs3qt
// Homework Name: Quiz3A

import java.security.PublicKey;

public class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.setNext(head); //make it a circular list
        }
        else {
            tail.setNext(newNode);
            tail = newNode;
            tail.setNext(head); //make it a circular list
        }
        size++;
    }

    public void remove(int data) {
        if (head == null) {
            return;
        }
        if (head.getData() == data) {
            if(size == 1){   // first check how many element exist in the list.
                head = null; // clear all data because there are only one element
                tail = null; // and that element is removed.
                size--;
            }
            else {
                head = head.getNext();
                tail.setNext(head);
                size--;
            }
            return;
        }
        Node current = head;
        while (current.getNext() != head) { // circular loop, end when it is at tail. Tail.next is head.
            if (current.getNext().getData() == data) {
                if(current.getNext() == tail){ // if next one is tail, just change the tail to current.
                    tail = current;
                    tail.setNext(head); // it is circular list.
                }
                else{
                    current.setNext(current.getNext().getNext());
                }
                size--;
                return;
            }
            current = current.getNext();
        }
    }

    public int get(int index) { // all good.
        if (index < 0 || index >= size) {
            return -1;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    public void print() { // all good.
        if (head == null) {
            return;
        }
        Node current = head;
        do {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        } while (current != head); //stop when it finishes print tail. Tail.next is head.
        System.out.println();
    }
}