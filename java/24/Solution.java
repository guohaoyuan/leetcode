/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 /**
 方法1 递归
 我们关注主要有三点
 1. 最终的返回值：交换完成的子链表
 2. 调用递归单元做了什么：设需要交换的两个点为head和next,head连接后面的交换完成的子链表，next连接head，完成交换
 3. 终止条件：head为空指针或者next为空指针，也就是当前无节点或者只有一个节点，无法进行交换
  */
// class Solution {
//     public ListNode swapPairs(ListNode head) {
//         if(head == null || head.next == null)
//         {
//             return head;
//         }   // 最后一次递归要执行的
//         ListNode next = head.next;
//         head.next = swapPairs(next.next);   // 执行递归
//         next.next = head;   // 递归中要做的就是反转邻居
//         return next;    // 返回最终结果
//     }
// }



/**
非递归
 */
class Solution{
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;    // 类似于一个虚拟头节点
        ListNode temp = pre;
        while(temp.next != null && temp.next.next != null)
        {
            ListNode start = temp.next; //  
            ListNode end = temp.next.next;  //  
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }
}