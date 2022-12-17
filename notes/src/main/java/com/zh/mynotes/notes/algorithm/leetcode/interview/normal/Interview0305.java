package com.zh.mynotes.notes.algorithm.leetcode.interview.normal;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author zeng hao
 * @Description 面试题 03.05. 栈排序
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
 *
 * 示例1:
 *
 *  输入：
 * ["SortedStack", "push", "push", "peek", "pop", "peek"]
 * [[], [1], [2], [], [], []]
 *  输出：
 * [null,null,null,1,null,2]
 * 示例2:
 *
 *  输入：
 * ["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
 * [[], [], [], [1], [], []]
 *  输出：
 * [null,null,null,null,null,true]
 * 说明:
 *
 * 栈中的元素数目在[0, 5000]范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-of-stacks-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date Create in 2022/03/29 19:00
 */
public class Interview0305 {

    public static void main(String[] args) {
        SortedStack stack = new SortedStack();
        stack.push(40);
        stack.push(19);
        stack.push(44);
        stack.push(42);
        stack.push(8);
        stack.push(29);
        stack.push(25);
        stack.push(52);
        stack.push(63);
        stack.push(47);
        stack.push(45);
        stack.push(52);
        stack.push(17);
        stack.push(6);
        stack.push(30);
        stack.push(51);
        stack.push(46);
        stack.push(2);
        stack.push(56);
        stack.push(39);
        stack.push(38);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
    }


}

/* 只要保证进栈和出栈后栈顶是最小元素就行。
* 如果不是，就
* */
class SortedStack{
    Deque<Integer> deque;
    Deque<Integer> tmp;

    public SortedStack() {
        deque = new ArrayDeque<>();
        tmp = new ArrayDeque<>();
    }

    public void push(int val) {
        if (deque.isEmpty()){
            deque.push(val);
            return;
        }
        int top = deque.peek();
        if (top >= val){
            deque.push(val);
            return;
        }
        while (top < val){
            deque.pop();
            tmp.push(top);
            if (deque.isEmpty()){
                break;
            }
            top = deque.peek();
        }
        deque.push(val);
        while (!tmp.isEmpty()){
            deque.push(tmp.pop());
        }
    }

    public void pop() {
        if (!deque.isEmpty()){
            deque.pop();
        }
    }

    public int peek() {
        if (deque.isEmpty()){
            return -1;
        }
        return deque.peek();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }
}
