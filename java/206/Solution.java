/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
        {
            return head;
        }   // 一般刚开始是结束的情况，比如头节点为空结束递归

        ListNode p = reverseList(head.next);    // 执行递归
        head.next.next = head;  // 最后一次递归所要做的工作，例如1->2
        head.next = null;   // 
        return p;
    }
}
