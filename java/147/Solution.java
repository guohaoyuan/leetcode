/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 /**
 为了排序速度快尽可能稍作比较;
 需要用哟和指针指向已排序的最后一个位置，head
 需要另外一个指针pre,每次从表头循环，这里用的虚拟头节点
 未排序的节点和先驱比较，大于等于先驱，则不需比较;否则进入循环依次比较
  */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0), pre;  // 创建虚拟头节点，等价写法：如下
        // ----->
        // ListNode dummy = new ListNode(0);
        // ListNode pre;

        dummy.next = head;  // 将虚拟头节点指向head

        while(head != null && head.next != null)
        {
            if(head.val <= head.next.val)
            {
                head = head.next;   // 此时表示的时本来就小于等于后面的数，无需排序，但是需要指针后移
                continue;
            }
            pre = dummy;    // 虚拟头节点赋值给pre

            while(pre.next.val < head.next.val)
            {
                pre = pre.next; // 从前往后看，没错链表只能如此迭代,指针后移
            }

            ListNode curr = head.next;  // 需要排序的节点
            head.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;

        }

        return dummy.next;
    }
}