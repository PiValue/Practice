package personal.common;

import lombok.Builder;
import lombok.Data;

import java.util.Optional;

@Builder
@Data
public class LNode {
    private int value;
    private LNode next;

    /**
     * Static helper to build a singly linked list from given array of elements.
     */
    public static Optional<LNode> buildList(int[] elems) {
        if (elems == null || elems.length == 0) {
            return Optional.empty();
        }
        LNode head = new LNode(elems[0], null);
        LNode ptr = head;
        for (int idx = 1; idx < elems.length; idx++) {
            ptr.next = new LNode(elems[idx], null);
            ptr = ptr.next;
        }
        return Optional.of(head);
    }
}
