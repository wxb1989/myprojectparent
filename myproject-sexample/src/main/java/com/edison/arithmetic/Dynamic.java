package com.edison.arithmetic;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION} 动态规划小例子
 * @create 2017-11-13 16:36
 **/
public class Dynamic {


    /**
     *
     * 例1：有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。
     *
     * 在这个问题上，我们让f(n)表示走上n级台阶的方法数。那么当n为1时，f(n) = 1,n为2时，f(n) =2,就是说当台阶只有一级的时候，
     * 方法数是一种，台阶有两级的时候，方法数为2。那么当我们要走上n级台阶，必然是从n-1级台阶迈一步或者是从n-2级台阶迈两步，
     * 所以到达n级台阶的方法数必然是到达n-1级台阶的方法数加上到达n-2级台阶的方法数之和。即f(n) = f(n-1)+f(n-2)，
     * 我们用dp[n]来表示动态规划表，dp[i],i>0,i<=n,表示到达i级台阶的方法数。
     *
     * n%2147483647 这样取模出来的数必然是整数
     * @param n
     * @return
     */
    public static int step(int n){
        if (n<3) return 0;

        int f = 1%2147483647;
        int s = 2%2147483647;
        int t = 0;
        for(int i=3;i<=n;i++){
            t = (f+s)%2147483647;
            f = s;
            s = t;
        }
        return t;
    }

    public static void main(String[] args) {

        System.out.println(step(5));
    }
}
