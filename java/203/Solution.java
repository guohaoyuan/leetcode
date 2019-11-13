// class Solution {
//     public ListNode removeElements(ListNode head, int val) {
        
//         // head节点不为空且是指定节点，即删除头节点
//         while(head != null && head.val == val)
//         {
//             // 方法1
//             // ListNode delNode = head; // 创建link一般都是一个结点
//             // head = head.next;   // 将指针后移
//             // delNode.next = null;
//             // 方法2
//             head = head.next; // head向后面移动一位 
//         }

//         // 如果经过删除头节点，link为空，那么直接返回空list
//         if(head == null)
//         {
//             return null;
//         }

//         // 接下来看除过head后面的node,一般删除操作都需要prev
//         ListNode prev = head;
//         while(prev.next != null)    // 保证头节点后面的节点不为null
//         {
//             if(prev.next.val == val)    // 判断后面节点是否满足题干条件
//             {
//                 // // 方法1
//                 // ListNode delNode = prev.next;   // 一般先创建待删除节点的对象
//                 // prev.next = delNode.next;      // 待删除元素与prev断开
//                 // delNode.next = null;    // 待删除元素指向空

//                 // 方法2
//                 prev.next = prev.next.next; // 指针直接指向下一个
//             }
//             else
//             {
//                 prev = prev.next;   // 将指针后移
//             }
//         }

//         // link遍历结束
//         return head;
        


//     }
// }

// 利用虚拟头节点进行编程
// class Solution {
//     public ListNode removeElements(ListNode head, int val)
//     {
//         ListNode dummyHead = new ListNode(-1); // 虚拟头节点的值随意，不影响
//         dummyHead.next = head;
//         System.out.println(head);
//         ListNode prev = dummyHead;
//         while(prev.next != null)
//         {
//             if(prev.next.val == val)
//             {
//                 prev.next = prev.next.next;
//             }
//             else
//             {
//                 prev = prev.next;
//             }
//         }

//         return dummyHead.next;
//     }

//     public static void main(String[] args)
//     {
//         int[] nums = {1, 2, 3, 4, 5, 6};
//         ListNode head = new ListNode(nums);
//         System.out.println(head);

//         ListNode res = (new Solution()).removeElements(head, 6);
//         System.out.println(res);
//     }    
// }

// 利用递归, 返回值仍然是一个节点
// class Solution{
//     public ListNode removeElements(ListNode head, int val)
//     {
//         if(head == null)    // head为空，则整个链表为空
//         {
//             return null;
//         }

//         // ListNode res = removeElements(head.next, val);  // 后面小链表删除后的结果
//         // if(head.val == val)
//         // {
//         //     return res;
//         // }
//         // else
//         // {
//         //     head.next = res; // 头节点后移一位
//         //     return head
//         // }

//         head.next = removeElements(head.next, val);
//         return  head.val == val ? head.next : head;
//     }
// }


// debug 
class Solution{
    public ListNode removeElements(ListNode head, int val, int depth)
    {
        String depthString = generateDepthString(depth);

        System.out.print(depthString);
        System.out.println("Call: remove " + val + " in " + head);  // 准备删除以head为头节点的链表中的val

        if(head == null)
        {
            System.out.print(depthString);
            System.out.println("Return: " + head);  // 返回null链表
            return head;
        }

        ListNode res = removeElements(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println("After remove " + val + ": " + res); // 输出除过头节点后面的链表执行删除操作后的结果

        ListNode ret; // 
        if(head.val == val)
        {
            ret = res;
        }
        else
        {
            head.next = res;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return: " + ret);
        return ret;
    }

    private String generateDepthString(int depth)   // 利用--长短表示递归深度
    {
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
        {
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args){
        int[] nums = {1, 2, 6, 3, 4, 6, 2};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution()).removeElements(head, 6, 0);
        System.out.println(res);
    }
}