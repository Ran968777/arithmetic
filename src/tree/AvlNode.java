package tree;

/**
 * 平衡树
 *
 * @author Ran
 * @date 2021-07-21 9:28
 */
public class AvlNode<T extends Comparable> {

    public AvlNode<T> left;

    public AvlNode<T> right;

    public T data;

    public int height;

    public AvlNode() {
    }

    public AvlNode(T data) {
        this(null, null, data);
    }

    public AvlNode(AvlNode<T> left, AvlNode<T> right, T data) {
        this(left, right, data, 0);
    }

    public AvlNode(AvlNode<T> left, AvlNode<T> right, T data, int height) {
        this.left = left;
        this.right = right;
        this.data = data;
        this.height = height;
    }
}
