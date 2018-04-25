

public class LinkedListImplTest {

    public static void main(String args[]){






        LinkedList linkedList = new LinkedList(new LinkedList.Node("head"));
        LinkedList.Node head = linkedList.head();
        linkedList.add(new LinkedList.Node("1"));
        linkedList.add(new LinkedList.Node("2"));
        linkedList.add(new LinkedList.Node("3"));
        linkedList.add(new LinkedList.Node("4"));
        linkedList.add(new LinkedList.Node("5"));
        linkedList.add(new LinkedList.Node("6"));

    System.out.println(linkedList.head().next());

        LinkedList.Node current = head;
        int length = 0;
        LinkedList.Node middle = head;

        int i = 1;
        while(current.next() != null){
            length++;
            i++;
            if(i == 3){
                i=1;
                middle = middle.next();
            }
            current = current.next();

        }
        if(i<3){
            middle = middle.next();
        }

        System.out.println("length of LinkedList: " + length);
        System.out.println("middle element of LinkedList : " + middle);

        /*
        // find the middle
        while(current.next() != null){
            length++;
            if(length%2 == 0){
                middle = middle.next();
            }
            current = current.next();
        }

        if(length%2 == 1){
            middle = middle.next();
        }

        System.out.println("length of LinkedList: " + length);
        System.out.println("middle element of LinkedList : " + middle);


 /*
    System.out.println("I am done with linked list");
        MyUnrolledLinkedList.UNode uNode = new MyUnrolledLinkedList.UNode();
        MyUnrolledLinkedList myUnLinkedList = new MyUnrolledLinkedList(uNode);
        myUnLinkedList.addInt(1);
        myUnLinkedList.addInt(2);
        myUnLinkedList.addInt(3);
        myUnLinkedList.addInt(4);
        myUnLinkedList.addInt(5);
        myUnLinkedList.addInt(6);
        myUnLinkedList.addInt(7);
        myUnLinkedList.addInt(8);
        myUnLinkedList.addInt(9);

        myUnLinkedList.add(new MyUnrolledLinkedList.UNode());
        MyUnrolledLinkedList.UNode ua = myUnLinkedList.head();
        while(ua != null){
            System.out.println(ua);
            ua = ua.next();
        }
        myUnLinkedList.addInt(7);
        myUnLinkedList.addInt(8);
        myUnLinkedList.addInt(9);
        System.out.println(myUnLinkedList.index());

        ua = myUnLinkedList.head();
        while(ua != null){
            System.out.println(ua);
            ua = ua.next();
        }
        System.out.println("I am done with unrolled linked list add" +
                "");

        myUnLinkedList.addIntInIndex(3,2);
        myUnLinkedList.addIntInIndex(10,8);


        System.out.println(myUnLinkedList.index());

        ua = myUnLinkedList.head();
        while(ua != null){
            System.out.println(ua);
            ua = ua.next();
        }

        System.out.println(myUnLinkedList.getValueAtIndex(1));
        System.out.println(myUnLinkedList.getValueAtIndex(6));
        System.out.println(myUnLinkedList.getValueAtIndex(3));
        System.out.println(myUnLinkedList.getValueAtIndex(10));
*/
    }
}
