public class main {
    public static void main(String[] args) {
        SinglyLinkedList a = new SinglyLinkedList();
        a.print();
        a.add(10);
        a.print();
        System.out.println(a.get(0));
        a.add(5);
        a.print();
        a.add(8);
        a.print();
        System.out.println(a.get(4));
        System.out.println(a.get(2));
        a.remove(10);
        a.print();
        System.out.println(a.get(0));
        a.remove(8);
        a.print();
        a.remove(5);
        a.print();
        System.out.println(a.get(0));


    }
}
