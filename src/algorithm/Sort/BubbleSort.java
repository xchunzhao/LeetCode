package algorithm.Sort;

import java.util.Arrays;

/**
 * Author : xchunzhao
 * Date : 2016/8/15
 * Desc : 冒泡排序
 * 算法步骤：
 *      1、两两比较，满足条件交换，并往后移动
 *      2、第一趟将最大的移动到最后下标
 *      时间复杂度：O(n^2)
 */
public class BubbleSort {
    public static void main(String[] args){
        int a[] = {2,31,4,45,1};
        a = bubbleSort(a);
        Arrays.stream(a).forEach(s -> System.out.println(s));
    }
    public static int[] bubbleSort(int[] num){

        int len = num.length;
        int temp ;
        for(int i = 0 ; i<len; i++){
           for(int j = 0 ;j<len-i-1;j++){
                if (num[j]>num[j+1]){
                    temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                }
           }
        }
        return num;
    }
}
