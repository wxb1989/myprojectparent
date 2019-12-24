package com.cxjk.cloud.business.common;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.URISyntaxException;
import java.util.*;

/**
 * @author
 * @package com.cxjk.cloud.business.common
 * @description
 * @create 2019-12-24 11:22
 **/
@RestController
public class HellowController {

    @RequestMapping(value = "/apis/hellow/cal")
    @ResponseBody
    public Map callService() {
        Map map = new HashMap();
        map.put("aaa","aaa");
        return map;
    }
}
