package com.chris.tree;

import java.util.Random;

/**
 * @author 史偕成
 * @date 2023/09/18 15:43
 **/
public class Case {

    private static final int arr[] = {1, 5, 4, 3, 2, 6};

    public static void main(String[] args) {
//        BSTreeTest();
        AVLTreeTest();
    }

    /**
     * BStree 测试代码
     */
    public static void BSTreeTest() {
        int i, ilen;
        BSTree<Integer> tree = new BSTree<>();
        for (int j = 0; j < 50; j++) {
            Random random = new Random();
            tree.insert(random.nextInt(100) + 1);
        }
//        System.out.print("== 依次添加: ");
//        ilen = arr.length;
//        for (i = 0; i < ilen; i++) {
//            System.out.print(arr[i] + " ");
//            tree.insert(arr[i]);
//        }

        System.out.print("\n== 前序遍历: ");
        tree.preOrder();

        System.out.print("\n== 中序遍历: ");
        tree.inOrder();

        System.out.print("\n== 后序遍历: ");
        tree.postOrder();
        System.out.println();

        long start = System.currentTimeMillis();
        System.out.println(start);
//        tree.search(10000, 1);
        System.out.println("迭代器模式耗时：" + (System.currentTimeMillis() - start) + "毫秒");

        start = System.currentTimeMillis();
        System.out.println(start);
//        tree.search(10000, 2);
        System.out.println("递归模式耗时：" + (System.currentTimeMillis() - start) + "毫秒");

        System.out.println("最小值:" + tree.searchBySize(1));
        System.out.println("最大值:" + tree.searchBySize(0));

        System.out.println("前驱:" + tree.predecessor(tree.mRoot));
        System.out.println("后继:" + tree.successor(tree.mRoot));

//        System.out.println("删除节点：" + tree.search(70, 1));
//        tree.remove(3);

        tree.print();

        tree.clear();

        tree.print();
    }

    public static void AVLTreeTest() {
        int i;
        AVLTree<Integer> tree = new AVLTree<Integer>();

        System.out.printf("== 依次添加: ");
        for (i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
            tree.insert(arr[i]);
        }

        System.out.printf("\n== 前序遍历: ");
        tree.preOrder();

        System.out.printf("\n== 中序遍历: ");
        tree.inOrder();

        System.out.printf("\n== 后序遍历: ");
        tree.postOrder();
        System.out.printf("\n");

        System.out.printf("== 高度: %d\n", tree.height());
        System.out.printf("== 最小值: %d\n", tree.minimum());
        System.out.printf("== 最大值: %d\n", tree.maximum());
        System.out.printf("== 树的详细信息: \n");
        tree.print();

        i = 8;
        System.out.printf("\n== 删除根节点: %d", i);
        tree.remove(i);

        System.out.printf("\n== 高度: %d", tree.height());
        System.out.printf("\n== 中序遍历: ");
        tree.inOrder();
        System.out.printf("\n== 树的详细信息: \n");
        tree.print();

        // 销毁二叉树
        tree.destroy();
    }
}
