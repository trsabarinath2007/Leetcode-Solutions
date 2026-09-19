import java.util.*;

public class Codec {

    // Serialize
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeTree(root, sb);
        return sb.toString();
    }

    private void serializeTree(TreeNode root, StringBuilder sb) {

        if (root == null) {
            sb.append("null,");
            return;
        }

        sb.append(root.val).append(",");

        serializeTree(root.left, sb);
        serializeTree(root.right, sb);
    }

    // Deserialize
    public TreeNode deserialize(String data) {

        String[] arr = data.split(",");
        int[] index = {0};

        return buildTree(arr, index);
    }

    private TreeNode buildTree(String[] arr, int[] index) {

        if (arr[index[0]].equals("null")) {
            index[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[index[0]]));

        index[0]++;

        root.left = buildTree(arr, index);
        root.right = buildTree(arr, index);

        return root;
    }
}