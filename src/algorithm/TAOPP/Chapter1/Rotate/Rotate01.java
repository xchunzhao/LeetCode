package algorithm.TAOP.Rotate;

import java.util.Arrays;

/**
 * Author : zhaoxiaochun
 * Date : 2016/9/22
 *
 * 给定一个字符串，要求把字符串前面的若干个字符移动到字符串的尾部，
 * 如把字符串“abcdef”前面的m个字符'a'和'b'移动到字符串的尾部，
 * 使得原字符串变成字符串“cdefab”。
 * 请写一个函数完成此功能，要求对长度为n的字符串操作的时间复杂度为 O(n)，空间复杂度为 O(1)。
 */
public class Rotate01 {

    /**
     * 遍历0-m,每次将第0个放到最后，并往前移动后1-n个
     * 时间复杂度为O(m*n)
     * 空间复杂度O(1)
     * @param chars
     * @param m
     */
    private static void rotateString_1(char chars[], int m){
        int len = chars.length;
        m--;
        while(m>=0){
            shiftOne(chars, len);
            m--;
        }

    }
    private static void shiftOne(char chars[],int len){
        char tmp = chars[0];
        //将后面n-1个往前移
        for (int i =1 ;i <len;i++){
            chars[i-1] = chars[i];
        }
        chars[len-1] = tmp;
    }


    /**
     * 1、将字符串分为两组
     * 2、先将前m个反转，再将后n-m个反转，最后反转整个字符串
     * @param chars
     * @param m
     */
    private static void rotateString_2(char chars[], int m){
        ReverseString(chars, 0, m-1);
        ReverseString(chars, m, chars.length-1);
        ReverseString(chars, 0, chars.length-1);
    }
    //将字符串反转
    private static void ReverseString(char chars[],int from, int to){
        while(from<to){
            char tmp = chars[from];
            chars[from++] = chars[to];
            chars[to--] = tmp;
        }
    }


    public static void main(String[] args){
        char chars[] = {'1','2','a','w','r','5'};
//        rotateString_1(chars,2);
        rotateString_2(chars,2);
        Arrays.asList(chars).stream().forEach(t -> System.out.println(t));
    }
}
