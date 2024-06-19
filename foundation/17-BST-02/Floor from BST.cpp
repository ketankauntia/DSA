//  Floor from BST
// Easy
// Score:
// 80/80
// Average time to solve is 20m
// Problem statement

// Send feedback
// Given a binary search tree and an integer.Find the floor value of a key in a binary search tree .

// (If k lies in BST then is floor equal to k,else floor is equal to previous greater value) Note: k would never be less than the minimum element of tree.
// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1:
// 4
// 8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
// Sample Output 1:
// 2
// Sample Input 2:
// 7
// 8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
// Sample Output 2:
// 6

int Floor(BinaryTreeNode<int> *node, int input) {
    // Base case: if the node is null, return -1 indicating no floor value found
    if (!node) {
        return -1;
    }

    // If the current node's value is equal to the input value, it is the floor value
    if (node->data == input) {
        return node->data;
    }
    // If the current node's value is greater than the input value, search in the left subtree
    else if (node->data > input) {
        return Floor(node->left, input);
    }
    // If the current node's value is less than the input value, we have a potential floor value
    // We continue searching in the right subtree to see if we can find a greater value
    else {
        int floorValue = Floor(node->right, input);
        // If a floor value is found in the right subtree, return it
        // Otherwise, the current node's value is the floor value
        return (floorValue != -1) ? floorValue : node->data;
    }
}
