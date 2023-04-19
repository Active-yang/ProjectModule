package com.zhku.oss.controller;

import com.zhku.commonutils.R;
import com.zhku.oss.service.OssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author WZX
 * @since 2022-09-17 14：21
 */
@RestController
@RequestMapping("/eduoss/fileoss")
@Api(tags ="阿里云oss接口")
@CrossOrigin
public class OssController {

    @Autowired
    private OssService ossService;

    @ApiOperation(value = "上传图片到oss")
    @PostMapping("uploadOssFile")
    public R uploadOssFile(MultipartFile file) {
        //返回上传到oss的路径
        return ossService.uploadOss(file);
    }
}
