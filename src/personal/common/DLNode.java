package personal.common;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DLNode {
    private int value;
    private LNode next, prev;
}
