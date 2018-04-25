public class MyUnrolledLinkedList {
    private UNode head;
    private UNode tail;
    private int index;

    public MyUnrolledLinkedList(UNode node){
            this.head = node;
            this.tail = head;
            index = 0;
    }


    public void add(UNode node){
        tail.next = node;
        this.tail = node;
    }

    public void addInt(int n){
        UNode node = head; // head cant be null as we create it from the constructor
        while(!node.add(n)){ // add method of node will return true if it add the value to the array else false
            UNode tempNode = node.next();
            if(tempNode == null){
                tempNode = new UNode();
                this.add(tempNode);
            }
            node = tempNode;

        }
        index += 1;
    }

    public int index() {
        return index;
    }

    public void addIntInIndex(int n, int pos){
        if(pos>index || pos <= 0){
            System.out.println("position to insert the value is more than current index");
        }else{
            UNode node = head;
            while(!node.addIndex(n,pos)){
                pos = pos - 5;
                UNode tempNode = node.next();
                if(tempNode == null){
                    tempNode = new UNode();
                    this.add(tempNode);
                }
                node = tempNode;
            }

        }
    }

    public int getValueAtIndex(int pos){
        if(pos > index || pos <= 0){
            return 0;
        }else{
            UNode node = head;
            while(pos > node.getLen()){
                pos = pos-5;
                node = node.next();
            }

            return node.getArr()[pos-1];
        }
    }


    public UNode head() {
        return head;
    }

    public UNode tail() {
        return tail;
    }

    public static class UNode{
        int[] arr = new int[5];
        int len = 0;
        UNode next;

        public UNode(){
        }

        public UNode next(){
            return next;
        }

        public  void setNext(UNode next){
            this.next = next;
        }

        public int getLen() {
            return len;
        }

        public void setLen(int len) {
            this.len = len;
        }

        public int[] getArr() {
            return arr;
        }



        public boolean add(int n){
            if(len == 5 || n <=0){
                return false;
            }else{
                arr[len] = n;
                len += 1;
                return true;
            }
        }

        public boolean addIndex(int n, int i){
            if(i > 5 || i <=0){
                return false;
            }else{
                if(i< len){
                    arr[i-1] = n;
                }else if (i == len+1){ // adding to the end of the array
                    arr[i-1] = n;
                    len += 1;
                }
                return true;
            }
        }

        @Override
        public String toString() {
            String output = "";
            for(int i=0; i<len; i++ ) {
                output = output + " ["+ arr[i]+"]";
            }
            return "Array is" + output +" with length of ["+len+"]";

        }
    }
}
