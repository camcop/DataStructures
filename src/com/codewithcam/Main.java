package com.codewithcam;

import java.util.Queue;

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
//        Array array2 = new Array(4);
//        array2.insert(10);
//        array2.insert(10);
//        array2.insert(20);
//        array2.insert(30);
//        array2.insert(40);
//        array2.insert(50);
//        Array intersection = array.intersect(array2);
//        intersection.print();
//        array2.reverse();
//        array2.print();
//        array2.insertAt(90, 0);
//        array2.print();

//        LinkedList list = new LinkedList();
//        list.addFirst(10);
//        list.print();
//        list.addLast(20);
//        list.addLast(30);
//        list.addFirst(0);
//        list.addLast(40);
//        list.print();
//        list.deleteFirst();
//        list.print();
//        list.deleteLast();
//        System.out.println(list.contains(20));
//        System.out.println(list.contains(30));
//        list.print();
//        System.out.println(list.indexOf(10));
//        System.out.println(list.indexOf(20));
//        System.out.println(list.indexOf(30));
//        System.out.println(list.contains(20));
//        int[] array = list.toArray();
//        System.out.println(Arrays.toString(array));
//        list.reverse();
//        list.print();
//        list.addFirst(9);
//        list.addLast(99);
//        list.addLast(999);
//        System.out.println(list.getKthFromTheEnd(2));
//        list.print();
//        list.printMiddle();
//        System.out.println(list.hasLoop());

//        String a = "abcde";
//        StringReverser s = new StringReverser();
//        System.out.println(s.reverse(a));

//        BracketChecker bc = new BracketChecker();
//        String test = "((({}<>[])))()";
//        System.out.println(bc.check(test));

//        Stack stack = new Stack(4);
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.push(5);
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.peek());
//        System.out.println(stack.peek());
//        System.out.println(stack.toString());

//        Queue<Integer> queue = new ArrayDeque<>();
//        queue.add(10);
//        queue.add(20);
//        queue.add(30);
//        queue.add(40);
//        System.out.println(queue);
//        System.out.println(reverse(queue));

//        ArrayQueue queue = new ArrayQueue();
//        System.out.println(queue.isEmpty());
//        queue.enqueue(10);
//        System.out.println(queue.isEmpty());
//        queue.enqueue(20);
//        queue.enqueue(30);
//        queue.enqueue(40);
//        System.out.println(queue.isFull());
//        queue.enqueue(50);
//        System.out.println(queue.isFull());
//        System.out.println(queue.peek());
//        queue.dequeue();
//        queue.dequeue();
//        queue.dequeue();
//        queue.enqueue(60);
//        System.out.println(queue.peek());

//        StackQueue queue = new StackQueue();
//        queue.enqueue(10);
//        queue.enqueue(20);
//        queue.enqueue(30);
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        queue.enqueue(40);
//        queue.enqueue(50);
//        queue.enqueue(60);
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.peek());

//        PriorityQueue pq = new PriorityQueue();
//        pq.insert(1);
//        pq.insert(4);
//        pq.insert(4);
//        pq.insert(1);
//        pq.insert(3);
//        pq.insert(5);
//        pq.insert(2);
//        System.out.println(pq.remove());
//        System.out.println(pq.remove());
//        System.out.println(pq.remove());
//        System.out.println(pq.remove());
//        System.out.println(pq.remove());

//        System.out.println(queue);
//        ArrayQueue q = QueueReverser.reverse(queue, 3);
//        System.out.println(q);

//        StackWithTwoQueues stack = new StackWithTwoQueues();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.push(5);
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.peek());
//        System.out.println(stack.isEmpty());
//        System.out.println(stack.size());

//        System.out.println(CharFinder.findFirstNonRepeatingCharacter("a green apple"));
//        System.out.println(CharFinder.findFirstNonRepeatingCharacter("aabb"));
//        System.out.println(CharFinder.findFirstRepeatingCharacter("a green apple"));
//        System.out.println(CharFinder.findFirstRepeatingCharacter("abba"));

//        HashTable table = new HashTable();
//        table.put(1, "a green");
//        System.out.println(table.get(1));
//        table.put(2, "apple");
//        table.put(3, "tree");
//        table.put(9, "fruit");
//        table.put(1, "a blue");
//        table.put(5, "a blue");
//        table.put(6, "a blue");
//        table.put(7, "a blue");
//        System.out.println(table.get(1));
//        System.out.println(table.get(2));
//        System.out.println(table.get(3));
//        System.out.println(table.get(9));
//        table.remove(9);
//        table.remove(9);
//        System.out.println(table.get(9));

//        int[] array = new int[]{1, 2, 2, 3, 3, 3, 4};
//        System.out.println(HashTableExercises.mostFrequent(array));
//        int[] array2 = new int[]{1, 2, 2, 2, 3, 3, 3, 4};
//        System.out.println(HashTableExercises.mostFrequent(array2));

        int[] array = new int[]{1, 7, 5, 9, 2, 12, 3};
//        int[] array = new int[] {1, 7, 5, 9, 2, 12, 3, 6};
        System.out.println(HashTableExercises.countPairsWithDiff(array, 4));

    }


    public static Queue<Integer> reverse(Queue<Integer> queue) {

        Stack stack = new Stack();
        while (!queue.isEmpty())
            stack.push(queue.remove());

        while (!stack.isEmpty())
            queue.add(stack.pop());

        return queue;

    }


}
