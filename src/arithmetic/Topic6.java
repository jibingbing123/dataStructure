package arithmetic;

/**
 * @description: 反向打印链表
 * @author: jibingbing
 * @create: 2018/04/03
 **/
public class Topic6 {

    class Node{

        private int value;
        private Node next;

        public Node(){
            value = 0;
        }

        public Node(int value){
            this.value = value;
        }
    }

    /**
     * 递归方法
     * @param head
     */
    public void printReverse(Node head){
        if(head != null) {

            if (head.next != null) {
                printReverse(head.next);
            }
            System.out.print(head.value + " ");
        }

    }

    public static void main(String[] args) {
        Topic6 t = new Topic6();
        Topic6.Node head = t.new Node();
        Topic6.Node node1 = t.new Node(3);
        Topic6.Node node2 = t.new Node(8);
        Topic6.Node node3 = t.new Node(6);
        Topic6.Node node4 = t.new Node(9);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        t.printReverse(head);
    }
}
