package com.design.patterns.rk.Composite;

import java.util.Iterator;

/**
 * Created by renkai on 2017/3/21.
 */
public class Client {
    public static void main(String[] args) {
        Tree a = new Tree("a");
        TreeNode b = new TreeNode("b");
        TreeNode c = new TreeNode("c");
        a.root.add(b);
        b.add(c);
        iterator(a.root);
    }

    public static void iterator(TreeNode root){
        Iterator<TreeNode> iterator = root.getChildren().iterator();
        while (iterator.hasNext()){
            TreeNode next = iterator.next();
            System.out.println(root.getName() + "-->" + next.getName());
            iterator(next);
        }
    }
}
