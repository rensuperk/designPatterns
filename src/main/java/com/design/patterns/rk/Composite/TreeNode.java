package com.design.patterns.rk.Composite;

import java.util.Vector;

/**
 * Created by renkai on 2017/3/21.
 */
public class TreeNode {
    private String name;
    private TreeNode parent;
    private Vector<TreeNode> children = new Vector<TreeNode>();

    public TreeNode(String name) {
        this.name = name;
    }

    public void add(TreeNode treeNode){
        children.add(treeNode);
    }
    public void remove(TreeNode treeNode){
        children.remove(treeNode);
    }
    public String getName() {
        return name;
    }

    public TreeNode setName(String name) {
        this.name = name;
        return this;
    }

    public TreeNode getParent() {
        return parent;
    }

    public TreeNode setParent(TreeNode parent) {
        this.parent = parent;
        return this;
    }

    public Vector<TreeNode> getChildren() {
        return children;
    }

    public TreeNode setChildren(Vector<TreeNode> children) {
        this.children = children;
        return this;
    }
}
