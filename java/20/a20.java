import java.util.Stack;

class a20
{
    public boolean isValid(String s)
    {
        Stack<Character> stack = new Stack<>();
        for (int i = 0 ; i < s.length() ; i++)
        {
            char c = s.charAt(i);   // 获取字符串i-th个字符
            if(c == '(' || c == '{' || c == '[')
            {
                stack.push(c);  // 入栈
            }
            else
            {
                if(stack.isEmpty())
                {
                    return false;   // 没有左括号，还为空，说明就是有括号
                }

                char topChar = stack.pop(); // 删除栈顶元素，返回其值
                if(c == ')' && topChar != '(')
                {
                    return false;
                }
                if(c == ']' && topChar != '[')
                {
                    return false;
                }
                if(c == '}' && topChar != '{')
                {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args)
    {
        System.out.println((new a20()).isValid("({[]})"));
        System.out.println((new a20()).isValid("{(){"));
    }
}