
// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    // 链表节点的构造函数
    // 使用arr为参数，创建一个链表，当前listnode为链表头节点
    public ListNode(int[] arr)
    {
        if(arr == null || arr.length == 0)
        {
            throw new IllegalArgumentException("arr can not be empty");
        }
        this.val = arr[0]; // 一次只能是一个节点
        ListNode cur = this;
        for(int i  = 1 ; i < arr.length ; i++)
        {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    // 以当前节点为头节点的链表信息字符串
    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        ListNode cur = this;
        while(cur != null)
        {
            s.append(cur.val + "->");
            cur = cur.next;
        }
        s.append("NULL");
        return s.toString();
    }
}
