package com.cxjk.cloud.business.feign;

import com.alibaba.fastjson.JSONObject;
import com.amazonaws.services.s3.model.Bucket;
import feign.hystrix.FallbackFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author
 * @package com.cxjky.xspt.common.FeignRemote
 * @description api项目服务熔断处理工厂
 *eate 2019-10-26 13:44
 **/
@Component
public class XsptBaseRemoteFactory implements FallbackFactory<XsptBaseRemote> {

    @Override
    public XsptBaseRemote create(Throwable throwable) {
        return new XsptBaseRemote() {
            @Override
            public String getMaxNo() {
                System.out.println("  服务降级" + throwable);
                return "";
            }

            @Override
            public List<Bucket> listBucket() {
                return null;
            }

            @Override
            public List<String> listObject() {
                return null;
            }

            @Override
            public ResponseEntity<byte[]> getFile(String s3Path) {
                return null;
            }

            @Override
            public String uploadFile(MultipartFile file, String appName, String fileType, String serviceName) {
                return "服务降级";
            }

            @Override
            public String deleteFile(String s3Path) {
                return "deleteFile 服务降级或被熔断";
            }

            @Override
            public String generateUrl(String s3Path) {
                return "generateUrl 服务降级或被熔断";
            }

            @Override
            public String generateUrlTimeLimit(String s3Path, int seconds) {
                return "generateUrlTimeLimit 服务降级或被熔断";
            }

            @Override
            public boolean sendSMS(String mobile, String tempId, String content) {
                return false;
            }

            @Override
            public JSONObject uploadOcrBankCardFile(MultipartFile file) {
                return new JSONObject();
            }

            @Override
            public JSONObject uploadOcrIdCardFaceFile(MultipartFile file) {
                return new JSONObject();
            }

            @Override
            public JSONObject uploadOcrIdCardBackFile(MultipartFile file) {
                return new JSONObject();
            }
        };
    }
}
