package ting.leetcode.java.binarytree;

import java.util.LinkedList;

public class VerifyPreorderSerializationOfABinaryTree {
    public boolean isValidSerialization(String preorder) {
        int edge = 1;
        for (String node : preorder.split(",")) {
            if (node.equals("#")) {
                edge--;
                if (edge < 0) {
                    return false;
                }
            } else {
                edge--;
                if (edge < 0) {
                    return false;
                }
                edge += 2;
            }
        }

        return edge == 0;
    }


    public boolean isValidSerialization2(String preorder) {
        var nodes = new LinkedList<String>();
        for (String s : preorder.split(",")) {
            nodes.addLast(s);
        }
        return deserialize(nodes) && nodes.isEmpty();
    }

    private boolean deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty())
            return false;

        String head = nodes.removeFirst();
        if (head.equals("#"))
            return true;

        return deserialize(nodes) && deserialize(nodes);
    }
}
