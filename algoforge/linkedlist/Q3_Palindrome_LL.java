package algoforge.linkedlist;
// https://leetcode.com/problems/palindrome-linked-list/
// LC 234

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class ListNode {
    int val;
    ListNode next;
};

class Solution{
    
    public ListNode getMiddleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseLL(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;

    while (curr != null) {
        ListNode next = curr.next;  // Saveing next node
        curr.next = prev;           // Reversing the link
        prev = curr;                // Moving prev forward
        curr = next;                // Moving curr forward
    }

    return prev;
}

    public boolean isPalindrome(ListNode head){

        //finding mid
        ListNode mid = getMiddleNode(head);

        //breaking into 2 ll around mid
        ListNode secHead = mid.next;
        mid.next=null;

        //reverse second half
        secHead = reverseLL(secHead);

        //compare both LL
        ListNode ptr1 = mid;
        ListNode ptr2 = secHead;
        boolean ans = true;

        while(ptr1!=null && ptr2!=null){
            if(ptr1.val!=ptr2.val){
                // return false; 
                ans = false;
                break;
            }
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        
        //reverse again , join both ( coz we need to keep the input as it is.)
        secHead = reverseLL(secHead);
        mid.next = secHead;

        return ans;

    }

}

// My solution : 1 full pass.
// class Solution {
// public:
//     bool isPalindrome(ListNode* head) {
        
//         // will store the first half via slow & fast pointer
//         vector<int> arr;
//         ListNode *slow = head;
//         ListNode *fast = head;
//         while(fast!=NULL && fast->next!=NULL){
//             arr.push_back(slow->val);
//             slow=slow->next;
//             fast = fast->next->next;
//         }
//         // 2nd part se we match from back of arr
//         if(fast!=NULL){
//             slow = slow->next;
//         }
//         int len = arr.size()-1;
//         while(slow!=NULL){
//             if(slow->val != arr[len--]){
//                 return false;
//             }
//             slow=slow->next;
//         }
//         return true;
//     }
// };