package com.cxjk.cloud.business.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
/**
 * @author
 * @package com.cxjk.cloud.business.service
 * @description
 * @create 2019-12-24 15:30
 **/
@Service
public class ServiceB {
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insert(){
    }
}
