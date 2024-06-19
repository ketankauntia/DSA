// Predecessor And Successor In BST
// Easy
// Score:
// 80/80
// Average time to solve is 20m
// Asked in companies
// AdobeD.E.Shaw
// Problem statement

// Send feedback
// You have been given a binary search tree of integers with ‘N’ nodes. You are also given 'KEY' which represents data of a node of this tree.



// Your task is to return the predecessor and successor of the given node in the BST.



// Note:
// 1. The predecessor of a node in BST is that node that will be visited just before the given node in the inorder traversal of the tree. If the given node is visited first in the inorder traversal, then its predecessor is NULL.

// 2. The successor of a node in BST is that node that will be visited immediately after the given node in the inorder traversal of the tree. If the given node is visited last in the inorder traversal, then its successor is NULL.

// 3. The node for which predecessor and successor are to be found will always be present in the given tree.

// 4. A binary search tree (BST) is a binary tree data structure which has the following properties.
//      • The left subtree of a node contains only nodes with data less than the node’s data.
//      • The right subtree of a node contains only nodes with data greater than the node’s data.
//      • Both the left and right subtrees must also be binary search trees.


// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1:
// 15 10 20 8 12 16 25 -1 -1 -1 -1 -1 -1 -1 -1
// 10
// Sample output 1:
// 8 12
// Explanation of Sample output 1:
// The tree can be represented as follows:
// Example

// The inorder traversal of this tree will be 8 10 12 15 16 20 25.

// Since the node with data 8 is on the immediate left of the node with data 10 in the inorder traversal, the node with data 8 is the predecessor.

// Since the node with data 12 is on the immediate right of the node with data 10 in the inorder traversal, the node with data 12 is the successor.
// Sample Input 2:
// 10 5 -1 -1 -1
// 5
// Sample output 2:
// -1 10
// Constraint :
// 1 <= N <= 10^4
// 1 <= data <= 10^7

// Time Limit: 1 sec

/*************************************************************

    Following is the Binary Tree node structure
    class TreeNode
    {
    public:
        int data;
        TreeNode *left, *right;
        TreeNode() : data(0), left(NULL), right(NULL) {}
        TreeNode(int x) : data(x), left(NULL), right(NULL) {}
        TreeNode(int x, TreeNode *left, TreeNode *right) : data(x), left(left), right(right) {}
    };

*************************************************************/

// CN's code 

pair<int, int> predecessorSuccessor(TreeNode *root, int key)
{
    int predecessor = -1;
    int successor = -1;

    // Initializing temporary node with head.
    TreeNode *temp = root;

    // Traversing in tree to find the predecessor.
    while (temp != NULL)
    {
        if (key > temp->data)
        {
            // Updating predecessor.
            predecessor = temp->data;
            temp = temp->right;
        }
        else
        {
            temp = temp->left;
        }
    }

    temp = root;

    // Traversing in tree to find the successor.
    while (temp != NULL)
    {
        if (key >= temp->data)
        {
            temp = temp->right;
        }
        else
        {
            // Updating successor.
            successor = temp->data;
            temp = temp->left;
        }
    }

    return make_pair(predecessor, successor);
}


// other code

// pair<int, int> predecessorSuccessor(TreeNode *root, int key)
// {
//     int predecessor = -1;
//     int successor = -1;

//     TreeNode *temp = root;

//     while (temp != NULL)
//     {
//         if (key == temp->data)
//         {
//             // If the key is found, find predecessor and successor in its subtrees.

//             // Finding predecessor: max value in the left subtree.
//             if (temp->left != NULL)
//             {
//                 TreeNode *leftTree = temp->left;
//                 while (leftTree->right != NULL)
//                 {
//                     leftTree = leftTree->right;
//                 }
//                 predecessor = leftTree->data;
//             }

//             // Finding successor: min value in the right subtree.
//             if (temp->right != NULL)
//             {
//                 TreeNode *rightTree = temp->right;
//                 while (rightTree->left != NULL)
//                 {
//                     rightTree = rightTree->left;
//                 }
//                 successor = rightTree->data;
//             }
//             break;
//         }
//         else if (key < temp->data)
//         {
//             // Update successor and move to the left subtree.
//             successor = temp->data;
//             temp = temp->left;
//         }
//         else
//         {
//             // Update predecessor and move to the right subtree.
//             predecessor = temp->data;
//             temp = temp->right;
//         }
//     }

//     return make_pair(predecessor, successor);
// }
