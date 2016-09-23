package algorithm.TAOP.AllPermutation;

import java.util.Stack;

/**
 * Author : zhaoxiaochun
 * Date : 2016/9/23
 * 求字符的所有组合
 * 如果输入abc，它的组合有a、b、c、ab、ac、bc、abc
 */
public class AllPermutation_01_02 {
    /**
     * 假设最终的序列为A[]
     * 对于第一个元素，有两种选择，in/not in
     * 两种情况递归
     */
    private static void combiantionAll(char[] chars){
        if (chars == null || chars.length <=0){
            return;
        }
        for (int i = 0;i<chars.length;i++){

        }
    }
    //从chars中第begin个字符开始选取number个进行组合
    private static void combiantion(char[] chars, int begin, int number, Stack stack){
        if (number == 0){
            System.out.println(stack.toString());
        }
        //超过长度
        if (begin == chars.length){
            return;
        }

        //加入组合，后n-1个选m-1个
        stack.push(chars[begin]);
        combiantion(chars, begin+1, number-1, stack);

        //不加入组合,后n-1个选m个
        stack.pop();
        combiantion(chars, begin+1, number, stack);

    }
}
