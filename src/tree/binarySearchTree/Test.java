package tree.binarySearchTree;

/**
 * @description:
 * @author: jibingbing
 * @create: 2018/03/22
 **/
public class Test {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(4);
        bst.insert(8);
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(6);
        bst.remove(2);
        bst.printTree();
    }
}
