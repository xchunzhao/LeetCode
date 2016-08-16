package algorithm.Sort;

import java.util.Arrays;

/**
 *  Author : xchunzhao
 * Date : 2016/8/15
 * Desc : 希尔排序
 * 算法步骤：
 *      1、找一个小于n的数作为增量，将序列分成d个组，间隔为d
 *      2、对每个子序列进行插入排序
 */
public class ShellSort {
    public static void main(String[] args){
        int a[] = {2,31,4,45,1};
        a = shellSort(a);
        Arrays.stream(a).forEach(s -> System.out.println(s));
    }

    public static int[] shellSort(int[] num){
        int len = num.length;
        int temp ;
        for (int d = len/2;d>0;d/=2){
            for(int i =d;i<len;i++){
                temp = num[i];
                int j ;
                for (j = i;j>=d&&temp<num[j-d];j-=d){
                    num[j] = num[j-d];
                }
                num[j] = temp;
            }
        }
        return num;
    }
}
