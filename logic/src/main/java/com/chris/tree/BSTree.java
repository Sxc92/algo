package com.chris.tree;

/**
 * 二叉搜索树
 *
 * @author 史偕成
 * @date 2023/09/18 15:36
 **/
public class BSTree<T extends Comparable<T>> {
    /**
     * 根节点
     */
    Node<T> mRoot;


    public void preOrder() {
        preOrder(mRoot);
    }

    /****************遍历树************************/
    /**
     * 前序遍历
     *
     * @param tree
     */
    private void preOrder(Node<T> tree) {
        if (tree != null) {
            System.out.println(tree.key + " ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    private void inOrder(Node<T> node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.key + " ");
            inOrder(node.right);
        }
    }

    public void inOrder() {
        inOrder(mRoot);
    }


    private void postOrder(Node<T> node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key + " ");
        }
    }

    public void postOrder() {
        postOrder(mRoot);
    }

    /****************树查找************************/

    /**
     * 递归版本搜索树
     *
     * @param node
     * @param key
     * @return
     */
    private Node<T> recursionSearch(Node<T> node, T key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return recursionSearch(node.left, key);
        } else if (cmp > 0) {
            return recursionSearch(node.right, key);
        } else {
            return node;
        }
    }

    private Node<T> iterativeSearch(Node<T> node, T key) {
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }

    /**
     * 搜索
     *
     * @param key  关键词
     * @param mode 2： 递归搜索模式、1：迭代去搜索模式
     * @return
     */
    public T search(T key, int mode) {
        return switch (mode) {
            case 1 -> iterativeSearch(mRoot, key).key;
            case 2 -> recursionSearch(mRoot, key).key;
            default -> null;
        };
    }

    /****************查找最大最小节点************************/

    /**
     * 查找结点: 返回tree为根结点的二叉树的结点。
     *
     * @param tree 树
     * @param flag 0：最大值、1：最小值
     * @return
     */
    private Node<T> searchBySize(Node<T> tree, int flag) {
        if (tree == null) {
            return null;
        }
        switch (flag) {
            case 0 -> {
                while (tree.right != null) {
                    tree = tree.right;
                }
                return tree;
            }
            case 1 -> {
                while (tree.left != null) {
                    tree = tree.left;
                }
                return tree;
            }
            default -> {
                return null;
            }
        }
    }

    public T searchBySize(int flag) {
        Node<T> p = searchBySize(mRoot, flag);
        if (p != null) {
            return p.key;
        }
        return null;
    }


    /**
     * 前驱 是该节点的左子树中的最大节点
     *
     * @param node
     * @return
     */
    public Node<T> predecessor(Node<T> node) {
        // 如果x存在左树，则"x的前驱结点"为 "以其左孩子为根的子树的最大结点"。
        if (node.left != null) {
            return searchBySize(node.left, 0);
        }

        // 如果x没有左孩子。则x有以下两种可能:
        // (01) x是"一个右孩子"，则"x的前驱结点"为 "它的父结点"。
        // (01) x是"一个左孩子"，则查找"x的最低的父结点，并且该父结点要具有右孩子"，找到的这个"最低的父结点"就是"x的前驱结点"。
        Node<T> y = node.parent;
        while ((y != null) && (node == y.left)) {
            node = y;
            y = y.parent;
        }
        if (y == null) {
            throw new IllegalArgumentException("异常");
        }
        return y;
    }

    public Node<T> successor(Node<T> node) {
        // 如果x存在右孩子，则"x的后继结点"为 "以其右孩子为根的子树的最小结点"。
        if (node.right != null) {
            return searchBySize(node.right, 1);
        }

        // 如果x没有右孩子。则x有以下两种可能:
        // (01) x是"一个左孩子"，则"x的后继结点"为 "它的父结点"。
        // (02) x是"一个右孩子"，则查找"x的最低的父结点，并且该父结点要具有左孩子"，找到的这个"最低的父结点"就是"x的后继结点"。
        Node<T> y = node.parent;
        while ((y != null) && (node == y.right)) {
            node = y;
            y = y.parent;
        }
        if (y == null) {
            throw new IllegalArgumentException("异常");
        }
        return y;
    }


    /****************插入节点************************/

    /**
     * @param tree       当前树
     * @param insertNode 需要插入的节点
     */
    private void insert(BSTree<T> tree, Node<T> insertNode) {
        int cmp;
        Node<T> y = null;
        Node<T> x = mRoot;
        while (x != null) {
            y = x;
            cmp = insertNode.key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        insertNode.parent = y;
        if (y == null) {
            tree.mRoot = insertNode;
        } else {
            cmp = insertNode.key.compareTo(y.key);
            if (cmp < 0) {
                y.left = insertNode;
            } else {
                y.right = insertNode;
            }
        }
    }


    /**
     * 新建结点(key)，并将其插入到二叉树中
     * <p>
     * 参数说明:
     * tree 二叉树的根结点
     * key 插入结点的键值
     */
    public void insert(T key) {
        Node<T> z = new Node<T>(key, null, null, null);
        // 则返回。
        insert(this, z);
    }


    /********************删除节点**************************/
    private Node<T> remove(BSTree<T> tree, Node<T> node) {
        Node<T> x = null;
        Node<T> y = null;
        if (node.left == null || node.right == null) {
            y = node;
        } else {
            y = successor(node);
        }
        if (y.left != null) {
            x = y.left;
        } else {
            x = y.right;
        }
        if (x != null) {
            x.parent = y.parent;
        }
        if (y.parent == null) {
            tree.mRoot = x;
        } else if (y == y.parent.left) {
            y.parent.left = x;
        } else {
            y.parent.right = x;
        }
        if (y != node) {
            node.key = y.key;
        }
        return y;
    }

    public void remove(T key) {
        Node<T> z, node;
        if ((z = iterativeSearch(mRoot, key)) != null) {
            node = remove(this, z);
            node = null;
        }
    }


    /*
     * 打印"二叉查找树"
     *
     * key        -- 节点的键值
     * direction  --  0，表示该节点是根节点;
     *               -1，表示该节点是它的父结点的左孩子;
     *                1，表示该节点是它的父结点的右孩子。
     */
    private void print(Node<T> tree, T key, int direction) {

        if (tree != null) {
// tree是根节点
            if (direction == 0) {
                System.out.printf("%2d is root\n", tree.key);
            } else                // tree是分支节点
            {
                System.out.printf("%2d is %2d's %6s child\n", tree.key, key, direction == 1 ? "right" : "left");
            }

            print(tree.left, tree.key, -1);
            print(tree.right, tree.key, 1);
        }
    }


    /*
     * 销毁二叉树
     */
    private void destroy(Node<T> tree) {
        if (tree == null)
            return;

        if (tree.left != null)
            destroy(tree.left);
        if (tree.right != null)
            destroy(tree.right);

        tree = null;
    }

    public void clear() {
        destroy(mRoot);
        mRoot = null;
    }

    public void print() {
        if (mRoot != null) {
            print(mRoot, mRoot.key, 0);
        }
    }

    /**
     * 节点定义
     *
     * @param <T>
     */
    private static class Node<T extends Comparable<T>> {
        /**
         * 关键词
         */
        T key;

        /**
         * 左子树
         */
        Node<T> left;
        /**
         * 右子树
         */
        Node<T> right;

        /**
         * 父节点
         */
        Node<T> parent;

        public Node(T key, Node<T> left, Node<T> right, Node<T> parent) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }
}
