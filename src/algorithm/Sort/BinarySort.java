package algorithm.Sort;

import java.util.Arrays;

/**
 * Author : xchunzhao
 * Date : 2016/8/15
 * Desc : 二分插入排序(类似直接插入)
 * 算法步骤：
 *      1、假设当前下标前的子序列是排好序的
 *      2、将当前下标数字往前面子序列插入(二分)
 *      时间复杂度：O(n^2)
 */
public class BinarySort {
    public static void main(String[] args){
        int a[] = {2,31,4,45,1};
        a = binarySort(a);
        Arrays.stream(a).forEach(s -> System.out.println(s));
    }

    public static int[] binarySort(int[] num){
        int len = num.length;
        int temp;
        for (int i =1 ;i<len;i++){
            temp = num[i];
            int left = 0;
            int mid ;
            int right = i-1;
            while(left<=right){
                mid = (left+right)/2;
                if (temp>num[mid]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
            for (int j = i-1; j >= left; j--) {
                num[j + 1] = num[j];
            }
            if (left!=i){
                num[left] = temp;
            }
        }
        return num;
    }
}
