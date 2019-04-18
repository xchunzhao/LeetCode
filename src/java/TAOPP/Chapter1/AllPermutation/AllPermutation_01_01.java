package algorithm.TAOPP.Chapter1.AllPermutation;

import java.util.Arrays;

/**
 * Author : zhaoxiaochun
 * Date : 2016/9/23
 * 已知字符串里的字符是互不相同的，现在任意组合，
 * 比如ab，则输出aa，ab，ba，bb，编程按照字典序输出所有的组合
 */
public class AllPermutation_01_01 {
    /**
     * 参考{@link AllPermutation_01}
     * 设置数值位判断该字符串是否已满
     * 1、假设第一个已经固定 有0-n种选择
     * 2、后面递归调用 终止条件为固定全部字符count==size
     */
    private static void allPermutation_01_01(char[] chars, char[] result, int size, int count){
        //递归终止条件
        if (count == size){
            Arrays.asList(result).forEach(t -> System.out.print(t));
            System.out.println();
        }else{
            for (int i = 0;i<size;i++){
                result[count] = chars[i];
                allPermutation_01_01(chars, result, size, count+1);
            }
        }
    }

    public static void  main(String[] args){
        char[] a = {'a','b'};
        int len = a.length;
        char[] rs = new char[len];
        allPermutation_01_01(a, rs, len, 0);

    }
}
