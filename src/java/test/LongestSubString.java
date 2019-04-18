package algorithm.test;

import java.util.HashSet;

/**
 * Created by CoderZhao on 2016/3/28.
 */
public class LongestSubString {
    public static int longestSubString(String s){
        int max=1;
        HashSet set=new HashSet();
        for(int i=0;i<s.length();i++){
            int end=i+max-1;
            for(int j=i;j<s.length();){
                set.add(s.charAt(j));
                if(set.size()!=(end-i+1))
                    break;
            }

        }
        return max;
    }
    public static void main(String[] args){
        System.out.println(LongestSubString.longestSubString("abcbed"));
    }
}
