package tree.binarySearchTree;

/**
 * @description: 二叉查找树的实现
 * @author: jibingbing
 * @create: 2018/03/22
 **/
public class BinarySearchTree<T extends Comparable<? super T>> {

    //二叉树的数据结构
    private static class BinaryNode<T> {
        private T element;
        private BinaryNode<T> left;
        private BinaryNode<T> right;

        //根节点的构造器
        public BinaryNode(T element) {
            this.element = element;
        }

        //具有孩子节点的构造器
        public BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    private BinaryNode<T> root;

    //二叉查找树的构造器,初始化根节点root=null
    public BinarySearchTree() {
        root = null;
    }

    //将二叉查找树设为空树
    public void makeEmpty(){
        root = null;
    }

    //判断二叉树是否为空树
    public boolean isEmpty(){
        return root == null;
    }

    //判断树中是否有某个值x
    public boolean contains(T x,BinaryNode<T> root){
        if(root == null){
            return false;
        }
        //拿x与根节点中的元素比较
        int compareResult = x.compareTo(root.element);

        //如果比较结果小于0,说明x在root的左子树中,又在root.left这棵树中找x,可以使用递归调用
        if(compareResult < 0){
            return contains(x,root.left);
//        同样比较结果大于0,说明x在root的右子树
        } else if(compareResult > 0){
            return contains(x,root.right);
        } else {
            //如果找到了x,返回true
            return true;
        }
    }

    //找出树中最小的元素:要时刻记得二叉查找树的性质!
    //小的元素永远在左子树上,所以只要一直去找这个树的左子树,判断其根节点代表的元素有没有值
    //如果该节点不为空,但是它的左子树是空,说明已经找到最左边了,那么这个节点代表的元素也就是最小的了;
    //如果还有左子树,递归调用findMin,这是传入的值就是上一个节点的左孩子
    public T findMin(BinaryNode<T> root){
        if(root == null) return null;
        else if(root.left == null) return root.element;
        return findMin(root.left);
    }

    public void insert(T value){
        root = insert(value,root);
    }

    //找出树中最大的元素,同理找出最小的,这里使用非递归方法
    public T findMax(BinaryNode<T> root){
        if(root != null){
            while(root.right != null){
                root = root.right;
            }
            return root.element;
        }
        return null;
    }

    /**
     * 在树中插入一个节点
     * @param x
     * @param root
     * @return
     */
    private BinaryNode<T> insert(T x,BinaryNode<T> root){
        if(root == null){
            return new BinaryNode<T>(x,null,null);
        }
        int compareResult = x.compareTo(root.element);
        if(compareResult == 0){
            return null;
        } else if(compareResult < 0) {
            root.left = insert(x,root.left);
        } else if(compareResult > 0){
            root.right = insert(x,root.right);
        }
        return root;
    }

    public void remove(T value){
        root = remove(value,root);
    }

    private BinaryNode<T> remove(T x,BinaryNode<T> root){
        if(root == null){
            return null;
        }
        int compareResult = x.compareTo(root.element);
        if(compareResult < 0){
            root.left = remove(x,root.left);
        } else if(compareResult > 0) {
            root.right = remove(x,root.right);
        } else if(root.left != null && root.right != null){
            root.element = findMin(root.right);
            root.right = remove(root.element,root.right);
        } else {
            root = (root.left != null) ? root.left : root.right;
        }
        return root;
    }

    public void printTree(){
        printTree(root);
    }

    private void printTree(BinaryNode<T> root){
        if(root != null){

            System.out.print(root.element + " ");
            printTree(root.left);
            printTree(root.right);
        }
    }
}
