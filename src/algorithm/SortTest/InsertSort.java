package algorithm.SortTest;

import java.util.Arrays;

/**
 * Author : xchunzhao
 * Date : 2016/8/15
 * Desc : 插入排序
 * 算法步骤：
 *      1、假设当前下标前的子序列是排好序的
 *      2、将当前下标数字往前面子序列插入
 *      时间复杂度：O(n^2)
 */
public class InsertSort {
    public static void main(String[] args){
        int a[] = {2,31,4,45,1};
        a = insertSort(a);
        Arrays.stream(a).forEach(s -> System.out.println(s));
    }

    public static int[] insertSort(int[] num){
        int len = num.length;
        int temp;
//        for (int i = 1;i<len;i++){
//            temp = num[i];
//            int j;
//            for (j = i-1;j>=0;j--){
//                if (temp<num[j]){
//                    num[j+1] = num[j];
//                }else{
//                    break;
//                }
//            }
//            num[j+1] = temp;
//        }

        for(int i = 1;i<len;i++){
            temp = num[i];
            int j ;
            for (j = i;j>=1&& temp<num[j-1];j-=1){
                num[j] = num[j-1];
            }
            num[j] = temp;
        }
        return num;
    }
}
