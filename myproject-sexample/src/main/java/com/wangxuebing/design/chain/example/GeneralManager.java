package com.wangxuebing.design.chain.example;

import org.apache.commons.lang.time.FastDateFormat;

import java.util.Date;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-20 16:45
 **/
public class GeneralManager extends  Manager {

    public GeneralManager(String name) {
        super(name);
    }

    @Override
    protected void requestApplication(Request request) {
        if ("请假".equals(request.getType())) {
            String processingTime = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(new Date());
            System.out.println(String.format("审批人:%s 内容:%s 数量%s 被批准 审批时间%s", name, request.getContent(),
                    request.getNum(), processingTime));
            return;
        }
        if ("加薪".equals(request.getType()) && request.getNum() <= 500) {
            String processingTime = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(new Date());
            System.out.println(String.format("审批人:%s 内容:%s 数量%s 被批准 审批时间%s", name, request.getContent(),
                    request.getNum(), processingTime));
            return;
        }


        if(superior!=null){
            superior.requestApplication(request);
        }
    }
}
