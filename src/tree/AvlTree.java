package tree;

/**
 * @author Ran
 * @date 2021-07-21 9:37
 */
public class AvlTree<T extends Comparable> implements Tree<T> {

    /**
     * The tree root.
     */
    public AvlNode<T> root;


    public boolean isEmpty() {
        return root == null;
    }


    public int size(AvlNode<T> subtree) {
        if (subtree == null) {
            return 0;
        } else {
            return size(subtree.left) + 1 + size(subtree.right);
        }


    }

    @Override
    public int height() {
        return height(root);
    }

    @Override
    public void insert() {

    }

    @Override
    public void remove() {
    }


    /**
     * @param p
     * @return
     */
    public int height(AvlNode<T> p) {
        return p == null ? -1 : p.height;
    }

}
