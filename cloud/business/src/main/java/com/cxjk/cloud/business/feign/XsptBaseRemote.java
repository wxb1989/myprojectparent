package com.cxjk.cloud.business.feign;

import com.alibaba.fastjson.JSONObject;
import com.cxjk.cloud.business.configurations.FeignMultipartSupportConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@FeignClient(name = "xspt-base", configuration = FeignMultipartSupportConfiguration.class,
        fallbackFactory = XsptBaseRemoteFactory.class
)
public interface XsptBaseRemote {

    @GetMapping(value = "/apis/amazonS3/listObject")
    List<String> listObject();

    @GetMapping(value = "/apis/amazonS3/getFile")
    ResponseEntity<byte[]> getFile(@RequestParam("s3Path") String s3Path);

    @PutMapping(value = "/apis/amazonS3/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String uploadFile(@RequestPart(value = "file") MultipartFile file, @RequestParam("appName") String appName, @RequestParam("fileType") String fileType, @RequestParam("serviceName") String serviceName);

    @DeleteMapping(value = "/apis/amazonS3/deleteFile")
    String deleteFile(@RequestParam("s3Path") String s3Path);

    @GetMapping(value = "/apis/amazonS3/generateUrl")
    String generateUrl(@RequestParam("s3Path") String s3Path);

    @GetMapping(value = "/apis/amazonS3/generateUrlTimeLimit")
    String generateUrlTimeLimit(@RequestParam("s3Path") String s3Path, @RequestParam("seconds") int seconds);

    @PostMapping(value = "/apis/sms/sendSMS")
    boolean sendSMS(@RequestParam("mobile") String mobile, @RequestParam("tempId") String tempId, @RequestParam("content") String content);

    //ocr识别的几个接口
    @PostMapping(value = "/apis/ocr/bankCard", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    JSONObject uploadOcrBankCardFile(@RequestPart(value = "file") MultipartFile file);

    @PostMapping(value = "/apis/ocr/idCardFace", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    JSONObject uploadOcrIdCardFaceFile(@RequestPart(value = "file") MultipartFile file);

    @PostMapping(value = "/apis/ocr/idCardBack", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    JSONObject uploadOcrIdCardBackFile(@RequestPart(value = "file") MultipartFile file);
}
