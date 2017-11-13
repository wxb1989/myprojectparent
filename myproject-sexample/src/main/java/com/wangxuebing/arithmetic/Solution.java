package com.wangxuebing.arithmetic;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-13 16:36
 **/
public class Solution {
    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if (nums.length == 1) {
            return dp[0];
        }
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int [] mun ={10,11,25,78,4,6,74};

        System.out.println(rob(mun));
    }
}
