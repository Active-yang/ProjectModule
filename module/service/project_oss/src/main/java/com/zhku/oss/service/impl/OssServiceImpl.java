package com.zhku.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.zhku.commonutils.R;
import com.zhku.oss.service.OssService;
import com.zhku.oss.utils.ConstantPropertiesUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author WZX
 * @since 2022-09-17
 */
@Service
public class OssServiceImpl implements OssService {

    @Override
    public R uploadOss(MultipartFile file) {
        String endpoint = ConstantPropertiesUtils.ENDPOINT;
        String accessKeyId = ConstantPropertiesUtils.KEYID;
        String accessKeySecret = ConstantPropertiesUtils.KEYSECRET;
        String bucketName = ConstantPropertiesUtils.BUCKETNAME;
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        // 填写Object完整路径，完整路径中不能包含Bucket名称，例如exampledir/exampleobject.txt。
        String objectName = "waterfowl/" + uuid + file.getOriginalFilename();
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            InputStream inputStream = file.getInputStream();
            // 创建PutObject请求。
            ossClient.putObject(bucketName, objectName, inputStream);
            //https://waterfowl.oss-cn-guangzhou.aliyuncs.com/QQ%E5%9B%BE%E7%89%8720220421234108.jpg
            return R.ok().data("url", "https://" + bucketName + "." + endpoint + "/" + objectName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return null;
    }

}
