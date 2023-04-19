package com.zhku.acl;

import com.zhku.acl.entity.dto.ResultDto;
import org.springframework.http.HttpEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class Test1 {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        //第三方API的url
        String url = "https://m.hoire.cn/open/token/get";

        //处理时间戳
        String s = String.valueOf(System.currentTimeMillis());
        StringBuffer stringBuffer = new StringBuffer(s);
        String substring = stringBuffer.substring(0,10);
        System.out.println(substring);
        Long aLong = Long.valueOf(substring);

        //设置传入参数
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("account", "仲恺鹅厂");
        body.add("password", "888888");
        body.add("timestamp", aLong);
        //包装传入参数
        HttpEntity<MultiValueMap<String, Object>> entityParam = new HttpEntity<>(body);

        //调用第三方API
        ResultDto tokenDto = restTemplate.postForObject(url, entityParam, ResultDto.class);
        System.out.println(tokenDto.getData().getToken());
    }
}
