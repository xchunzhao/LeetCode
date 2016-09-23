package algorithm.TAOP.AllPermutation;

import java.util.Arrays;

/**
 * Author : zhaoxiaochun
 * Date : 2016/9/22
 *输入一个字符串，打印出该字符串中字符的所有排列。

 例如输入字符串abc，则输出由字符a、b、c 所能排列出来的所有字符串

 abc、acb、bac、bca、cab 和 cba
 */
public class AllPermutation_01 {
    /**
     *  固定a，求后面bc的排列：abc，acb，求好后，a和b交换，得到bac
        固定b，求后面ac的排列：bac，bca，求好后，c放到第一位置，得到cba
        固定c，求后面ba的排列：cba，cab。
     */
    private static void allPermutation_01_01(char[] chars , int from, int end){
        //递归终止条件--》只有一个元素
        if (from == end){
            Arrays.asList(chars).forEach(t -> System.out.print(t));
            System.out.println();
        }else {//多字母
            for (int i = from;i<end;i++){
                //每次将chars[i]与chars[from]交换
                swapChars(chars[from],chars[i]);
                allPermutation_01_01(chars, from+1, end);//----》固定第一个位置
                swapChars(chars[from], chars[i]);//还原
            }
        }
    }
    private static void swapChars(char a, char b){
        char temp = a;
        a = b;
        b = temp;
    }
}
