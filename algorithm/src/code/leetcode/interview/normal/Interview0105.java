package code.leetcode.interview.normal;

/**
 * @Author: Zeng Hao
 * @Description: 面试题 01.05. 一次编辑
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。
 * 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * 示例:
 *
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 *
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False

 * @Date: Created in 2021/1/6 14:05
 */
public class Interview0105 {
    public static void main(String[] args) {
        System.out.println(oneEditAway("teacher", "taacher"));
    }

    /**
     * 插入，跟删除是同一等级的，区分长度，可以都当作删除或插入来处理
     * @param first
     * @param second
     * @return
     */
    public static boolean oneEditAway(String first, String second) {
        int lengthA = first.length();
        int lengthB = second.length();
        int x = lengthA - lengthB;
        if (x < -1 || x> 1){
            return false;
        }
        char[] charsA = first.toCharArray();
        char[] charsB = second.toCharArray();
        int count = 0;
        for (int i = 0; i < lengthA && i < lengthB ; i++){
            char a;
            char b;
            if (count == 0){
                a = charsA[i];
                b = charsB[i];
                if (a != b){
                    count ++;
                }
                if (x==0){
                    continue;
                }
            }
            if (x == 1){
                a = charsA[i + count];
                b = charsB[i];
            }else   {
                a = charsA[i];
                if (x == -1){
                    b = charsB[i + count];
                }else {
                    b = charsB[i];
                }
            }
            if (a != b && count >0){
                return false;
            }
        }
        return true;
    }
}
