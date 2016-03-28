/**
 * Created by CoderZhao on 2016/3/14.
 */
package test;
public class ZigZagConversion {
    public static String convert(String s ,int numRows){
        char[][]a =new char[numRows][s.length()/2+1];
        int m=0;
        int n=0;
        boolean flag=true;
        for(int i=0;i<s.length();i++){
            if(flag==true){
                a[m][n] = s.charAt(i);
                if(m==numRows-1){
                    flag=false;
                }else{
                    m++;
                }
            }else if(flag==false){
                m--;
                n++;
                a[m][n]=s.charAt(i);
                if(m==0){
                    flag=true;
                    m++;
                }
            }
        }
        StringBuffer str=new StringBuffer();
        int count=0;
        for (int i=0;i<numRows;i++){
            for(int j=0;j<s.length()/2+1;j++){
                str.append(a[i][j]);
                count++;
            }
        }
        return str.toString();
    }

    public static void main(String [] args){
        System.out.print(ZigZagConversion.convert("PAYPALISHIRING", 3));
    }
}
