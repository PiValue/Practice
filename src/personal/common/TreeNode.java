package personal.common;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TreeNode {
    private int val;
    private TreeNode left, right;
}
