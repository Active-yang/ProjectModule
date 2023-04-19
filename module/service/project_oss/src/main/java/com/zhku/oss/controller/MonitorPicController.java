package com.zhku.oss.controller;


import com.zhku.commonutils.R;
import com.zhku.oss.entity.Dto.MonitorPicDto;
import com.zhku.oss.service.MonitorPicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wzx
 * @since 2022-09-22
 */
@RestController
@RequestMapping("/oss/monitor-pic")
@Api(tags ="监控图片接口")
@CrossOrigin
public class MonitorPicController {

    @Autowired
    private MonitorPicService monitorPicService;

    @ApiOperation(value = "获取所有监控图片信息")
    @PostMapping("getPic")
    public R getAllPic(@RequestBody MonitorPicDto monitorPicDto){
        return monitorPicService.getAllPic(monitorPicDto);
    }
}
