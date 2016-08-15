package algorithm.SortTest;

import java.util.Arrays;

/**
 * Author : xchunzhao
 * Date : 2016/8/15
 * Desc : 选择排序
 * 算法步骤：
 *      1、min保存每趟最小数的下标
 *      2、每次获取最小数跟子序列第一个交换
 *      时间复杂度O(n^2)
 */
public class SelectSort {
    public static void main(String[] args){
        int a[] = {2,31,4,45,1};
        a = selectSort(a);
        Arrays.stream(a).forEach(s -> System.out.println(s));
    }
    public static int[] selectSort(int[] num){
        int len = num.length;
        int temp ;
        int min;
        for (int i = 0 ; i<len ; i++){
            min = i;
            for (int j =i+1;j<len;j++){
                if (num[min] > num[j]){
                    min = j;
                }
            }
            temp = num[min];
            num[min] = num[i];
            num[i] = temp;
        }
        return num;
    }
}
