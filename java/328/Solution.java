/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 /**
 将奇数节点放在一个链表里
 将偶数节点放在另一个节点里
 然后把偶链表接在奇数链表的尾部

 我们需要头节点和尾节点来分别表示首位指针
  */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
        {
            return null;
        }

        ListNode odd = head, even = head.next, evenHead = even; // 将各个节点指针部署好

        while(even !=null && even.next != null)
        {
            odd.next = even.next;   // 1
            odd = odd.next;         // 2
            even.next = odd.next;   // 3
            even = even.next;
        }   // 以上已经拆成两个
        odd.next = evenHead;
        return head;
    }
}