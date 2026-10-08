public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) {
            return "";
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {

            TreeNode node = q.poll();

            if (node == null) {
                sb.append("#,");
            } else {
                sb.append(node.val).append(",");

                q.offer(node.left);
                q.offer(node.right);
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == null || data.length() == 0) {
            return null;
        }

        String[] values = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;

        while (!q.isEmpty()) {

            TreeNode current = q.poll();

            // Left child
            if (!values[i].equals("#")) {
                current.left =
                    new TreeNode(Integer.parseInt(values[i]));

                q.offer(current.left);
            }

            i++;

            // Right child
            if (!values[i].equals("#")) {
                current.right =
                    new TreeNode(Integer.parseInt(values[i]));

                q.offer(current.right);
            }

            i++;
        }

        return root;
    }
}