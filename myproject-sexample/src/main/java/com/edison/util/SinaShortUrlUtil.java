package com.edison.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class SinaShortUrlUtil {

    public static void main(String[] args) {
        String longUrl="https://gitee.com/zuihou111/zuihou-admin-cloud/tree/master";
        System.out.println(getSinaShortUrl( longUrl));
    }

    /**
     * 获取新浪短链
     *
     * @param longUrl 长链
     * @return 新浪短链
     */
    public static String getSinaShortUrl(String longUrl) {
        if (StringUtils.isBlank(longUrl)) {
            return "";
        }
        String url = "";
        try {
            /*
            5786724301 ==> iphone新浪微博客户端
            2849184197 ==> iPad新浪客户端
            1206405345 ==> Google.Nexus浪客户端
            202088835  ==> 周博通微博管家
            211160679  ==> Weico
             */
            HttpGet httpGet = new HttpGet("http://api.weibo.com/2/short_url/shorten.json?&source=202088835&url_long=" + longUrl);
            httpGet.addHeader("Accept-Encoding", "gzip, deflate");
            CloseableHttpResponse execute = HttpClients.custom().build().execute(httpGet);
            String result = EntityUtils.toString(execute.getEntity(), "UTF-8");
            JSONObject jsonObject = JSONObject.parseObject(result);
            Object o = jsonObject.getJSONArray("urls").get(0);
            url = ((JSONObject) o).getString("url_short");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }
}
