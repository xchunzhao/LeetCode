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

    private static int test(int[] cost, int n) {
        int minCost = 0;
        if(n<=2) {
            minCost = cost[n-1];
        } else {
            int preCost = test(cost, n-1) + cost[0] + cost[n-1];
            int preTwoCost = test(cost, n-2) + cost[0] + cost[n-1] + 2* cost[1];
            minCost = preCost > preTwoCost ? preTwoCost : preCost;
        }
        return  minCost;

    }

    private static int test2(int[] cost, int n) {
        int minCost = 0;
        if (n<=0) {
            return minCost;
        } else {
            int preTwoCost = cost[0];
            int preCost = cost[1];
            for (int i= 3 ;i<=n; i++) {
                int costPlanA = preCost + cost[0] + cost[i-1];
                int costPlanB = preTwoCost + cost[0] + cost[i-1] + 2*cost[1];
                minCost = costPlanA > costPlanB ? costPlanB : costPlanA;

                preTwoCost = preCost;
                preCost = minCost;
            }
        }
        return  minCost;

    }


    private static  int lcs(char[] array1, char[] array2) {
        int len1 = array1.length;
        int len2 = array2.length;

        int[][] opt = new int[len1 + 1][len2 + 1];

        //初始化lcs长度矩阵
        //矩阵中最大的数及为两个字符串的最大子序列长度 且是最后为opt[len1][len2]
        for (int i = 1; i <= len1;i++) {
            for (int j = 1; j<=len2 ; j++) {
                if (array1[i-1] == array2[j-1]) {
                    opt[i][j] = opt[i - 1][j - 1] + 1;
                } else {
                    opt[i][j] = Math.max(opt[i][j-1],opt[i-1][j]);
                }
            }
        }


        return opt[len1][len2];

    }

    public static void main(String[] args){
//        int[] num = {5,6,7,1,3};
//        System.out.println(longestIncreaseSubString(num));
//        int[] wt = {2,3,4,5};
//        int[] val = {3,4,5,6};
//        System.out.println(Knapsack(val,wt,10));
        int[] cost = {1, 2 , 5, 10};
        System.out.println(test2(cost,4));

        char[] array1 = "akqrshrengxqiyxuloqk".toCharArray();
        char[] array2 = "tdzbujtlqhecaqgwfzbc".toCharArray();

        System.out.println(lcs(array1, array2));
    }
}
