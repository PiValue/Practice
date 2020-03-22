package offerup;

import java.util.LinkedList;
import java.util.Queue;

public class Q116RightSibling {
    public SiblingNode convert(SiblingNode root) {
        if (root == null) return root;

        Queue<SiblingNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);    // Marker.

        while (!queue.isEmpty()) {
            SiblingNode node = queue.remove();
            if (node == null) {
                // Hit a marker.
                if (!queue.isEmpty()) queue.add(null);  // Mark end of a level.
                continue;
            }

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);

            node.next = queue.peek();
        }
        return root;

    }

    private class SiblingNode {
        private int val;
        private SiblingNode left, right, next;
    }
}
