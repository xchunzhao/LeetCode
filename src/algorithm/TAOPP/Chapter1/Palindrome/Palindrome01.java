package algorithm.TAOPP.Chapter1.Palindrome;

/**
 * Author : zhaoxiaochun
 * Date : 2016/9/22
 * 判断一个字符串是否回文
 */
public class Palindrome01 {

    /**
     * 常规思路。头尾比较
     * @param chars
     * @return
     */
    private static boolean palindrome01_01(char[] chars, int len){
        if (chars == null || len<1){
            return false;
        }
        int from = 0;
        int to = len-1;
        while (from<to){
            if(chars[from] != chars[to]){
                return false;
            }
            from++;
            to--;
        }
        return true;
    }

    /**
     * 从中间向两边遍历
     * @param chars
     * @param len
     * @return
     */
    private static boolean palindrome01_02(char[] chars, int len){
        if (chars == null || len<1){
            return false;
        }
        int left = ((len >> 1)-1) >= 0 ? (len >> 1)-1 : 0;
        int right = len % 2 == 0 ? left+1 : left +2;
        while (left>=0){
            if (chars[left] != chars[right]){
                return false;
            }
            left--;
            right++;
        }
        return true;
    }


    public static void main(String[] args){
        char a[] = {'1','2','3','3','2','1'};
        System.out.println(palindrome01_01(a, 6));
        System.out.println(palindrome01_02(a, 6));
    }
}
