package com.design.patterns.rk.Composite;

/**
 * Created by renkai on 2017/3/21.
 */
public class Tree {
    TreeNode root = null;

    public Tree(String name) {
        root = new TreeNode(name);
    }
}
