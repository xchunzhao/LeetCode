package algorithm.TAOPP;

/**
 * Author : zhaoxiaochun
 * Date : 2016/9/30
 * 动态规划
 */
public class DP {
    /**
     * @Q1 最长递增子序列
     * 思路：
     * *    定义d[i] 为 以下标为i结尾的最长递增子序列长度
     * *    若已知d[0到i-1],那么d[i]有两种可能。
     * *    @1 num[i]比之前最长子序列的结尾大 d[i] = max{d[0]...d[i-1]}+1
     * *    @2 否则 d[i]=1
     * *    状态转移方程：d[i] = max{1,max{d[0]...d[i-1]}+1}
     * dp[0-i]有了，则可以找出最长子序列长度。
     */
    private static int longestIncreaseSubString(int[] num){
        if (num == null || num.length==0){
            return 0;
        }
        int len = num.length;
        int dp[] = new int[len];
        int max = 0;
        dp[0] = 1;
        for (int i = 1; i<len;i++){ //展开成子问题
            dp[i] = 1;//比之前都小默认本身 所以dp[i]=1
            for (int j = 0;j<i;j++){
                //找出前o到i-1中d[j]最大的
                if (num[j]<num[i]){
                    dp[i] = dp[i]<dp[j] + 1 ? dp[j]+1 : dp[i];
                }
            }
            //保存最大长度
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * @Q2 0-1背包问题
     * 定义v[i][j]为前i个物品能使得剩余容量为j的背包为最大价值
     * 此时v[i][j]可能由两种情况衍变而来
     * @1 前i-1个物品，剩余容量为j,不放第i个物品
     * @2 前i-1个物品，剩余容量j-w[i],放第i个物品
     *
     * 状态转移方程：
     * v[i][j] = max{v[i-1][j],v[i-1][j-w[i]]+val[i]}
     *
     * @param args
     */
    private static int Knapsack(int[] val, int[] wt, int weight){
        int len = val.length;
        int v[][]=new int[len][weight+1];
        //初始化第一个物品单独放置
        for (int i = 1 ;i<=weight;i++){
            if (i< wt[0]){
                v[0][i-1] = 0;
            }else{
                v[0][i-1] = val[0];
            }
        }
        //放置后面n-1个物品
        for (int i=1;i<len;i++){
            for (int j=1;j<=weight;j++){
                //背包容量够放
                if (j>=wt[i]){
                    //放入第i个物品价值更大
                    if (val[i]+v[i-1][j-wt[i]] > v[i-1][j]){
                        v[i][j] = v[i-1][j-wt[i]] +val[i];
                    }else {
                        v[i][j] = v[i-1][j];
                    }
                }else {
                    v[i][j] = v[i-1][j];
                }
            }
        }
        return v[len-1][weight];
    }

    public static void main(String[] args){
//        int[] num = {5,6,7,1,3};
//        System.out.println(longestIncreaseSubString(num));
        int[] wt = {2,3,4,5};
        int[] val = {3,4,5,6};
        System.out.println(Knapsack(val,wt,10));
    }
}
