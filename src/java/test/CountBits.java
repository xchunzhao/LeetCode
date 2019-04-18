package algorithm.test;

/**
 * Created by CoderZhao on 2016/3/28.
 */

public class CountBits {
    public static int count(int a){
        if(a==0){
            return 0;
        }
        int count=0;
        while(a>1){
            int num=a%2;
            if(num==1){
                count++;
            }
            a=a/2;
        }
        if(a==1){
            count++;
        }
        return count;
    }
    public static int[] result(int a){
        int[] rs=new int[a+1];
        for(int i=0;i<=a;i++){
            rs[i]=count(i);
        }
        return rs;
    }
    public static void main(String[] args){
        int a=5;
        int[] rs=CountBits.result(a);
        for(int i=0;i<=a;i++){
            System.out.println(rs[i]);
        }

    }
}
