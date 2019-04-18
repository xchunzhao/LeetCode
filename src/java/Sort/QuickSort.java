package algorithm.Sort;

import java.util.Arrays;

/**
 * Author : xchunzhao
 * Date : 2016/8/16
 * Desc : 快速排序
 * 算法步骤：
 *      1、选取第一个元素，遍历序列，比该元素小的在左，分成两个子序列
 *      2、对每个子序列进行步骤1的操作
 *      3、重复以上步骤
 *      时间复杂度O(nlogn)
 */
public class QuickSort {
    public static void main(String[] args){
        int a[] = {2,31,4,45,1};
        int len = a.length;
        a = quickSort(a, 0, len-1);
        Arrays.stream(a).forEach(s -> System.out.println(s));
    }

    /**
     * 获取中枢所在下标,两个指针i、j
     */
    public static int getMiddle(int[] num, int begin ,int end){
        int temp = num[begin];
        while (begin<end){
            while(begin<end && num[end]>temp){
                end--;
            }
            num[begin] = num[end];//比temp小的放左边

            while(begin<end && num[begin]<temp){
                begin++;
            }
            num[end] = num[begin];//比temp大的右边
        }
        num[begin] = temp;
        return begin;
    }
    public static int[] quickSort(int[] num, int begin, int end){
        if (begin<end){
            //获取中枢所在下标
            int mid = getMiddle(num, begin, end);
            quickSort(num, begin, mid-1);
            quickSort(num, mid+1, end);
        }
        return num;
    }
}
