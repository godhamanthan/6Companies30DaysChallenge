public class Solution {
    private class Info {
        public int rob;
        public int norob;
        public Info(int rob, int norob) {
            this.rob = rob;
            this.norob = norob;
        }
    }
    public int rob(TreeNode root) {
        Info info = dfs(root);
        return Math.max(info.rob, info.norob);
    }
    private Info dfs(TreeNode node) {
        if (node == null) {
            return new Info(0, 0);
        }
        Info left = dfs(node.left);
        Info right = dfs(node.right);
        Info result = new Info(left.norob + right.norob + node.val, Math.max(left.rob, left.norob) + Math.max(right.rob, right.norob));
        return result;
    }
}
