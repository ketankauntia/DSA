// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

// code isnt working on submit. need to get this checked.

public class Q26_Serialize_Deserialize_BT {
    
}

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        searlizer_helper(root, sb);
        return sb.toString();
    }

    public void searlizer_helper(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return;
        }

        sb.append(root.val+",");
        searlizer_helper(root.left, sb);
        searlizer_helper(root.right, sb);
    }

    static int idx = 0;
    public TreeNode deserialize_helper(String[] arr){

        if(idx>=arr.length || arr[idx].equals("null")){
            idx++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(arr[idx++]));
        node.left = deserialize_helper(arr);
        node.right = deserialize_helper(arr);

        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return deserialize_helper(arr);
    }
}