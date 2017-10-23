package com.wangxuebing.design.chain.example;

import org.apache.commons.lang.time.FastDateFormat;

import java.util.Date;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-20 16:47
 **/
public class Boss extends Manager{

    public Boss(String name) {
        super(name);
    }

    @Override
    protected void requestApplication(Request request) {
        String processingTime = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println(String.format("审批人:%s 内容:%s 数量%s 被批准 审批时间%s", name, request.getContent(),
                request.getNum(), processingTime));

    }
}
