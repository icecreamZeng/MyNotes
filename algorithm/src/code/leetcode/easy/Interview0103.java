package code.leetcode.easy;

/**
 * @Author: Zeng Hao
 * @Description: 面试题 01.03. URL化
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。
 * 假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
 * （注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 *示例 1：
 *
 * 输入："Mr John Smith    ", 13
 * 输出："Mr%20John%20Smith"
 * 示例 2：
 *
 * 输入："               ", 5
 * 输出："%20%20%20%20%20"
 *
 * 提示：
 *
 * 字符串长度在 [0, 500000] 范围内。

 * @Date: Created in 2021/1/6 9:25
 */
public class Interview0103 {
    public static void main(String[] args) {
        System.out.println("[" + replaceSpaces1("Mr John Smith    ", 13) + "]");
    }

    public static String replaceSpaces1(String S, int length) {
        char[] oldChars = S.toCharArray();
        int oldLength = S.length();
        char[] chars =S.toCharArray();
        int index = 0;
        for (int i = 0 ; i < oldLength && i < length ; i ++){
            char ch = oldChars[i];
            if (ch == ' '){
                chars[index] = '%';
                chars[index + 1] = '2';
                chars[index + 2] ='0';
                index += 2;
            }else {
                chars[index] = ch;
            }
            index ++;
        }
        return String.copyValueOf(chars,0, index);
    }
}
