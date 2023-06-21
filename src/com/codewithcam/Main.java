package com.codewithcam;

public class Main {

    public static void main(String[] args) {
//        Array array = new Array(4);
//        array.insert(10);
//        array.insert(20);
//        array.insert(20);
//        array.insert(30);
//        array.insert(40);
//        array.insert(50);
//        array.removeAt(4);
//        array.print();
//        System.out.println(array.indexOf(40));
//        System.out.println(array.max());
//
//        Array array2 = new Array(4);
//        array2.insert(10);
//        array2.insert(10);
//        array2.insert(20);
//        array2.insert(30);
//        array2.insert(40);
//        array2.insert(50);
//        Array intersection = array.intersect(array2);
//        intersection.print();
//
//        array2.reverse();
//        array2.print();
//
//        array2.insertAt(90, 0);
//        array2.print();

        LinkedList list = new LinkedList();
        list.addFirst(10);
//        list.print();
        list.addLast(20);
        list.addLast(30);
        list.addFirst(0);
        list.addLast(40);
//        list.print();
        list.deleteFirst();
//        list.print();
        list.deleteLast();
//        System.out.println(list.contains(20));
//        System.out.println(list.contains(30));
//        list.print();

//        System.out.println(list.indexOf(10));
//        System.out.println(list.indexOf(20));
//        System.out.println(list.indexOf(30));

//        System.out.println(list.contains(20));

        int[] array = list.toArray();
//        System.out.println(Arrays.toString(array));

        list.reverse();
//        list.print();

        list.addFirst(9);
        list.addLast(99);
        list.addLast(999);

//        System.out.println(list.getKthFromTheEnd(2));

//        list.print();
//        list.printMiddle();

//        System.out.println(list.hasLoop());

        String a = "abcdef";
        StringReverser s = new StringReverser();
        System.out.println(s.reverse(a));
    }

}
