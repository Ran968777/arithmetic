package tree;

/**
 * @author Ran
 * @date 2021-07-21 9:26
 */
public interface Tree<T extends Comparable> {

    /**
     * 二叉树节点的高度
     *
     * @return
     */
    int height();

    /**
     * 插入
     */
    void insert();

    /**
     * 删除
     */
    void remove();
}
