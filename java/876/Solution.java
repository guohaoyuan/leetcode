/**
方法1输出到数组
按照顺序将每个节点放入数组A中，然后中间节点就是A[A.length / 2]，因为我么那可以通过索引检索每一个节点
时间复杂度就是on，循环次数
空间复杂度on，A用去的空间
 */


 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// class Solution{
//     public static void main(String[] args)
//     {
//         ListNode[] A = new ListNode[100];
//         int t = 0;
//         while(head.next != null)
//         {
//             A[t++] = head;  // 先执行A[t] = head; 在执行t++
//             head = head.next;   // 后移一位，头指针
//         } 
//         return A[t / 2];
//     }
// }


/**
方法二 快慢指针法
当慢指针slow遍历列表时，让另一个指针fast的速度是他的2倍
当fast到达列表的末尾时，slow必然位于中间
时间复杂度on，n是节点数目
空间复杂度是n1，slow和fast用去的空间
 */
 class Solution{
     public ListNode middleNode(ListNode head)
     {
         ListNode slow = head, fast = head;
         while(fast != null && fast.next != null)
         {
             slow = slow.next;
             fast = fast.next.next;
         }
         return slow;
     }
 }