public class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList(Node head){
        this.head = head;
        tail = head;
    }

    public Node head() {
        return head;
    }

    public void add(Node node){
        tail.next = node;
        tail = node;
    }

    public static class Node {

        private Node next;
        private String data;

        public Node(String data){
            this.data = data;
        }

        public void setData(String data){
            this.data = data;
        }

        public Node next(){
            return next;
        }

        public void setNext(Node next){
            this.next = next;
        }

        public String toString(){
            return this.data;
        }
    }
}


