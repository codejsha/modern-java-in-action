package com.example.demo.chapter19.tree;

public class PersistentTree {
    /**
     * Lookup the value of a key in a tree.
     *
     * @param k            the key to lookup
     * @param defaultValue the default value
     * @param tree         node of the tree
     * @return the value of the key if found, otherwise the default value
     */
    public static int lookup(String k, int defaultValue, Tree tree) {
        if (tree == null) {
            return defaultValue;
        }
        if (k.equals(tree.key)) {
            return tree.value;
        }
        return lookup(k, defaultValue, k.compareTo(tree.key) < 0 ? tree.left : tree.right);
    }

    /**
     * Update the value of a key in a tree.
     *
     * @param key      the key to update
     * @param newValue the new value
     * @param tree     node of the tree
     * @return the updated tree
     */
    public static Tree update(String key, int newValue, Tree tree) {
        if (tree == null) {
            tree = new Tree(key, newValue, null, null);
        } else if (key.equals(tree.key)) {
            tree.value = newValue;
        } else if (key.compareTo(tree.key) < 0) {
            tree.left = update(key, newValue, tree.left);
        } else {
            tree.right = update(key, newValue, tree.right);
        }
        return tree;
    }

    /**
     * Lookup the value of a key in a tree. This use the functional approach.
     *
     * @param key      the key to update
     * @param newValue the new value
     * @param tree     node of the tree
     * @return the updated tree
     */
    public static Tree updateFunctionApproach(String key, int newValue, Tree tree) {
        return (tree == null) ?
                new Tree(key, newValue, null, null) :
                key.equals(tree.key) ?
                        new Tree(key, newValue, tree.left, tree.right) :
                        key.compareTo(tree.key) < 0 ?
                                new Tree(tree.key, tree.value,
                                        updateFunctionApproach(key, newValue, tree.left), tree.right) :
                                new Tree(tree.key, tree.value,
                                        tree.left, updateFunctionApproach(key, newValue, tree.right));
    }

    /**
     * Lookup the value of a key in a tree. This use the functional approach.
     *
     * @param key      the key to update
     * @param newValue the new value
     * @param tree     node of the tree
     * @return the updated tree
     */
    public static Tree updateFunctionApproach2(String key, int newValue, Tree tree) {
        if (tree == null) {
            return new Tree(key, newValue, null, null);
        } else if (key.equals(tree.key)) {
            return new Tree(key, newValue, tree.left, tree.right);
        } else if (key.compareTo(tree.key) < 0) {
            final var updatedLeft = updateFunctionApproach2(key, newValue, tree.left);
            return new Tree(tree.key, tree.value, updatedLeft, tree.right);
        } else {
            final var updatedRight = updateFunctionApproach2(key, newValue, tree.right);
            return new Tree(tree.key, tree.value, tree.left, updatedRight);
        }
    }

    /**
     * A tree node.
     */
    public static class Tree {
        private final String key;
        private int value;
        private Tree left, right;

        public Tree(String k, int v, Tree l, Tree r) {
            key = k;
            value = v;
            left = l;
            right = r;
        }
    }
}
