package algoforge.linkedlist;

//  GFG questions have this node structure.
// struct Node {
//   int data;
//   struct Node *next;
//   Node(int x) {
//     data = x;
//     next = NULL;
//   }
// };

/*
// Function to find the data of kth node from the end of a linked list.
public class Q1_Solution {
  public:
    int getKthFromLast(Node *head, int k) {
        // Your code here
        Node* temp = head;
        int len =1;
        while(temp->next!=NULL){ // trying to count size
            len++;
            temp = temp->next;
        }
        
        if(k>len){    // If k is more than the number of nodes, then the output should be -1
            return -1;
        }
        
        // (count - k) +1/next node.
        // so we go to count-k th node and then read value of the next node.
        temp = head;
        int destinationNode = len-k+1 ;
        
        int count = 1;
        while(count < destinationNode){
            temp = temp->next;
            count++;
        }
        
        //next reached to 1 node before.
        //reading data of next node and returing it.
        int val = temp->data;
        return val;
    }
};
*/


// In one pass using slow and fast pointer with difference of k pos.
class Solution {
  public:
    int getKthFromLast(Node *head, int k) {
        // Your code here
        Node *slow = head;
        Node *fast = head;
        
        int count =0;
        while(count !=k){
            if(fast==NULL){
                return -1;
            }
            fast = fast->next;
            count++;
        }
        
        while(fast!=NULL){
            fast = fast->next;
            slow = slow->next;
        }
        return slow->data;
    }
};

