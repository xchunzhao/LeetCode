package algorithm.SortTest;

import java.util.Arrays;

/**
 * Author : xchunzhao
 * Date : 2016/8/15
 * Desc : 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args){
        int a[] = {2,31,4,45,1};
        a = bubbleSort(a);
        Arrays.stream(a).forEach(s -> System.out.println(s));
    }
    public static int[] bubbleSort(int[] num){

        /**
         * 连续两个比较
         *
         */
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
