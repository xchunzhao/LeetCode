/**
 * Created by CoderZhao on 2016/3/28.
 */
package test;
public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
        int [] result=new int[2];
        int len=numbers.length;
        for (int i=0;i<len-1;i++){
            for (int j=i+1;j<len;j++){
                if (target==numbers[i]+numbers[j]){
                    result[0]=i+1;
                    result[1]=j+1;
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] numbers={2,7,11,15};
        int[] rs=TwoSum.twoSum(numbers,9);
        for(int i=0;i<rs.length;i++){
            System.out.println(rs[i]);
        }
    }
}
