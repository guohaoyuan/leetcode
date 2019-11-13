/**
方法1 归并排序，递归法+二分法
步骤：1.cut
     2.merge
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)   // 递归都是这种套路
        {
            return head;
        }

        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null)    // 快慢指针法，奇数个点slow指向中点，偶数个点指向中间两点中左边的数
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tmp = slow.next;   // temp指的是第二段链表的头节点
        slow.next = null; // 这里将第一段最后指向null,算是彻底断开了

        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        ListNode h = new ListNode(0); // 以虚拟头节点的链表,
        ListNode res = h;   // 

        while(left != null && right != null)    // 左右均不为空，执行
        {
            if(left.val < right.val)
            {
                h.next = left;
                left = left.next;   // 后移一位
            }
            else
            {
                h.next = right;
                right = right.next;
            }
            h = h.next; // 头节点后移

        }
        h.next = left != null ? left : right;
        return res.next;
    }
}