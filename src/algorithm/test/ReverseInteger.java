package algorithm.test;

/**
 * Created by CoderZhao on 2016/3/15.
 */

public class ReverseInteger {
    public static int reverse(int x) {
        boolean flag = false;
        if (x < 0) {
            flag = true;
            x = 0 - x;
        }
        char[] a = (x + "").toCharArray();
        int from=0;
        int to=a.length-1;
        if(from==to){
            if(flag==true){
                return 0-x;
            }else{
                return x;
            }
        }else {
            while (from < to) {
                char temp = a[from];
                a[from] = a[to];
                a[to] = temp;
                from++;
                to--;
            }
            int rs=0;
            try {
                rs = Integer.parseInt(String.valueOf(a));
            }catch (Exception e){
                return 0;
            }
            if(flag==true){
                return 0-rs;
            }else{
                return rs;
            }
        }
    }

    public static void main(String[] args){
        System.out.println(ReverseInteger.reverse(-2147483648));
    }
}
