package com.cxjk.cloud.business.common;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.net.URISyntaxException;
import java.util.*;

/**
 * @author
 * @package com.cxjk.cloud.business.common
 * @description
 * @create 2019-12-03 9:11
 **/
@RestController
public class CommonController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    @LoadBalanced
    private RestTemplate loadBalanced;

    @RequestMapping(value = "/apis/common/callService")
    @ResponseBody
    public Object callService(@RequestParam String apiServiceId, @RequestParam String apiPath, HttpServletRequest request) throws URISyntaxException {
        Map map = new HashMap(6);
        List<String> services = discoveryClient.getServices();
        if (!services.contains(apiServiceId)) {
            map.put("code", "9001");
            map.put("msg", "service not exist!");
            return map;
        }
        String method = request.getMethod();
        apiPath = apiPath.startsWith("/") ? apiPath : "/" + apiPath;
        String uri = "http://" + apiServiceId + apiPath;
        Enumeration em = request.getParameterNames();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        while (em.hasMoreElements()) {
            String name = (String) em.nextElement();
            if (StringUtils.equals("apiServiceId", name) || StringUtils.equals("apiPath", name)) {
                continue;
            }
            String value = request.getParameter(name);
            params.add(name, value);
        }
        URIBuilder uriBuilder = new URIBuilder(uri);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", request.getHeader("Authorization"));
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, headers);
        if (StringUtils.equals(HttpMethod.GET.name(), method.toUpperCase()) || StringUtils.equals(HttpMethod.DELETE.name(), method.toUpperCase())) {
            List<NameValuePair> list = new LinkedList();
            params.forEach((k, v) -> {
                BasicNameValuePair param = new BasicNameValuePair(k, v.get(0));
                list.add(param);

            });
            uriBuilder.setParameters(list);
        }
        try {
            String result = loadBalanced.exchange(uriBuilder.build(), Objects.requireNonNull(HttpMethod.resolve(method.toUpperCase())), entity, String.class).getBody();
            return JSON.parse(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            map.put("code", "9002");
            map.put("msg", e.getMessage());
            return map;
        }
    }
}
