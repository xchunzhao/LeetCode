package algorithm.Sort;

import java.util.Arrays;

/**
 * Author : xchunzhao
 * Date : 2016/8/16
 */
public class HeapSort {
    public static void main(String[] args){
        int a[] = {2,31,4,45,1};
        int len = a.length;
        for (int i = 0;i<len;i++){
            buildMaxHeap(a,len-i-1);
            swap(a,0,len-i-1);
        }
        Arrays.stream(a).forEach(s -> System.out.println(s));
    }

    public static void swap(int[] num,int i, int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    /**
     * 1、当前节点n，若左右子树存在，左子树节点下标为2*n+1,右子树节点下标为2*n+2
     * 大顶堆数组长度为n,则第一个非叶子节点下标为(n-1)/2
     */
    public static void buildMaxHeap(int[] num, int lastIndex){
        for(int i=(lastIndex-1)/2;i>=0;i--){
            //当前待处理节点
            int k=i;
            int left = 2*k+1;
            //若左子树存在
            while(left<=lastIndex){
                int biggerIndex=left;
                //若存在右子树
                if(biggerIndex<lastIndex){
                    //左子树小于右子树节点
                    if(num[biggerIndex]<num[biggerIndex+1]){
                        //切换到右子树
                        biggerIndex++;
                    }
                }
                //当前节点小于左右子树中最大数
                if(num[k]<num[biggerIndex]){
                    //交换
                    swap(num,k,biggerIndex);
                    k=biggerIndex;
                }else{
                    break;
                }
            }
        }
    }

}
