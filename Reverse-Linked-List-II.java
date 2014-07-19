/**
 * Problem Statement: Reverse Linked List II 
 * https://oj.leetcode.com/problems/reverse-linked-list-ii/
 * 
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * 
 * Note:
 * Given m, n satisfy the following condition:
 * 1 = m = n = length of list.
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //special case
        if(head==null || head.next==null) return head;
        
        //create dummyHead
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        //digive the list into 3 segments: first part, reverse part, second part
        //reverseTail and firstTail
        ListNode reverseTail = dummyHead;
        ListNode firstTail = dummyHead;
        for(int i=0; i<m-1; i++){
            reverseTail = reverseTail.next;
        }
        firstTail = reverseTail;
        reverseTail = reverseTail.next;
        
        //reverse the list
        ListNode reverseHead = reverseTail;
        ListNode reverseCurr = reverseHead.next;
        //note we use 3 pointers here so as to reverse the list while keep track of next pointers
        for(int i=0; i<(n-m); i++){
            ListNode tmp = reverseHead;
            reverseHead = reverseCurr;
            reverseCurr = reverseCurr.next;
            reverseHead.next = tmp;
        }
        
        //concate first part, revrese part and second part
        reverseTail.next = reverseCurr;
        firstTail.next = reverseHead;
        return dummyHead.next;
    }
}