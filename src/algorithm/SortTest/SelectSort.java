package algorithm.SortTest;

/**
 * Author : xchunzhao
 * Date : 2016/8/15
 */
public class SelectSort {
    public static void main(String[] args){

    }

    public static int[] selectSort(int[] num){
        int len = num.length;
        int temp ;
        int min;
        for (int i = 0 ; i<len ; i++){
            min = num[i];
            for (int j = 0; j<len;j++){
                if (min > num[j]){
                    temp = min;
                    num[i] = num[j];
                }
            }
        }
        return num;
    }
}
