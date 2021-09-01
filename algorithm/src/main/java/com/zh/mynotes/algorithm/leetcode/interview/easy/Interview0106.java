package leetcode.interview.easy;

/**
 * @Author: Zeng Hao
 * @Description: 面试题 01.06. 字符串压缩
 *
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 *
 * 示例1:
 *
 *  输入："aabcccccaaa"
 *  输出："a2b1c5a3"
 * 示例2:
 *
 *  输入："abbccd"
 *  输出："abbccd"
 *  解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * 提示：
 *
 * 字符串长度在[0, 50000]范围内。
 * @Date: Created in 2021/7/20 16:19
 */
public class Interview0106 {
    public static void main(String[] args) {
        System.out.println(compressString("abbccd"));
    }
    static String compressString(String S) {
        if (S == null || S.length() <= 2){
            return S;
        }
        StringBuilder sb = new StringBuilder();
        char tmp = '-';
        int count = 0;
        int length = S.length();
        for (int i = 0; i < length ; i ++){
            char c = S.charAt(i);
            if (tmp == c){
                count ++;
            }else{
                //新的字符
                if (count > 0){
                    sb.append(count);
                }
                sb.append(c);
                tmp = c;
                count = 1;
            }
        }
        if (count > 0){
            sb.append(count);
        }
        return sb.length() < S.length() ? sb.toString() : S;
    }
}
