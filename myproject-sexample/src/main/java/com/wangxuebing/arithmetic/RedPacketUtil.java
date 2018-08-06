package com.wangxuebing.arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ${Administrator}
 * @description 红包随机算法
 * @create 2018-04-25 11:09
 **/
public class RedPacketUtil {

    //最小红包额度
    private static final int MINMONEY = 1;
    //最大红包额度
    private static final int MAXMONEY = 200 * 100;
    //每个红包最大是平均值的倍数
    private static final double TIMES = 2.1;

    /*
    把红包总金额想象成一条很长的线段，而每个人抢到的金额，则是这条主线段所拆分出的若干子线段。
    当N个人一起抢红包的时候，就需要确定N-1个切割点。因此，当N个人一起抢总金额为M的红包时，
    我们需要做N-1次随机运算，以此确定N-1个切割点。随机的范围区间是（1， M）。
    当所有切割点确定以后，子线段的长度也随之确定。这样每个人来抢红包的时候，
    只需要顺次领取与子线段长度等价的红包金额即可。这就是线段切割法的思路。
    在这里需要注意以下两点：(1)当随机切割点出现重复，如何处理 (2)如何尽可能降低时间复杂度和空间复杂度。
     */

    private  List<Integer> redpack(int money,int count){
        //先判断这个红包是否合法
        if (!isRight(money, count)) {
            return null;
        }
        //这个是切割点，一次性随机出count个数
        int point =count-1;

        for (int i = 0; i < point; i++) {

        }
        return null;
    }


    /**
     * @param money
     * @param count
     * @return
     * @Author:lulei
     * @Description: 拆分红包
     */
    public List<Integer> splitRedPackets(int money, int count) {
        if (!isRight(money, count)) {
            return null;
        }
        List<Integer> list = new ArrayList<Integer>();
        //红包最大金额为平均金额的TIMES倍
        int max = (int) (money * TIMES / count);
        max = max > MAXMONEY ? MAXMONEY : max;
        for (int i = 0; i < count; i++) {
            int one = random(money, MINMONEY, max, count - i);
            list.add(one);
            System.out.println(one);
            money -= one;
        }
        return list;
    }

    /**
     * @param money
     * @param minS
     * @param maxS
     * @param count
     * @return
     * @Author:lulei
     * @Description: 随机红包额度
     */
    private int random(int money, int minS, int maxS, int count) {
        //红包数量为1，直接返回金额
        if (count == 1) {
            return money;
        }
        //如果最大金额和最小金额相等，直接返回金额
        if (minS == maxS) {
            return minS;
        }
        int max = maxS > money ? money : maxS;
        //随机产生一个红包
        int one = ((int)Math.rint(Math.random() * (max - minS) + minS))  % max + 1;
        int money1 = money - one;
        //判断该种分配方案是否正确
        if (isRight(money1, count -1)) {
            return one;
        } else {
            double avg = money1 / (count - 1);
            if (avg < MINMONEY) {
                //递归调用，修改红包最大金额
                return random(money, minS, one, count);
            }else if (avg > MAXMONEY) {
                //递归调用，修改红包最小金额
                return random(money, one, maxS, count);
            }
        }
        return one;
    }

    /**
     * @param money
     * @param count
     * @return
     * @Author:lulei
     * @Description: 此种红包是否合法
     */
    private boolean isRight(int money, int count) {
        double avg = money / count;
        if (avg < MINMONEY) {
            return false;
        }
        if (avg > MAXMONEY) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RedPacketUtil util = new RedPacketUtil();
        System.out.println(util.splitRedPackets(30, 8));
    }
}
