package ting.leetcode.java.binarytree;

import java.util.LinkedList;

public class SerializeAndDeserializeBinaryTreePreOrder {
    private static final String SEPERATOR = ",";
    private static final String NULL = "#";
    private final StringBuilder stringBuilder = new StringBuilder();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        _serialize(root);
        return stringBuilder.toString();
    }

    private void _serialize(TreeNode root) {
        if (root == null) {
            stringBuilder.append(NULL).append(SEPERATOR);
            return;
        }

        stringBuilder.append(root.val).append(SEPERATOR);
        _serialize(root.left);
        _serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEPERATOR)) {
            nodes.addLast(s);
        }
        return _deserialize(nodes);
    }

    private TreeNode _deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty())
            return null;

        String first = nodes.removeFirst();
        if (first.equals(NULL))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = _deserialize(nodes);
        root.right = _deserialize(nodes);

        return root;
    }
}

class SerializeAndDeserializeBinaryTreePostOrder {
    private static final String SEPERATOR = ",";
    private static final String NULL = "#";
    private final StringBuilder stringBuilder = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        _serialize(root);
        return stringBuilder.toString();
    }

    public void  _serialize(TreeNode root) {
        if (root == null) {
            stringBuilder.append(NULL).append(SEPERATOR);
            return;
        }

        _serialize(root.left);
        _serialize(root.right);

        stringBuilder.append(root.val).append(SEPERATOR);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEPERATOR)) {
            nodes.addLast(s);
        }
        return _deserialize(nodes);
    }

    private TreeNode _deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty())
            return null;

        String first = nodes.removeLast();
        if (first.equals(NULL))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.right = _deserialize(nodes);
        root.left = _deserialize(nodes);

        return root;
    }
}
