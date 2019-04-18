package algorithm.TAOPP.Chapter1.LongestSubString;

/**
 * Author : zhaoxiaochun
 * Date : 2016/9/22
 * 字符串最长回文子串
 */
public class LongestSubString_01 {
    /**
     * 常规算法
     * @param 保存最大长度max 初始化为1
     * 1、第一层循环遍历string
     * 2、第二层循环从i+1--n,每循环一次判断是否回文。若回文，再跟max比较
     * 时间复杂度为O(n^3)
     */
    private static int longestSubString_01_01(String chars, int len){
        if (chars == null || len <0 ){
            return 0;
        }
        int max = 1;
        for (int i = 0; i<len;i++){
            for (int j=i+1;j<len;j++){
                int length = j-i;
                String sub = chars.substring(i,j+1);
                //如果是回文
                if (isPalindrome(sub, sub.length())){
                    if(length > max){
                        max = length;
                    }
                }
            }
        }
        return max;
    }
    private static boolean isPalindrome(String chars, int len){
        if (chars == null || len<1){
            return false;
        }
        int from = 0;
        int to = len-1;
        while (from<to){
            if(chars.charAt(from) != chars.charAt(to)){
                return false;
            }
            from++;
            to--;
        }
        return true;
    }


    /**
     * 1、第一层循环0--n 枚举中心轴
     * 2、第二层需要判断该子串奇数
     * @param chars
     * @param len
     * @return
     */
    private static int longestSubString_01_02(String chars, int len) {
        if (chars == null || len < 0) {
            return 0;
        }
        int i,j;
        int c = 0;
        int max=1;
        for (i = 0;i<len;i++){
            for (j = 0 ; (i-j>=0) && (i+j<len) ; ++j ){
                if (chars.charAt(i-j)!=chars.charAt(i+j)){
                    break;
                }
                c = 2*j +1;
            }
            max = c>max?c:max;
            for (j = 0 ; (i-j>=0) && (i+j+1<len) ; ++j ){
                if (chars.charAt(i-j)!=chars.charAt(i+j+1)){
                    break;
                }
                c = 2*j +2;
            }
            max = c>max?c:max;
        }
        return max;
    }




    public static void  main(String[] args){
        String s = "asdsabcdefgfedcba";
        System.out.println(longestSubString_01_02(s, s.length()));
    }
}
