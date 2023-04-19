package com.zhku.acl.schedule;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhku.acl.entity.User;
import com.zhku.acl.entity.dto.ResultDto;
import com.zhku.acl.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author WZX
 * 定时任务，每7天获取1次token
 * @since 2022-10-25
 */
public class GetToken {

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private UserMapper userMapper;

    @Scheduled(cron = "0 0 0 1,7,13,19,26 * ?")
    public void getToken(){
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

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("account", "仲恺鹅厂");
        User user = userMapper.selectOne(wrapper);
        //判断数据库中是否存在此用户
        //若不存在将用户存入数据库
        //若存在则更新token
        if (user == null){
            User user1 = new User();
            user1.setName("仲恺鹅厂");
            user1.setAccount("仲恺鹅厂");
            user1.setPassword("888888");
            user1.setToken(tokenDto.getData().getToken());
            userMapper.insert(user1);
        }else {
            user.setToken(tokenDto.getData().getToken());
            userMapper.updateById(user);
        }

        //每次更新token时重新订阅硬件设备的数据
//        String url1 = "http://47.106.171.221:8064/waterfowl/monitor-data/subscribe";
//        restTemplate.postForObject(url1,5559L, String.class);
//        restTemplate.postForObject(url1,5560L, String.class);
    }
}
