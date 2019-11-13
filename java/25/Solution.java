/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);   // 虚拟头节点
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while(end.next != null)             // 对于循环开始前，先判断该段是否可以反转，即待反转
        {
            for (int i = 0 ; i < k && end != null ; i++)    // 反转过程中，是否长度为k,如果是的话，先把end指针移过去
            {
                end = end.next;     
            }

            if(end == null)                 // 如果长度不为k，则直接退出while
            {
                break;
            }

            ListNode start = pre.next;      // 将start指针放置于待反转的第一个节点
            ListNode next = end.next;       // 将next指针放置于下一个待反转的第一个节点处

            end.next = null;                // 将当前待反转，从原链表断开
            pre.next = reserve(start);
            start.next = next;
            pre = start;

            end = pre;
        }

        return dummy.next;
    }

    private ListNode reserve(ListNode head)
    {
        ListNode pre = null;
        ListNode curr = head;
        while(curr != null)
        {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }
}