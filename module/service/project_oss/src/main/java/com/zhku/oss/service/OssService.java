package com.zhku.oss.service;

import com.zhku.commonutils.R;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author WZX
 * @since 2022-09-17
 */
public interface OssService {

    /**
     * 上传图片到oss
     * @param file 图片
     * @return 图片路径
     */
    R uploadOss(MultipartFile file);

}
