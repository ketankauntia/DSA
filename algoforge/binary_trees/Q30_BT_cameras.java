// https://leetcode.com/problems/binary-tree-cameras/ 

import javax.swing.tree.TreeNode;

public class Q30_BT_cameras {

    // 1 represents not covered by any camera
    // 0 means i am the camera node
    // -1 means i am covered by a camera already. i dont need.
    
    int camera;
    public int minCameraHelper(TreeNode root){
        if(root == null){
            return -1;
        }

        int leftNodeRequirement = minCameraHelper(root.left);
        int rightNodeRequirement = minCameraHelper(root.right);

        // left or right needs requirement
        if(leftNodeRequirement == 1 || rightNodeRequirement == 1){
            camera++;
            return 0;
        }

        // means i am covered. i dont need camera
        if(leftNodeRequirement == 0 || rightNodeRequirement == 0){
            return -1;
        }

        return 1;   // left adn right is covered but i am not
    }

    public int minCameraCover(TreeNode root) {
        camera = 0;

        int cameraReqByRoot = minCameraHelper(root);
        if(cameraReqByRoot == 1){
            camera+=1;
        }
        return camera;
    }
}
