package algorithm.TAOPP.Chapter1.StringContains;

/**
 * Author : zhaoxiaochun
 * Date : 2016/9/22
 * 给定两个分别由字母组成的字符串A和字符串B，
 * 字符串B的长度比字符串A短。
 * 请问，如何最快地判断字符串B中所有字母是否都在字符串A里？
 */
public class StringContains02 {
    /**
     * 时间复杂度O(m*n)
     * @param strA
     * @param strB
     * @return
     */
    private static boolean stringContains02_01(char[] strA, char[] strB){
        //strB长度短
        int lenA = strA.length;
        int lenB = strB.length;
        boolean rs = true;
        for (int i= 0;i<lenB;i++ ){
            int j ;
            //找出不在A中的情况
            for (j = 0;j<lenA && (strA[j]!=strB[i]);j++){
                if (j>=lenA){
                    rs = false;
                }
            }
        }
        return rs;
    }

    /**
     * 先排序(快排)，最后用两个指针移动判断
     * 时间复杂度 排序：O(nlogn)+O(mlogm)
     *          遍历：O(m+n)
     * @param strA
     * @param strB
     * @return
     */
    private static boolean stringContains02_02(char[] strA, char[] strB){
        return false;
    }

    /**
     * 使用hash表，strA放入Hashtable,轮训strB
     * 时间复杂度O(m+n)
     */
    private static boolean stringContains02_03(char[] strA, char[] strB){
        int lenA = strA.length;
        int lenB = strB.length;
        int hash = 0;
        for (int i = 0; i < lenA; ++i)
        {
            //使用位或操作
            hash |= (1 << (strA[i] - 'A'));
        }
        for (int i = 0; i < lenB; ++i)
        {
            //此时hash为26bit整数，A对应字符在hash中为1
            //判断B中的某个字符不在A中，运用&操作
            if ((hash & (1 << (strB[i] - 'A'))) == 0)
            {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args){

        char a[] = {'S','W','T','Q','P'};
        char b[] = {'W','P'};
        stringContains02_03(a,b);
    }
}
