package com.edison.servicelimit;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static java.lang.Thread.currentThread;

/**
 * @author
 * @package com.edison.servicelimit
 * @description
 * 令牌桶算法。相比漏桶算法而言区别在于，令牌桶是会去匀速的生成令牌，拿到令牌才能够进行处理，类似于匀速往桶里放令牌
 *  漏桶算法是：生产者消费者模型，生产者往木桶里生产数据，消费者按照定义的速度去消费数据
 *
 *   应用场景：
 *  漏桶算法：必须读写分流的情况下，限制读取的速度
 *  令牌桶算法：必须读写分离的情况下，限制写的速率  只卖1分种抢购1000
 *
 *   实现的方法都是一样。RateLimiter来实现
 *   对于多线程问题查找时，很多时候可能使用的类都是原子性的，但是由于代码逻辑的问题，也可能发生线程安全问题
 * @create 2019-12-24 10:06
 **/
public class TokenBuck {

    //可以使用 AtomicInteger+容量  可以不用Queue实现
    private AtomicInteger phoneNumbers=new AtomicInteger(0);
    private RateLimiter rateLimiter= RateLimiter.create(20d);//一秒只能执行五次
    //默认销售500台
    private final static int DEFALUT_LIMIT=500;
    private final int saleLimit;

    public TokenBuck(int saleLimit) {
        this.saleLimit = saleLimit;
    }

    public TokenBuck() {
        this(DEFALUT_LIMIT);
    }

    public int buy(){
        //这个check 必须放在success里面做判断，不然会产生线程安全问题(业务引起)
        //原因当phoneNumbers=99 时 同时存在三个线程进来。虽然phoneNumbers原子性，但是也会发生。如果必须写在这里，在success
        //里面也需要加上double check
       /* if (phoneNumbers.get()>=saleLimit){
            throw new IllegalStateException("Phone has been sale "+saleLimit+" can not  buy more...")
        }*/

        //目前设置超时时间，10秒内没有抢到就抛出异常
        //这里的TimeOut*Ratelimiter=总数  这里的超时就是让别人抢几秒，所以设置总数也可以由这里的超时和RateLimiter来计算
        boolean success = rateLimiter.tryAcquire(10, TimeUnit.SECONDS);
        if (success){
            if (phoneNumbers.get()>=saleLimit){
                throw new IllegalStateException("Phone has been sale "+saleLimit+" can not  buy more...");
            }
            int phoneNo = phoneNumbers.getAndIncrement();
            System.out.println(currentThread()+" user has get :["+phoneNo+"]");
            return phoneNo;
        }else {
            //超时后 同一时间，很大的流量来强时，超时快速失败。
            throw new RuntimeException(currentThread()+"has timeOut can try again...");
        }

    }
    public static void main(String[] args) {
        final TokenBuck tokenBuck=new TokenBuck(200);


        IntStream.range(0,300).forEach(i->{
            //目前测试时，让一个线程抢一次，不用循环抢
            //tokenBuck::buy 这种方式 产生一个Runnable
            new Thread(tokenBuck::buy).start();
        });
    }

}
